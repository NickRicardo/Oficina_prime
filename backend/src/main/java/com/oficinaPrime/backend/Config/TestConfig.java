package com.oficinaPrime.backend.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.oficinaPrime.backend.service.DBService;


@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbservice;

    @Value("${spring.jpa.hibernate.ddl.auto}")
    private String value;

    @Bean
    public boolean instanciaDB(){
        if (value.equals("create")) {
            this.dbservice.instanciaDB();
            return true;
        }
        return false;
    }

  
}
