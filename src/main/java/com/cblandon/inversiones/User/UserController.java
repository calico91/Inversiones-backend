package com.cblandon.inversiones.User;

import com.cblandon.inversiones.User.dto.RegisterUserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequestDTO request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @GetMapping(value = "consultarUsuarios")
    public ResponseEntity<?> consultarUsuarios() {
        return ResponseEntity.ok(userService.consultarUsuarios());
    }
}
