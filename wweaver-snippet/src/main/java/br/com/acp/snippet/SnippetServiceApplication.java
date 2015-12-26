package br.com.acp.snippet;

import br.com.acp.snippet.model.Snippet;
import br.com.acp.snippet.repository.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
//public class SnippetServiceApplication implements CommandLineRunner {

public class SnippetServiceApplication {

    @Autowired
    private SnippetRepository repository;

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "wweaver-snippet");
        SpringApplication.run(SnippetServiceApplication.class, args);
    }
/*
    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of snippets
        repository.save(new Snippet("tab", "fa fa-tabs", "WEQIFGKE UFIOUEGF AEKUFGEAK FEAKFVKAE FD KA HDFKAD KAEF"));
        repository.save(new Snippet("input", "fa fa-text", "TTT WEQIFGKE UFIOUEGF AEKUFGEAK FEAKFVKAE FD KA HDFKAD KAEF"));

        // fetch all snippets
        System.out.println("Snippets found with findAll():");
        System.out.println("-------------------------------");
        for (Snippet snippet : repository.findAll()) {
            System.out.println(snippet);
        }
        System.out.println();

        // fetch an individual snippet
        System.out.println("--------------------------------");
        System.out.println(repository.findByDescription("input"));
        System.out.println();
    }
*/
}
