package com.cblandon.inversiones.mapper;

import com.cblandon.inversiones.cliente.entity.Cliente;
import com.cblandon.inversiones.cliente.dto.ClientesRespuestaDTO;
import com.cblandon.inversiones.cliente.dto.ClienteRespuestaDTO;
import com.cblandon.inversiones.cliente.dto.RegistrarClienteDTO;
import com.cblandon.inversiones.imagen_cliente.mapper.ImagenClienteMapper;
import com.cblandon.inversiones.user.entity.UserEntity;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(uses = {CreditoMapper.class, UserEntity.class, ImagenClienteMapper.class})

public interface Mapper {

    Mapper mapper = Mappers.getMapper(Mapper.class);

    ClienteRespuestaDTO clienteToClienteResponseDto(Cliente cliente);

    ClientesRespuestaDTO clienteToClienteAllResponseDto(Cliente cliente);

    Cliente registrarClienteDTOToCliente(RegistrarClienteDTO registrarClienteDTO);


}
