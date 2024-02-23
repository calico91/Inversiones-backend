package com.cblandon.inversiones.cliente;

import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByCedula(String cedula);


    @Query(value = "SELECT cl.id_cliente, cl.nombres,cl.apellidos,cl.cedula ,cr.fecha_credito,cr.valor_credito, " +
            "            ccr.fecha_abono, ccr.fecha_cuota,cr.id_credito, ccr.valor_cuota, ccr.valor_interes" +
            "            FROM apirest.credito cr" +
            "            INNER JOIN apirest.cliente cl ON cr.id_cliente = cl.id_cliente " +
            "            INNER JOIN   apirest.cuota_credito ccr ON cr.id_credito= ccr.id_credito" +
            "            WHERE cr.id_estado_credito=1 AND ccr.fecha_abono IS NULL " +
            "            AND fecha_cuota <= :fechaFiltro ORDER BY fecha_cuota ASC",
            nativeQuery = true)
    List<Tuple> infoClientesCuotasPendientes(@Param("fechaFiltro") String fechaFiltro);


}
