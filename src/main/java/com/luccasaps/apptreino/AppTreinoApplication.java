package com.luccasaps.apptreino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AppTreinoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppTreinoApplication.class, args);
    }

}
