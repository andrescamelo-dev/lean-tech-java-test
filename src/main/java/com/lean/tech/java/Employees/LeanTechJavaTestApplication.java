package com.lean.tech.java.Employees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LeanTechJavaTestApplication {
	public static final String PATH_SERVICE = "/lean-tech/v1.0.0";	
	public static void main(String[] args) {
		
		SpringApplication.run(LeanTechJavaTestApplication.class, args);
	}

}
