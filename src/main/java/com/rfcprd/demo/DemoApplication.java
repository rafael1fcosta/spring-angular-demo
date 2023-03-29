package com.rfcprd.demo;

import com.rfcprd.demo.entity.Client;
import com.rfcprd.demo.repo.ClientRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ClientRepo clientRepo) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                Client user = new Client(name, name.toLowerCase() + "@domain.com");
                clientRepo.save(user);
            });
            clientRepo.findAll().forEach(System.out::println);
        };
    }


}
