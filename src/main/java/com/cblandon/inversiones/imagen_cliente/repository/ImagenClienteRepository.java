package com.cblandon.inversiones.imagen_cliente.repository;

import com.cblandon.inversiones.imagen_cliente.dto.ImagenDTO;
import com.cblandon.inversiones.imagen_cliente.entity.ImagenCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImagenClienteRepository extends JpaRepository<ImagenCliente, Integer> {
    @Query(value = "SELECT new com.cblandon.inversiones.imagen_cliente.dto.ImagenDTO( ic.base64Data, " +
            "ic.extension) FROM ImagenCliente ic WHERE ic.cliente.id = :id")
    List<ImagenDTO> findByClienteId(Integer id);

    @Modifying
    @Query("DELETE FROM ImagenCliente ic WHERE ic.cliente.id = :clienteId")
    void deleteByClienteId(@Param("clienteId") Integer clienteId);



}
