package br.com.acp.snippet.repository;

import br.com.acp.snippet.model.Snippet;
import org.springframework.data.repository.CrudRepository;

public interface SnippetRepository extends CrudRepository<Snippet, Long> {

    public Snippet findByDescription(String description);
}