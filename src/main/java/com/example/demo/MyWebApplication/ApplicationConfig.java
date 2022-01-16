package com.example.demo.MyWebApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ApplicationConfig {
    @Bean
    CommandLineRunner commandLineRunner(ApplicationRepository repository){
        return args -> {
            MyWebApplication facebook = new MyWebApplication(
                    "Facebook",
                    "Social",
                    "Mark Zuckerberg",
                    "Markzuckerberg@gmail.com"
            );
            MyWebApplication Whatsapp = new MyWebApplication(
                    "Whatsapp",
                    "Social",
                    "Jan Koum",
                    "KoumJ@gmail.com"
            );
            MyWebApplication Twitter = new MyWebApplication(
                    "Twitter",
                    "Social",
                    "Jack Dorsey",
                    "JDorsey2@gamil.com"
            );
            MyWebApplication Telegram = new MyWebApplication(
                    "Telegram",
                    "Social",
                    "Pavel Durov",
                    "PavelDurov1@gmail.com"
            );
            MyWebApplication Instagram = new MyWebApplication(
                    "Instagram",
                    "Social",
                    "Kevin Systrom",
                    "KevinSystron8@gmail.com"
            );
            repository.saveAll(
                    List.of(facebook, Whatsapp, Twitter, Telegram, Instagram)
            );
        };
    }
}

