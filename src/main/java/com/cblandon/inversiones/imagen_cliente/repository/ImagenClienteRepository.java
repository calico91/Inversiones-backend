package com.cblandon.inversiones.imagen_cliente.repository;

import com.cblandon.inversiones.imagen_cliente.entity.ImagenCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImagenClienteRepository extends JpaRepository<ImagenCliente, Integer> {

    List<ImagenCliente> findByClienteId(Integer id);
}
