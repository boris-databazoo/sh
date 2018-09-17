package com.databazoo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@SpringBootApplication
@PropertySource("classpath:/app.properties")
public class SuperheroApplication extends SpringBootServletInitializer {

    @Bean("dataSource")
    @Profile("local")
    public DataSource localDatabase() {
        // TODO: instantiate, configure and return embedded DataSource
        return null;
    }

    @Bean("dataSource")
    @Profile("prod")
    public DataSource prodDatabase() {
        // TODO: instantiate, configure and return embedded DataSource
        return null;
    }

    /**
     * This override is required to run the app with a tomcat7 maven plugin.
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SuperheroApplication.class);
    }

}


