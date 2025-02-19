package com.cblandon.inversiones.cliente.repository;

import com.cblandon.inversiones.cliente.dto.ClienteRespuestaDTO;
import com.cblandon.inversiones.cliente.dto.ClientesRespuestaDTO;
import com.cblandon.inversiones.cliente.dto.ClientesCuotaCreditoDTO;
import com.cblandon.inversiones.cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(value = "SELECT new com.cblandon.inversiones.cliente.dto.ClienteRespuestaDTO(c.id, c.nombres, " +
            "c.apellidos, c.celular, c.cedula, c.direccion, c.observaciones) FROM Cliente c WHERE c.cedula = :cedula")
    Optional<ClienteRespuestaDTO> findByCedula(String cedula);


    @Query(value = "SELECT new com.cblandon.inversiones.cliente.dto.ClientesCuotaCreditoDTO(" +
            "c.id, c.nombres, c.apellidos, c.cedula, cr.fechaCredito, cr.valorCredito, ccr.fechaAbono, " +
            "ccr.fechaCuota, ccr.valorCuota, ccr.valorInteres,cr.id) " +
            "FROM Cliente c " +
            "JOIN c.listaCreditos cr " +
            "JOIN cr.listaCuotasCredito ccr " +
            "JOIN cr.usuarios uc on uc.id = :idUsuario " +
            "WHERE cr.idEstadoCredito.id = 1 AND ccr.fechaAbono IS NULL " +
            "AND ccr.fechaCuota <= :fechaFiltro ORDER BY ccr.fechaCuota ASC")
    List<ClientesCuotaCreditoDTO> consultarClientesCuotasPendientes(
            @Param("fechaFiltro") LocalDate fechaFiltro, @Param("idUsuario") int idUsuario);

    @Query(value = "SELECT new com.cblandon.inversiones.cliente.dto.ClientesRespuestaDTO(c.id, c.nombres, " +
            "c.apellidos, c.cedula) FROM Cliente c ORDER BY c.id DESC ")
    List<ClientesRespuestaDTO> consultarTodos();

}
