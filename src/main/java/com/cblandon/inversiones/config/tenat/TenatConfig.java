package com.cblandon.inversiones.config.tenat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TenatConfig {
    @Bean
    public TenantInterceptor tenantInterceptor() {
        return new TenantInterceptor();
    }
}

