package com.cblandon.inversiones.config.tenat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import com.zaxxer.hikari.HikariDataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(DataSourceConfig.TenantDatabaseProperties.class)
public class DataSourceConfig {

    private final TenantDatabaseProperties tenantDatabaseProperties;

    @Autowired
    public DataSourceConfig(TenantDatabaseProperties tenantDatabaseProperties) {
        this.tenantDatabaseProperties = tenantDatabaseProperties;
    }

    @Bean
    public DataSource dataSource() {
        TenantRoutingDataSource routingDataSource = new TenantRoutingDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>();

        tenantDatabaseProperties.getDatabases().forEach((tenantId, url) -> {
            HikariDataSource dataSource = new HikariDataSource();
            dataSource.setJdbcUrl(url);
            dataSource.setUsername("usuario_mysql");
            dataSource.setPassword("password_mysql");
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSourceMap.put(tenantId, dataSource);
        });

        routingDataSource.setTargetDataSources(dataSourceMap);
        return routingDataSource;
    }

    // Clase interna para enlazar las propiedades
    @ConfigurationProperties(prefix = "clientes")
    public static class TenantDatabaseProperties {

        private Map<String, String> databases = new HashMap<>();

        public Map<String, String> getDatabases() {
            return databases;
        }

        public void setDatabases(Map<String, String> databases) {
            this.databases = databases;
        }
    }
}

