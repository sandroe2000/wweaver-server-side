package br.com.acp.snippet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer

public class SnippetServiceApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "wweaver-snippet");
        SpringApplication.run(SnippetServiceApplication.class, args);
    }
}
