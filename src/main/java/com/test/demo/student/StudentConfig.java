package com.test.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository repository) {
        return args -> {
            Student samaira = new Student(
//                1L,
                "Samaira Sharma",
                "sharmi.sammy@gmail.com",
                LocalDate.of(2018, 12, 31)
            );

            Student aarya = new Student(
                    "Aarya Rahane",
                    "aarya.rahane@gmail.com",
                    LocalDate.of(2019, 11, 26)
            );

//            repository.saveAll(
//                    List.of(samaira, aarya)
//            );

        };
    }
}
