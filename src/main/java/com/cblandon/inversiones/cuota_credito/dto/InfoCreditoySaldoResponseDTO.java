package com.cblandon.inversiones.cuota_credito.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InfoCreditoySaldoResponseDTO {


    private Integer id;

    private Double valorCuota;

    private LocalDate fechaCuota;

    private Integer numeroCuotas;

    private Integer cuotaNumero;

    private Double valorInteres;

    private Double valorCredito;

    private Double interesPorcentaje;

    private LocalDate fechaCredito;

    private Double interesHoy;

    private Double saldoCredito;

    private Double capitalPagado;

    private String ultimaCuotaPagada;

    private String tipoAbono;

    private Boolean abonoExtra;

    private double abonoExtraPagado;

    private double interesMora;

    private String modalidad;

    private double saldoCapital;

    private String diasMora;

    private Double valorMora;


}
