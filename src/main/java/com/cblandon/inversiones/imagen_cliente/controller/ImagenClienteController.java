package com.cblandon.inversiones.imagen_cliente.controller;

import com.cblandon.inversiones.imagen_cliente.servicio.ImagenClienteService;
import com.cblandon.inversiones.utils.dto.GenericResponseDTO;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/imagenes-cliente")
public class ImagenClienteController {

    private final ImagenClienteService imagenClienteService;


    @GetMapping("/consultar-imagenes-por-id-cliente/{id-cliente}")
    @PreAuthorize("hasAnyRole(@rolesService.consultarPermisoRoles(105))")
    public ResponseEntity<GenericResponseDTO> consultarImagenesCliente(
            @PathVariable("id-cliente") Integer idCliente
    ) {
        return GenericResponseDTO.genericResponse(imagenClienteService.obtenerImagenes(idCliente));
    }

}
