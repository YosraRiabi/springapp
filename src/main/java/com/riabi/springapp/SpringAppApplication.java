package com.riabi.springapp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringAppApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringAppApplication.class, args);

    }


}

