package com.mldtsv.amigossecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PostgresQueries.class)
public class DbQueryConfig {
    @Autowired
    private PostgresQueries postgresQueries;
}
