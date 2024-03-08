package com.cblandon.inversiones.credito;

import com.cblandon.inversiones.credito.dto.CreditosActivosDTO;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditoRepository extends JpaRepository<Credito, Integer> {

    @Query(value = "SELECT  new com.cblandon.inversiones.credito.dto.CreditosActivosDTO(cl.id,cl.nombres," +
            "cl.apellidos,cl.cedula,cr.id, cr.fechaCredito,cr.valorCredito )" +
            "FROM Credito cr " +
            "JOIN cr.cliente cl " +
            "WHERE cr.idEstadoCredito.id=1 ORDER BY cr.id DESC ")
    List<CreditosActivosDTO> consultarClientesConCreditosActivos();

}
