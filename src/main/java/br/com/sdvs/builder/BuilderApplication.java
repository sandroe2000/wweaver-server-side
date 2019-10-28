package br.com.sdvs.builder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuilderApplication {

	//mvn spring-boot:run
	//mvn clean package
	public static void main(String[] args) {
		SpringApplication.run(BuilderApplication.class, args);
	}
}
