package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NativeApplication.class, args);
	}


	@Bean
	ApplicationRunner applicationRunner(@Value("${test}") String testVlaue) {
		return args -> {
			System.out.println("`message` loaded from the AWS Parameter store: "+ testVlaue);
		};
	}
}
