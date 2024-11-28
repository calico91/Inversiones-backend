package com.cblandon.inversiones.imagen_cliente.servicio;

import com.cblandon.inversiones.excepciones.NoDataException;
import com.cblandon.inversiones.imagen_cliente.entity.ImagenCliente;
import com.cblandon.inversiones.imagen_cliente.repository.ImagenClienteRepository;
import com.cblandon.inversiones.imagen_cliente.util.MultipartFileCustom;
import com.cblandon.inversiones.utils.MensajesErrorEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.Base64;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ImagenClienteService {

    private final ImagenClienteRepository imagenClienteRepository;

    @Transactional(readOnly = true)
    public List<byte[]> obtenerImagenes(Integer clienteId) {

        List<ImagenCliente> imagenes = imagenClienteRepository.findByClienteId(clienteId);

        if (imagenes.isEmpty()) {
            throw new NoDataException(MensajesErrorEnum.DATOS_NO_ENCONTRADOS);
        }

        List<byte[]> imagenesDecodificadas = new ArrayList<>();
        for (ImagenCliente imagen : imagenes) {
            byte[] decodedImage = decodeBase64(imagen.getBase64());
            imagenesDecodificadas.add(decodedImage);
        }

        return imagenesDecodificadas;
    }

    public List<ImagenCliente> procesarImagenes(List<MultipartFile> imagenes) throws IOException {

        List<ImagenCliente> imagenesCliente = new ArrayList<>();
        if (imagenes != null && !imagenes.isEmpty()) {
            for (MultipartFile imagen : imagenes) {
                String extension = getExtension(imagen.getOriginalFilename());
                if (imagen.getSize() > 300 * 1024) { // Si la imagen supera los 300kb
                    imagen = reducirPesoImagen(imagen);
                }
                imagenesCliente.add(ImagenCliente.builder()
                        .base64(convertirABase64(imagen))
                        .extension(extension)
                        .build());
            }
        }

        return imagenesCliente;
    }

    private MultipartFile reducirPesoImagen(MultipartFile imagen) throws IOException {
        BufferedImage originalImage = ImageIO.read(imagen.getInputStream());

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

}