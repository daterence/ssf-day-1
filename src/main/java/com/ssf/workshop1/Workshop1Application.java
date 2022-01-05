package com.ssf.workshop1;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.util.Collections;

@SpringBootApplication
public class Workshop1Application {

    public static void main(String[] args) {

//        SpringApplication.run(Workshop1Application.class, args);
        SpringApplication app = new SpringApplication(Workshop1Application.class);

        String port = "3000";
        ApplicationArguments cliOpts = new DefaultApplicationArguments(args);

        if (cliOpts.containsOption("port")) {
            port = cliOpts.getOptionValues("port").get(0);
        }

        app.setDefaultProperties(Collections.singletonMap("server.port", port));

        System.out.printf("Application started on port %s\n", port);
        app.run(args);
    }

    // logging filter method
    @Bean
    public CommonsRequestLoggingFilter log() {
        CommonsRequestLoggingFilter logger = new CommonsRequestLoggingFilter();
        logger.setIncludeClientInfo(true);
        logger.setIncludeQueryString(true);
        return logger;
    }

}
