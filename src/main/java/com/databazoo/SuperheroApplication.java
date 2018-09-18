package com.databazoo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/app.properties")
public class SuperheroApplication extends SpringBootServletInitializer {

    /**
     * This override is required to run the app with a tomcat7 maven plugin.
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SuperheroApplication.class);
    }

}


