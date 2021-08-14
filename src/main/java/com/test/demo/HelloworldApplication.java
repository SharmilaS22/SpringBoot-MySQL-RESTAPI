package com.test.demo;

import com.test.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class HelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}

	@GetMapping
	public String helloworld() {
		return "Hello World!";
	}

//	@GetMapping
//	public List<String> helloworld() {
//		return List.of("Hello", "World");
//	}

}
