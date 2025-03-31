package be.kata.tennis.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "be.kata.tennis")
public class TennisApplication {
    public static void main(String[] args) {
        SpringApplication.run(TennisApplication.class, args);
    }
}
