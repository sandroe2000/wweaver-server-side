package br.com.acp.snippet.repository;

import br.com.acp.snippet.model.Snippet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SnippetRepository extends MongoRepository<Snippet, String> {

    public Snippet findByDescription(String description);
}