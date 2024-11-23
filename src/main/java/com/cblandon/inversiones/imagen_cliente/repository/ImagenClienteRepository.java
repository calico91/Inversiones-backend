package com.cblandon.inversiones.imagen_cliente.repository;

import com.cblandon.inversiones.imagen_cliente.entity.ImagenCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenClienteRepository extends JpaRepository<ImagenCliente, Integer> {
}
