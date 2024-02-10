package com.spring.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;
import org.sql2o.converters.Converter;
import org.sql2o.converters.joda.LocalDateConverter;
import org.sql2o.quirks.NoQuirks;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Configuration
class DatabaseConfig {

    @Value(value = "${db.url}")
    private String dbUrl;
    @Value(value = "${db.username}")
    private String dbUsername;
    @Value(value = "${db.password}")
    private String dbPassword;
    @Value(value = "${db.driver-class-name}")
    private String dbDriverClassName;

    @Bean
    public DataSource dataSource() {
        final BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(this.dbDriverClassName);
        dataSource.setUrl(this.dbUrl);
        dataSource.setUsername(this.dbUsername);
        dataSource.setPassword(this.dbPassword);
        return dataSource;
    }


    @Bean
    public Sql2o sql2o() {
        return new Sql2o(dataSource());
    }
}