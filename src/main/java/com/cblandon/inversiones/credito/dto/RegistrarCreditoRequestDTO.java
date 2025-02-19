package com.cblandon.inversiones.credito.dto;


import com.cblandon.inversiones.modalidad.entity.Modalidad;
import com.cblandon.inversiones.utils.Constantes;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record RegistrarCreditoRequestDTO(@NotNull(message = Constantes.NOT_NULL)
                                         Double interesPorcentaje,

                                         @NotNull(message = Constantes.NOT_NULL)
                                         Integer cantidadCuotas,

                                         String cedulaTitularCredito,

                                         //@JsonFormat(pattern = "dd/MM/yyyy")
                                         LocalDate fechaCuota,

                                         //@JsonFormat(pattern = "dd/MM/yyyy")
                                         LocalDate fechaCredito,
                                         @NotNull(message = Constantes.NOT_NULL)
                                         Double valorCredito,
                                         Modalidad modalidad,
                                         String usuario,
                                         Integer diasMora,
                                         Double valorMora,
        /*
         * estos parametros solo se envian si se va a realizar una renovacion de credito
         */
                                         boolean renovacion, Double valorRenovacion,
                                         Integer idCreditoActual, Integer idCliente
) {
}
