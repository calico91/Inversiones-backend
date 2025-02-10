package com.cblandon.inversiones.config;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@AllArgsConstructor
public class ApagadoProgramado {

    private ApplicationContext context;

    @Scheduled(cron = "0 57 8 * * *", zone = "America/Bogota")
    public void detenerAplicacion() {
        log.info("Deteniendo la aplicación a las 11PM programadas.");
        SpringApplication.exit(context, () -> 0);
    }
}
