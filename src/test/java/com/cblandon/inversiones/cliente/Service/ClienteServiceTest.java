
package com.cblandon.inversiones.cliente.Service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


import com.cblandon.inversiones.cliente.entity.Cliente;
import com.cblandon.inversiones.cliente.repository.ClienteRepository;
import com.cblandon.inversiones.cliente.servicio.ClienteService;
import com.cblandon.inversiones.cliente.dto.ClientesRespuestaDTO;
import com.cblandon.inversiones.cliente.dto.ClienteRespuestaDTO;
import com.cblandon.inversiones.cliente.dto.ClientesCuotaCreditoDTO;
import com.cblandon.inversiones.excepciones.NoDataException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {


    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private Authentication authenticationMock;


    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente;

    @BeforeEach
    void setup() {


        cliente = Cliente.builder()
                .id(1)
                .nombres("Christian")
                .apellidos("Ramirez")
                .email("c1@gmail.com")
                .pais("colombia")
                .cedula("1")
                .celular("310125121")
                .usuariocreador("blandon")
                .build();


    }

    @AfterEach
    public void clearSecurityContext() {
        SecurityContextHolder.clearContext();
    }

    /*@DisplayName("Test para guardar un cliente")
    @Test
    void testCreateCliente() {
        //given
        given(clienteRepository.findByCedula(cliente.getCedula()))
                .willReturn(Optional.empty());

        SecurityContextHolder.getContext().setAuthentication(authenticationMock);
        given(authenticationMock.getName()).willReturn("mockuser");

        RegistrarClienteDTO clienteDTO = Mapper.mapper.clienteToRegistrarClienteDTO(cliente);
        given(clienteRepository.save(any())).willReturn(cliente);

        //when
        ClienteResponseDTO clienteGuardado = clienteService.registrarCliente(clienteDTO);

        //then
        assertThat(clienteGuardado).isNotNull();
        assertThat(clienteGuardado.cedula()).isEqualTo(cliente.getCedula());

    }*/


    /*@DisplayName("Test para guardar un cliente con Throw Exception")
    @Test
    void testGuardarClienteConThrowException() {
        //given
        given(clienteRepository.findByCedula(cliente.getCedula())).willReturn(Optional.of(cliente));
        RegistrarClienteDTO registrarClienteDto = Mapper.mapper.clienteToRegistrarClienteDTO(cliente);

        //when
        assertThrows(RequestException.class, () ->
                clienteService.registrarCliente(registrarClienteDto));


        //then
        verify(clienteRepository, never()).save(any(Cliente.class));
    }*/

    @DisplayName("Test para listar los clientes")
    @Test
    void testListarClientes() {
        //given
        Cliente cliente2 = Cliente.builder()
                .id(2)
                .nombres("maelo")
                .apellidos("maelito")
                .email("j2@gmail.com")
                .build();
        given(clienteRepository.findAll(Sort.by(Sort.Direction.DESC, "id"))).willReturn(List.of(cliente, cliente2));

        //when
        List<ClientesRespuestaDTO> clientes = clienteService.consultarTodos();

        //then
        assertThat(clientes)
                .hasSize(2)
                .isNotNull();
    }

   /* @DisplayName("Test para obtener un cliente por cedula")
    @Test
    void testObtenerClientePorCedula() {
        //given
        given(clienteRepository.findByCedula("1")).willReturn(Optional.of(cliente));

        //when
        ClienteRespuestaDTO clienteGuardado = clienteService.consultarCliente(cliente.getCedula());

        //then
        assertThat(clienteGuardado).isNotNull();
    }*/

    @DisplayName("Test para obtener un cliente por cedula con throw")
    @Test
    void testObtenerClientePorCedulaThrow() {

        given(clienteRepository.findByCedula("2")).willReturn(Optional.empty());

        assertThrows(NoDataException.class, () -> clienteService.consultarCliente("2"));

        //then
        verify(clienteRepository, never()).save(any(Cliente.class));
    }

   /* @DisplayName("Test para actualizar un cliente")
    @Test
    void testActualizarCliente() {

        //given
        given(clienteRepository.findById(1)).willReturn(Optional.ofNullable(cliente));
        cliente.setApellidos("blandito");
        cliente.setNombres("Maelito");
        SecurityContextHolder.getContext().setAuthentication(authenticationMock);
        given(authenticationMock.getName()).willReturn("mockuser");
        given(clienteRepository.save(any())).willReturn(cliente);
        RegistrarClienteDTO registrarClienteDTO = Mapper.mapper.clienteToRegistrarClienteDTO(cliente);

        //when
        ClienteResponseDTO clienteActualizado = clienteService.actualizarCliente(1, registrarClienteDTO);

        //then
        assertThat(clienteActualizado.apellidos()).isEqualTo("blandito");
        assertThat(clienteActualizado.nombres()).isEqualTo("Maelito");
    }

    @DisplayName("Test para actualizar un cliente con throw")
    @Test
    void testActualizarClienteThrow() {

        //given
        given(clienteRepository.findById(5)).willReturn(Optional.empty());
        RegistrarClienteDTO registrarClienteDTO = Mapper.mapper.clienteToRegistrarClienteDTO(cliente);

        //when
        assertThrows(NoDataException.class, () -> clienteService.actualizarCliente(5, registrarClienteDTO));

        //then
        verify(clienteRepository, never()).save(any(Cliente.class));
    }*/

    @DisplayName("Test para listar de cuotas pendientes de la fecha actual para atras")
    @Test
    void consultarClientesCuotasPendientesTes() {

        ClientesCuotaCreditoDTO obj1 = ClientesCuotaCreditoDTO.builder()
                .idCliente(1)
                .valorCuota(80000.0)
                .fechaCuota(LocalDate.now())
                .build();

        ClientesCuotaCreditoDTO obj2 = ClientesCuotaCreditoDTO.builder()
                .idCliente(2)
                .valorCuota(1000.0)
                .fechaCuota(LocalDate.now())
                .build();

        LocalDate fechaFiltro = LocalDate.now();

        given(clienteRepository.consultarClientesCuotasPendientes(fechaFiltro, 1))
                .willReturn(List.of(obj1, obj2));

        //when
        List<ClientesCuotaCreditoDTO> resultado = clienteService.consultarClientesCuotasPendientes(
                fechaFiltro, 1);

        //then
        assertThat(resultado)
                .hasSize(2)
                .isNotNull();

    }

}

