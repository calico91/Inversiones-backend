package com.cblandon.inversiones.utils;

import com.cblandon.inversiones.roles.entity.Roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class UtilsMetodos {

    private UtilsMetodos() {
        throw new IllegalStateException("clase de utilidad");
    }

    public static String obtenerUsuarioLogueado() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName()).orElse("test");
    }

    public static int calcularCuotasPagadas(double valorCredito, double saldoCredito, int numeroCuotas) {
        double cuotasPagadas = ((valorCredito - saldoCredito) / (valorCredito / numeroCuotas));

        if (cuotasPagadas - Math.floor(cuotasPagadas) >= 0.9) {
            return (int) Math.ceil(cuotasPagadas);
        }
        return (int) Math.floor(cuotasPagadas);
    }

    public static Collection<GrantedAuthority> getAuthorities(Set<Roles> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toSet());
    }

    public static Set<String> getAuthoritiesString(Set<Roles> roles) {
        return roles.stream().map(role -> role.getName().name()).collect(Collectors.toSet());
    }


}
