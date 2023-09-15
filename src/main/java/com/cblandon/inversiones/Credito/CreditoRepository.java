package com.cblandon.inversiones.Credito;

import com.cblandon.inversiones.Cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CreditoRepository extends JpaRepository<Credito, Long> {

    @Query(value = "Select *" +
            "        from apirest.credito cr inner join apirest.cliente cl on cr.id_cliente = cl.idcliente\n" +
            "        where cl.idcliente = :id", nativeQuery = true)
    Set<Credito> listaCreditosCliente(@Param("id") Integer id);

    List<Credito> findByCliente(Cliente idCliente);
}
