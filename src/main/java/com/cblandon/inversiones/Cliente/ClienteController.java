package com.cblandon.inversiones.Cliente;

import com.cblandon.inversiones.Cliente.dto.ClienteResponseDTO;
import com.cblandon.inversiones.Cliente.dto.RegistrarClienteDTO;
import com.cblandon.inversiones.Utils.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> createCliente(@RequestBody RegistrarClienteDTO registrarClienteDTO) {
        return ResponseEntity.ok().body(clienteService.createCliente(registrarClienteDTO));
    }

    @GetMapping("/consultarClientes")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<?> consultarClientes() {
        final Map<String, Object> infoMap = new HashMap<String, Object>();

        infoMap.put("status", HttpStatus.OK.value());
        infoMap.put("message", "successful");
        infoMap.put("user", clienteService.allClientes());

        return new ResponseHandler().generateResponse(infoMap, HttpStatus.OK);
    }

    @GetMapping("/consultarClientePorCedula/{cedula}")
    public ResponseEntity<?> consultarCliente(@PathVariable String cedula) {
        return ResponseEntity.ok().body(clienteService.consultarCliente(cedula));

    }

    @PutMapping("/actualizarCliente/{cedula}")
    public ResponseEntity<?> actualizarCliente(@PathVariable String cedula, @RequestBody RegistrarClienteDTO registrarClienteDTO) {
        return ResponseEntity.ok().body(clienteService.actualizarCliente(cedula, registrarClienteDTO));
    }

    @DeleteMapping("/eliminarCliente/{idCliente}")
    public ResponseEntity<?> eliminarCliente(@PathVariable int idCliente) {
        clienteService.deleteCliente(idCliente);
        return new ResponseEntity<String>("Empleado eliminado exitosamente", HttpStatus.OK);
    }
}
