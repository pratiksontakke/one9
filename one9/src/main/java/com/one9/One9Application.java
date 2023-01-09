package com.one9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class One9Application {

	public static void main(String[] args) {
		SpringApplication.run(One9Application.class, args);
	}

}
