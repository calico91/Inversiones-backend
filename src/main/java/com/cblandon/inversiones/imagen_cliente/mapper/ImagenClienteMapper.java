package com.cblandon.inversiones.imagen_cliente.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ImagenClienteMapper {
    ImagenClienteMapper mapperImagenCliente =  Mappers.getMapper(ImagenClienteMapper.class);
}
