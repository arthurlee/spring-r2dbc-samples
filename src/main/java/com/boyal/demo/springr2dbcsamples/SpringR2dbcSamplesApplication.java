package com.boyal.demo.springr2dbcsamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
public class SpringR2dbcSamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringR2dbcSamplesApplication.class, args);
    }

}
