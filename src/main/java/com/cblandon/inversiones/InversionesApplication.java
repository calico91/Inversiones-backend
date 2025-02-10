package com.cblandon.inversiones;


import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.core.GrantedAuthorityDefaults;

import java.util.TimeZone;
@EnableEncryptableProperties
@EnableScheduling
@SpringBootApplication
public class InversionesApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-5:00"));
        SpringApplication.run(InversionesApplication.class, args);
    }

    @Bean
    public OpenAPI documentacionAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Proyecto inversiones")
                        .version("1.0")
                        .description("Control de inversiones")

                );
    }

    @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults(""); // Remove the ROLE_ prefix
    }

}
