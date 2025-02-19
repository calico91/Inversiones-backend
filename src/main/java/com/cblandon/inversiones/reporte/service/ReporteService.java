package com.cblandon.inversiones.reporte.service;

import com.cblandon.inversiones.cuota_credito.dto.AbonosRealizadosResponseDTO;
import com.cblandon.inversiones.cuota_credito.repository.CuotaCreditoRepository;
import com.cblandon.inversiones.reporte.dto.ReporteInteresCapitalDTO;
import jakarta.persistence.Tuple;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ReporteService {

    private final CuotaCreditoRepository cuotaCreditoRepository;


    /**
     * informacion del capital e interes generado segun el rengo de fechas seleccionado
     */
    @Transactional(readOnly = true)
    public ReporteInteresCapitalDTO generarReporteInteresCapital(String fechaInicial, String fechaFinal) {
        try {

            return cuotaCreditoRepository.generarReporteInteresyCapital(
                    convertirFechas(fechaInicial, false), convertirFechas(fechaFinal, true));


        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    /**
     * ultimos x abonos que se han realizado en general, esto para comparar con presupuesto
     */
    @Transactional(readOnly = true)
    public List<AbonosRealizadosResponseDTO> consultarUltimosAbonosRealizados(int cantidadAbonos) {

        try {

            List<Tuple> ultimosAbonosRealizados = cuotaCreditoRepository.consultarUltimosAbonosRealizados(cantidadAbonos);

            return ultimosAbonosRealizados.stream().map(
                    abonos -> AbonosRealizadosResponseDTO.builder()
                            .nombres(abonos.get("nombres").toString())
                            .apellidos(abonos.get("apellidos").toString())
                            .valorAbonado(Double.parseDouble(abonos.get("valor_abonado").toString()))
                            .fechaAbono(LocalDate.parse(abonos.get("fecha_abono").toString().substring(0, 10)))
                            .build()).toList();


        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    /**
     * convierte las fechas de string a datetime ya que al realizar consulta con JPQL y enviar las fechas como string
     * genera error
     */
    private LocalDateTime convertirFechas(String fecha, boolean esFechaFinal) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final LocalDate localDate = LocalDate.parse(fecha, formatter);

        return esFechaFinal ? localDate.atTime(23, 59, 59) : localDate.atStartOfDay();

    }
}
