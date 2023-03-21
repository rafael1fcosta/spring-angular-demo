package com.rfcprd.demo;

import com.rfcprd.demo.entity.Client;
import com.rfcprd.demo.repo.ClientRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

//    @Bean
//    public WebMvcConfigurer corsConfigurer()
//    {
//        String[] allowDomains = new String[3];
//        allowDomains[0] = "http://localhost:4200";
//        allowDomains[1] = "http://localhost:80";
//        allowDomains[2] = "http://localhost:8080";
//
//        System.out.println("CORS configuration....");
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedOrigins(allowDomains);
//            }
//        };
//    }
}
