package com.cblandon.inversiones.imagen_cliente.entity;

import com.cblandon.inversiones.cliente.entity.Cliente;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "imagenes_cliente")
@Entity
public class ImagenCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String descripcion;

    @Column(length = 20)
    private String extension;

    @Lob // Indica que es un campo grande
    @Column(nullable = false, columnDefinition = "MEDIUMTEXT", name = "base64_data")
    private String base64Data;

    @ManyToOne(targetEntity = Cliente.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;


}
