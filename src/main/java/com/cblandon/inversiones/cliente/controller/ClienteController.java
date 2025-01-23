package com.cblandon.inversiones.cliente.controller;

import com.cblandon.inversiones.cliente.servicio.ClienteService;
import com.cblandon.inversiones.cliente.dto.RegistrarClienteDTO;
import com.cblandon.inversiones.utils.dto.GenericResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final Validator validator;
    ObjectMapper objectMapper = new ObjectMapper();


    @PostMapping("/registrar-cliente")
    @PreAuthorize("hasAnyRole(@rolesService.consultarPermisoRoles(101))")
    public ResponseEntity<GenericResponseDTO> registrarCliente(
            @RequestPart("cliente") String clienteJson,  // Recibimos el JSON como String
            @RequestPart(value = "imagenes", required = false) List<MultipartFile> imagenes) throws JsonProcessingException {

        RegistrarClienteDTO registrarClienteDTO = objectMapper.readValue(clienteJson, RegistrarClienteDTO.class);

        ResponseEntity<GenericResponseDTO> responseError = validarFormulario(registrarClienteDTO);
        if (responseError != null) {
            return responseError;
        }

        return GenericResponseDTO.genericResponse(clienteService.registrarCliente(registrarClienteDTO, imagenes));
    }

    @GetMapping("/consultar-clientes")
    @PreAuthorize("hasAnyRole(@rolesService.consultarPermisoRoles(102))")
    public ResponseEntity<GenericResponseDTO> consultarClientes() {
        return GenericResponseDTO.genericResponse(clienteService.allClientes());
    }

    @GetMapping("/consultar-cliente-por-cedula/{cedula}")
    @PreAuthorize("hasAnyRole(@rolesService.consultarPermisoRoles(103))")
    public ResponseEntity<GenericResponseDTO> consultarCliente(@PathVariable String cedula) {
        return GenericResponseDTO.genericResponse(clienteService.consultarCliente(cedula));


    }

    @GetMapping("/consultar-cuotas-por-fecha/{fechaFiltro}/{idUsuario}")
    @PreAuthorize("hasAnyRole(@rolesService.consultarPermisoRoles(302))")
    public ResponseEntity<GenericResponseDTO> consultarCuotasPorFechas(
            @PathVariable String fechaFiltro, @PathVariable int idUsuario) {
        return GenericResponseDTO.genericResponse(
                clienteService.consultarClientesCuotasPendientes(LocalDate.parse(fechaFiltro), idUsuario));
    }

    @PutMapping("/actualizar-cliente/{id}")
    @PreAuthorize("hasAnyRole(@rolesService.consultarPermisoRoles(104))")
    public ResponseEntity<GenericResponseDTO> actualizarCliente(
            @PathVariable Integer id,
            @RequestPart("cliente") String clienteJson,  // Recibimos el JSON como String
            @RequestPart(value = "imagenes", required = false) List<MultipartFile> imagenes) throws JsonProcessingException {

        RegistrarClienteDTO registrarClienteDTO = objectMapper.readValue(clienteJson, RegistrarClienteDTO.class);
        ResponseEntity<GenericResponseDTO> responseError = validarFormulario(registrarClienteDTO);

        if (responseError != null) {
            return responseError;
        }

        return GenericResponseDTO.genericResponse(clienteService.actualizarCliente(id, registrarClienteDTO, imagenes));
    }

    @DeleteMapping("/eliminarCliente/{idCliente}")
    @PreAuthorize("hasAnyRole('SUPER')")
    public ResponseEntity<String> eliminarCliente(@PathVariable int idCliente) {
        clienteService.deleteCliente(idCliente);
        return new ResponseEntity<>("Empleado eliminado exitosamente", HttpStatus.OK);
    }

    @GetMapping("/consultar-cliente-por-id-imagenes/{id}")
    @PreAuthorize("hasAnyRole(@rolesService.consultarPermisoRoles(107))")
    public ResponseEntity<GenericResponseDTO> consultarClientePorIdImagenes(@PathVariable Integer id) {
        return GenericResponseDTO.genericResponse(clienteService.consultarClientePorIdImagenes(id));
    }

    private ResponseEntity<GenericResponseDTO> validarFormulario(RegistrarClienteDTO registrarClienteDTO) {

        // Validar manualmente despues de convertir el string a objeto
        Set<ConstraintViolation<RegistrarClienteDTO>> violations = validator.validate(registrarClienteDTO);
        if (!violations.isEmpty()) {
            String errores = violations.stream()
                    .map(v -> v.getPropertyPath() + ": " + v.getMessage())
                    .reduce((e1, e2) -> e1 + ", " + e2)
                    .orElse("Error de validación");
            return GenericResponseDTO.formResponseError(errores, HttpStatus.NOT_FOUND);
        }
        return null;
    }


}
