package com.cblandon.inversiones.cliente.servicio;

import com.cblandon.inversiones.cliente.dto.ClienteAllResponseDTO;
import com.cblandon.inversiones.cliente.dto.ClienteResponseDTO;
import com.cblandon.inversiones.cliente.dto.ClientesCuotaCreditoDTO;
import com.cblandon.inversiones.cliente.dto.RegistrarClienteDTO;
import com.cblandon.inversiones.cliente.entity.Cliente;
import com.cblandon.inversiones.cliente.repository.ClienteRepository;
import com.cblandon.inversiones.excepciones.NoDataException;
import com.cblandon.inversiones.excepciones.RequestException;
import com.cblandon.inversiones.imagen_cliente.entity.ImagenCliente;
import com.cblandon.inversiones.imagen_cliente.repository.ImagenClienteRepository;
import com.cblandon.inversiones.imagen_cliente.servicio.ImagenClienteService;
import com.cblandon.inversiones.mapper.Mapper;
import com.cblandon.inversiones.utils.MensajesErrorEnum;
import com.cblandon.inversiones.utils.UtilsMetodos;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ImagenClienteService imagenClienteService;
    private final ImagenClienteRepository imagenClienteRepository;


    @Transactional
    public ClienteResponseDTO registrarCliente(RegistrarClienteDTO registrarClienteDTO, List<MultipartFile> imagenes) {

        if (clienteRepository.findByCedula(registrarClienteDTO.cedula()).isPresent()) {
            throw new RequestException(
                    MensajesErrorEnum.DOCUMENTO_DUPLICADO);
        }
        try {
            Cliente cliente = Mapper.mapper.registrarClienteDTOToCliente(registrarClienteDTO);
            cliente.setUsuariocreador(UtilsMetodos.obtenerUsuarioLogueado());

            List<ImagenCliente> imagenesProcesadas = imagenClienteService.procesarImagenes(imagenes, cliente, false);
            cliente.setImagenes(imagenesProcesadas);

            return Mapper.mapper.clienteToClienteResponseDto(clienteRepository.save(cliente));

        } catch (RequestException e) {
            throw new RequestException(e.getMensajesErrorEnum());
        } catch (RuntimeException | IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }

    }

    @Transactional(readOnly = true)
    public List<ClienteAllResponseDTO> allClientes() {
        try {

            List<Cliente> clientes = clienteRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));

            return clientes.stream().map(
                    Mapper.mapper::clienteToClienteAllResponseDto).toList();

        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }

    }

    @Transactional(readOnly = true)
    public ClienteResponseDTO consultarCliente(String cedula) {

        Cliente clienteBD = clienteRepository.findByCedula(cedula).orElseThrow(
                () -> new NoDataException(MensajesErrorEnum.DATOS_NO_ENCONTRADOS));

        try {

            return Mapper.mapper.clienteToClienteResponseDto(clienteBD);

        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }


    }

    @Transactional
    public ClienteResponseDTO actualizarCliente(Integer id, RegistrarClienteDTO registrarClienteDTO,
                                                List<MultipartFile> imagenes) {

        Cliente clienteBD = clienteRepository.findById(id).orElseThrow(
                () -> new NoDataException(MensajesErrorEnum.DATOS_NO_ENCONTRADOS));

        try {

            Cliente clienteModificado = Mapper.mapper.registrarClienteDTOToCliente(registrarClienteDTO);
            clienteModificado.setId(clienteBD.getId());
            List<ImagenCliente> imagenesProcesadas = imagenClienteService.procesarImagenes(
                    imagenes, clienteModificado, true);
            clienteModificado.setImagenes(imagenesProcesadas);
            clienteModificado.setUsuariomodificador(UtilsMetodos.obtenerUsuarioLogueado());
            clienteModificado.setUsuariocreador(clienteBD.getUsuariocreador());
            clienteModificado.setFechacreacion(clienteBD.getFechacreacion());

            return Mapper.mapper.clienteToClienteResponseDto(clienteRepository.save(clienteModificado));

        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Transactional
    public void deleteCliente(int idCliente) {
        if (clienteRepository.findById(idCliente).isEmpty()) {
            throw new NoDataException(MensajesErrorEnum.DATOS_NO_ENCONTRADOS);
        }
        clienteRepository.deleteById(idCliente);

    }

    /**
     * lista de cuotas pendientes de la fecha seleccionada para atras
     */
    @Transactional(readOnly = true)
    public List<ClientesCuotaCreditoDTO> consultarClientesCuotasPendientes(LocalDate fechaFiltro, int idUsuario) {

        try {
            return clienteRepository.consultarClientesCuotasPendientes(fechaFiltro, idUsuario);

        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }

    }

    @Transactional(readOnly = true)
    public ClienteResponseDTO consultarClientePorIdImagenes(Integer id) {

        Cliente clienteBD = clienteRepository.findById(id).orElseThrow(
                () -> new NoDataException(MensajesErrorEnum.DATOS_NO_ENCONTRADOS));

        List<ImagenCliente> imagenes = imagenClienteRepository.findByClienteId(id);

        try {
            clienteBD.setImagenes(imagenes);
            return Mapper.mapper.clienteToClienteResponseDto(clienteBD);

        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }


    }
}
