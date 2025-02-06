package com.cblandon.inversiones.cliente.dto;

import com.cblandon.inversiones.credito.dto.CreditoResponseDTO;
import com.cblandon.inversiones.imagen_cliente.dto.ImagenDTO;
import com.cblandon.inversiones.imagen_cliente.entity.ImagenCliente;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.List;
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteRespuestaDTO {

    Integer id;
    String nombres;
    String apellidos;
    String celular;
    String cedula;
    String direccion;
    String observaciones;
    List<CreditoResponseDTO> listaCreditos;
    List<ImagenDTO> imagenes;

    public ClienteRespuestaDTO(Integer id, String nombres, String apellidos, String celular, String cedula,
                               String direccion, String observaciones) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.cedula = cedula;
        this.direccion = direccion;
        this.observaciones = observaciones;
    }
}
