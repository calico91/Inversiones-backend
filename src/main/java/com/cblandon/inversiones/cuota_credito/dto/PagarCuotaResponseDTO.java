package com.cblandon.inversiones.cuota_credito.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PagarCuotaResponseDTO {

    Integer id;
    Integer cantidadCuotas;
    Double valorAbonado;
    String tipoAbono;
    Integer cuotasPagadas;
    String fechaAbono;
    Double saldoCapital;

}
