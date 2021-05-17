package com.mehdi.jee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.mehdi.jee"})
@EntityScan(basePackages= {"com.mehdi.jee.entity"})
public class JeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeeApplication.class, args);
		System.out.println("hola jfhsfhshsfi");
	}
}
