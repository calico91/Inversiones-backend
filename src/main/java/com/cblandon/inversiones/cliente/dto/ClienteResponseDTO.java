package com.cblandon.inversiones.cliente.dto;

import com.cblandon.inversiones.credito.dto.CreditoResponseDTO;
import com.cblandon.inversiones.imagen_cliente.entity.ImagenCliente;
import com.fasterxml.jackson.annotation.JsonInclude;


import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ClienteResponseDTO(Integer id, String nombres, String apellidos, String celular, String cedula,
                                 String direccion, String observaciones, List<CreditoResponseDTO> listaCreditos,
                                 List<ImagenCliente> imagenes) {

}
