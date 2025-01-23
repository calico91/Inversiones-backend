package com.cblandon.inversiones.mapper;

import com.cblandon.inversiones.cliente.entity.Cliente;
import com.cblandon.inversiones.cliente.dto.ClienteAllResponseDTO;
import com.cblandon.inversiones.cliente.dto.ClienteResponseDTO;
import com.cblandon.inversiones.cliente.dto.RegistrarClienteDTO;
import com.cblandon.inversiones.imagen_cliente.mapper.ImagenClienteMapper;
import com.cblandon.inversiones.user.entity.UserEntity;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(uses = {CreditoMapper.class, UserEntity.class, ImagenClienteMapper.class})

public interface Mapper {

    Mapper mapper = Mappers.getMapper(Mapper.class);

    ClienteResponseDTO clienteToClienteResponseDto(Cliente cliente);

    ClienteAllResponseDTO clienteToClienteAllResponseDto(Cliente cliente);

    Cliente registrarClienteDTOToCliente(RegistrarClienteDTO registrarClienteDTO);


}
