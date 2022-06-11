package com.aura.quickbudget.backend.service;

import net.sf.log4jdbc.sql.jdbcapi.DataSourceSpy;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

@Configuration
@ComponentScan("com.quickbudget.backend-service.repository")
public class AppConfig {
    @Inject
    DataSourceProperties dataSourceProperties;

    @Named
    static class JerseyConfig extends ResourceConfig {
        public JerseyConfig() {
            this.packages("com.aura.quickbudget.backend.service");
        }
    }

    @Bean
    DataSource dataSource() {
        DataSource dataSource = DataSourceBuilder
                .create(this.dataSourceProperties.getClassLoader())
                .url(this.dataSourceProperties.getUrl())
                .username(this.dataSourceProperties.getUsername())
                .password(this.dataSourceProperties.getPassword())
                .build();
        return new DataSourceSpy(dataSource);
    }
}