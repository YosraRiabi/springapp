package com.riabi.springapp;


import com.riabi.springapp.domain.Comment;
import com.riabi.springapp.domain.Link;
import com.riabi.springapp.repository.CommentRepository;
import com.riabi.springapp.repository.LinkRepository;
import org.ocpsoft.prettytime.PrettyTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import sun.security.x509.X500Name;


@SpringBootApplication

public class SpringAppApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringAppApplication.class, args);

    }

   @Bean
    PrettyTime prettyTime(){
        return new PrettyTime();
   }


}

