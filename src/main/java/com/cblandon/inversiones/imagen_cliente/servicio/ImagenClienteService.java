package com.cblandon.inversiones.imagen_cliente.servicio;

import com.cblandon.inversiones.cliente.entity.Cliente;
import com.cblandon.inversiones.cliente.repository.ClienteRepository;
import com.cblandon.inversiones.excepciones.NoDataException;
import com.cblandon.inversiones.excepciones.RequestException;
import com.cblandon.inversiones.imagen_cliente.dto.ImagenDTO;
import com.cblandon.inversiones.imagen_cliente.entity.ImagenCliente;
import com.cblandon.inversiones.imagen_cliente.repository.ImagenClienteRepository;
import com.cblandon.inversiones.imagen_cliente.util.MultipartFileCustom;
import com.cblandon.inversiones.utils.MensajesErrorEnum;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.MetadataException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Base64;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifDirectoryBase;


@Service
@Slf4j
@AllArgsConstructor
public class ImagenClienteService {

    private final ImagenClienteRepository imagenClienteRepository;
    private final ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<ImagenDTO> obtenerImagenes(Integer clienteId) {

        List<ImagenCliente> imagenes = imagenClienteRepository.findByClienteId(clienteId);

        if (imagenes.isEmpty()) {
            throw new NoDataException(MensajesErrorEnum.DATOS_NO_ENCONTRADOS);
        }

        List<ImagenDTO> imagenesDecodificadas = new ArrayList<>();
        for (ImagenCliente imagen : imagenes) {
            byte[] decodedImage = decodeBase64(imagen.getBase64Data());
            ImagenDTO dto = new ImagenDTO(decodedImage, imagen.getExtension());

            imagenesDecodificadas.add(dto);
        }

        return imagenesDecodificadas;
    }

    @Transactional
    public String guardarModificarImagenes(Integer clienteId, List<MultipartFile> imagenes) {

        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(
                () -> new NoDataException(MensajesErrorEnum.DATOS_NO_ENCONTRADOS));

        try {

            imagenClienteRepository.deleteByClienteId(clienteId);
            imagenClienteRepository.saveAll(procesarImagenes(imagenes, cliente, true));

            return "Imagenes almacenadas correctamente";

        } catch (RequestException e) {
            throw new RequestException(e.getMensajesErrorEnum());
        } catch (RuntimeException | IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }


    public List<ImagenCliente> procesarImagenes(List<MultipartFile> imagenes, Cliente cliente, Boolean estaEditando)
            throws IOException, RequestException {

        if (imagenes != null && imagenes.size() > 6) {
            throw new RequestException(MensajesErrorEnum.CANTIDAD_IMAGENES_NO_VALIDA);
        }

        if (estaEditando) {
            imagenClienteRepository.deleteByClienteId(cliente.getId());
        }


        List<ImagenCliente> imagenesCliente = new ArrayList<>();
        if (imagenes != null && !imagenes.isEmpty()) {
            for (MultipartFile imagen : imagenes) {
                String extension = getExtension(imagen.getOriginalFilename());

                if (!esExtensionValida(extension)) {
                    throw new RequestException(MensajesErrorEnum.FORMATO_ARCHIVO_INVALIDO);
                }
                if (imagen.getSize() > 300 * 1024) { // Si la imagen supera los 300kb
                    imagen = reducirPesoImagen(imagen);
                }
                imagenesCliente.add(ImagenCliente.builder()
                        .base64Data(convertirABase64(imagen))
                        .extension(extension)
                        .cliente(cliente)
                        .build());
            }
        }

        return imagenesCliente;
    }

    private MultipartFile reducirPesoImagen(MultipartFile imagen) throws IOException {
        BufferedImage originalImage = ImageIO.read(imagen.getInputStream());

        // Ajustar orientación
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(imagen.getInputStream());
            ExifIFD0Directory directory = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
            if (directory != null && directory.containsTag(ExifDirectoryBase.TAG_ORIENTATION)) {
                int orientation = directory.getInt(ExifDirectoryBase.TAG_ORIENTATION);
                originalImage = validarOrientacion(originalImage, orientation);
            }
        } catch (RuntimeException e) {
            throw new RemoteException(e.getMessage()); // Manejo de excepciones
        } catch (ImageProcessingException | MetadataException e) {
            throw new RuntimeException(e);
        }

        // Redimensionar la imagen (opcional)
        int ancho = originalImage.getWidth();
        int alto = originalImage.getHeight();
        int nuevoAncho = Math.min(ancho, 1000); // Escalar a 1000px si es mayor
        int nuevoAlto = (nuevoAncho * alto) / ancho;

        Image resizedImage = originalImage.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
        BufferedImage bufferedResizedImage = new BufferedImage(nuevoAncho, nuevoAlto, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedResizedImage.createGraphics();
        g2d.drawImage(resizedImage, 0, 0, null);
        g2d.dispose();

        // Comprimir la imagen
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedResizedImage, "jpg", outputStream);

        return new MultipartFileCustom(imagen.getOriginalFilename(), outputStream.toByteArray());
    }

    private BufferedImage validarOrientacion(BufferedImage image, int orientation) {
        AffineTransform transform = new AffineTransform();

        switch (orientation) {
            case 1: // Normal
                return image;
            case 2: // Flip Y
                transform.scale(-1, 1);
                transform.translate(-image.getWidth(), 0);
                break;
            case 3: // Rotate 180 degrees
                transform.translate(image.getWidth(), image.getHeight());
                transform.rotate(Math.PI);
                break;
            case 4: // Flip X
                transform.scale(1, -1);
                transform.translate(0, -image.getHeight());
                break;
            case 5: // -90 degrees and Flip X
                transform.rotate(-Math.PI / 2);
                transform.scale(1, -1);
                break;
            case 6: // Rotate 90 degrees
                transform.translate(image.getHeight(), 0);
                transform.rotate(Math.PI / 2);
                break;
            case 7: // 90 degrees and Flip X
                transform.scale(-1, 1);
                transform.translate(-image.getHeight(), 0);
                transform.translate(0, image.getWidth());
                transform.rotate(3 * Math.PI / 2);
                break;
            case 8: // Rotate -90 degrees
                transform.translate(0, image.getWidth());
                transform.rotate(-Math.PI / 2);
                break;
            default:
                return image;
        }

        AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
        return op.filter(image, null);
    }

    private String convertirABase64(MultipartFile imagen) throws IOException {
        byte[] bytes = imagen.getBytes();
        return Base64.getEncoder().encodeToString(bytes);
    }

    private String getExtension(String filename) {
        if (filename != null && filename.contains(".")) {
            return filename.substring(filename.lastIndexOf(".") + 1);  // Extraer la extensión
        }
        return "";
    }

    private byte[] decodeBase64(String base64) {
        return Base64.getDecoder().decode(base64);
    }

    // Metodo para validar extensiones permitidas
    private boolean esExtensionValida(String extension) {
        List<String> extensionesPermitidas = Arrays.asList("jpg", "jpeg", "png", "gif", "bmp");
        return extensionesPermitidas.contains(extension);
    }

}
