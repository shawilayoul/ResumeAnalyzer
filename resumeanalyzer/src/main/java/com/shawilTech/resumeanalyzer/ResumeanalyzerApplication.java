package com.shawilTech.resumeanalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD

=======
@RestController
>>>>>>> 03b2b1be01c26a6b4bc5bc4159271f1bb0dc543c
@SpringBootApplication
public class ResumeanalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeanalyzerApplication.class, args);
	}
<<<<<<< HEAD
=======

	@RequestMapping("hello")
	public  String hello(){
		return "hello good to see you ";
	}
>>>>>>> 03b2b1be01c26a6b4bc5bc4159271f1bb0dc543c
}
