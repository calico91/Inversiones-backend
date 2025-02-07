package com.cblandon.inversiones.user.service;

import com.cblandon.inversiones.user.dto.UserDTO;
import com.cblandon.inversiones.user.dto.UsuariosResponseDTO;
import com.cblandon.inversiones.excepciones.NoDataException;
import com.cblandon.inversiones.excepciones.RequestException;
import com.cblandon.inversiones.mapper.UserMapper;
import com.cblandon.inversiones.roles.entity.Roles;
import com.cblandon.inversiones.roles.repository.RolesRepository;
import com.cblandon.inversiones.security.jwt.JwtUtils;
import com.cblandon.inversiones.user.entity.UserEntity;
import com.cblandon.inversiones.user.repository.UserRepository;
import com.cblandon.inversiones.user.dto.*;
import com.cblandon.inversiones.utils.MensajesErrorEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RolesRepository rolesRepository;

    @Transactional
    public UsuariosResponseDTO registrar(UserDTO userDTO) throws RequestException {


        String password = userDTO.password() == null ? "cambio" : userDTO.password();
        if (userRepository.findByUsername(userDTO.username()).isPresent()) {
            throw new RequestException(MensajesErrorEnum.USUARIO_REGISTRADO);
        }

        if (userRepository.findByEmail(userDTO.email()).isPresent()) {
            throw new RequestException(MensajesErrorEnum.CORREO_REGISTRADO);
        }
        try {

            UserEntity user = UserMapper.USER.toUserEntity(userDTO);

            user.setPassword(passwordEncoder.encode(password));

            Set<Roles> roles = userDTO.roles().stream()
                    .map(role -> rolesRepository.findById(role.getId()).orElseThrow(
                            () -> new RequestException(MensajesErrorEnum.ROL_NO_ENCONTRADO)))
                    .collect(Collectors.toSet());
            user.setRoles(roles);

            UsuariosResponseDTO usuariosResponseDTO =
                    UserMapper.USER.toUsuariosResponseDTO(userRepository.save(user));
            usuariosResponseDTO.setRoles(roles);


            return usuariosResponseDTO;

        } catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        }

    }


    @Transactional(readOnly = true)
    public List<UsuariosResponseDTO> consultarUsuarios() {
        Set<UserEntity> usuariosConsulta = userRepository.consultarUsuarios();

        try {

            return usuariosConsulta.stream().map(
                    user -> UsuariosResponseDTO.builder()
                            .id(user.getId())
                            .username(user.getUsername())
                            .lastname(user.getLastname())
                            .firstname(user.getFirstname())
                            .email(user.getEmail())
                            .active(user.isActive())
                            .build()).toList();


        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }

    }

    @Transactional
    public UsuariosResponseDTO actualizarUsuario(UserDTO userDTO) {
        UserEntity usuarioBD = userRepository.findById(userDTO.id()).orElseThrow(
                () -> new NoDataException(MensajesErrorEnum.DATOS_NO_ENCONTRADOS));

        Set<Roles> roles = userDTO.roles().stream()
                .map(role -> rolesRepository.findById(role.getId()).orElseThrow(
                        () -> new RequestException(MensajesErrorEnum.ROL_NO_ENCONTRADO)))
                .collect(Collectors.toSet());

        if (!usuarioBD.getEmail().equals(userDTO.email())) {
            userRepository.findByEmail(userDTO.email()).ifPresent(correo -> {
                throw new RequestException(MensajesErrorEnum.CORREO_REGISTRADO);
            });
        }
        if (!usuarioBD.getUsername().equals(userDTO.username())) {
            userRepository.findByUsername(userDTO.username()).ifPresent(correo -> {
                throw new RequestException(MensajesErrorEnum.USUARIO_REGISTRADO);
            });

        }

        try {

            UserEntity usuarioModificado = UserMapper.USER.toUserEntity(userDTO);
            usuarioModificado.setActive(true);
            usuarioModificado.setPassword(usuarioBD.getPassword());
            usuarioModificado.setCountry(usuarioBD.getCountry());
            usuarioModificado.setRoles(roles);

            return UserMapper.USER.toUsuariosResponseDTO(userRepository.save(usuarioModificado));

        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }


    @Transactional
    public String cambiarContrasena(CambiarContrasenaDTO cambiarContrasenaDTO) {
        UserEntity usuarioBD = userRepository.findById(cambiarContrasenaDTO.idUsuario()).orElseThrow(
                () -> new UsernameNotFoundException("No se encontro usuario"));

        if (!passwordEncoder.matches(cambiarContrasenaDTO.contrasenaActual(), usuarioBD.getPassword())) {
            throw new RequestException(MensajesErrorEnum.CONTRASENA_ANTIGUA_INCORRECTA);
        }
        try {
            usuarioBD.setPassword(passwordEncoder.encode(cambiarContrasenaDTO.contrasenaNueva()));
            userRepository.save(usuarioBD);
            return "Contrasena modificada correctamente";
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    /**
     * solo disponible para el usuario super, reinicia la contraseña de los demas usuarios
     */
    @Transactional
    public String reiniciarContrasena(Integer idUsuario) {

        try {
            UserEntity usuarioBD = userRepository.findById(idUsuario).orElseThrow(
                    () -> new UsernameNotFoundException("No se encontro usuario"));

            usuarioBD.setPassword(passwordEncoder.encode("cambio"));
            userRepository.save(usuarioBD);
            return String.format("Se asigno la contrasena 'cambio' para el usuario %s ,ingrese y asigne una nueva",
                    usuarioBD.getUsername());
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Transactional
    public String cambiarEstadoUsuario(Integer idUsuario) {

        UserEntity usuarioBD = userRepository.findById(idUsuario).orElseThrow(
                () -> new UsernameNotFoundException("No se encontro usuario"));

        try {

            usuarioBD.setActive(!usuarioBD.isActive());
            userRepository.save(usuarioBD);
            String estado = usuarioBD.isActive() ? "activado" : "inactivado";

            return String.format("Usuario %s correctamente ", estado);
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public UsuariosResponseDTO consultarUsuario(Integer id) {

        UserEntity usuarioBD = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("No se encontro usuario"));
        try {

            return UserMapper.USER.toUsuariosResponseDTO(usuarioBD);

        } catch (RuntimeException ex) {

            throw new RuntimeException(ex.getMessage());
        }


    }


    private Collection<? extends GrantedAuthority> getAuthorities(Set<Roles> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toSet());
    }


}
