package com.cblandon.inversiones.cliente.controller;

import com.cblandon.inversiones.cliente.servicio.ClienteService;
import com.cblandon.inversiones.cliente.dto.RegistrarClienteDTO;
import com.cblandon.inversiones.utils.dto.GenericResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;


    @PostMapping("/registrar-cliente")
    @PreAuthorize("hasAnyRole(@rolesService.consultarPermisoRoles(101))")
    public ResponseEntity<GenericResponseDTO> registrarCliente(
            @RequestPart("cliente") String clienteJson,  // Recibimos el JSON como String
            @RequestPart(value = "imagenes", required = false) List<MultipartFile> imagenes) throws JsonProcessingException {
        // Convertir el String JSON en el objeto DTO
        ObjectMapper objectMapper = new ObjectMapper();
        RegistrarClienteDTO registrarClienteDTO = objectMapper.readValue(clienteJson, RegistrarClienteDTO.class);

        // Procesar la lógica con registrarClienteDTO y las imágenes
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
            @PathVariable Integer id, @Valid @RequestBody RegistrarClienteDTO registrarClienteDTO) {

        return GenericResponseDTO.genericResponse(clienteService.actualizarCliente(id, registrarClienteDTO));
    }

    @DeleteMapping("/eliminarCliente/{idCliente}")
    @PreAuthorize("hasAnyRole('SUPER')")
    public ResponseEntity<String> eliminarCliente(@PathVariable int idCliente) {
        clienteService.deleteCliente(idCliente);
        return new ResponseEntity<>("Empleado eliminado exitosamente", HttpStatus.OK);
    }
}
