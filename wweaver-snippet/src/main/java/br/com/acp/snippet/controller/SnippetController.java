package br.com.acp.snippet.controller;

import br.com.acp.snippet.model.Snippet;
import br.com.acp.snippet.repository.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/snippet")
class SnippetController {

    @Autowired
    SnippetRepository snippetRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Snippet>> getAll(){
        List<Snippet> snippets = snippetRepository.findAll();
        if(snippets.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(snippets, HttpStatus.OK);
    }

    @RequestMapping(value = "/{description}", method = RequestMethod.GET)
    public ResponseEntity<Snippet> getSnippetByDescription(@PathVariable("description") String description){
        Snippet snippet = snippetRepository.findByDescription(description);
        if(snippet == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(snippet, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody Snippet snippet){ //, UriComponentsBuilder uriComponentsBuilder) {

        Snippet currentSnippet = snippetRepository.findByDescription(snippet.getDescription());
        if (currentSnippet != null ) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        snippetRepository.save(snippet);

        //HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(uriComponentsBuilder.path("/{id}").buildAndExpand(snippet.getId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Snippet> update(@PathVariable("id") String id, @RequestBody Snippet snippet) {

        Snippet currentSnippet = snippetRepository.findOne(id);

        if (currentSnippet==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentSnippet.setDescription(snippet.getDescription());
        currentSnippet.setIcon(snippet.getIcon());
        currentSnippet.setCode(snippet.getCode());

        snippetRepository.save(currentSnippet);
        return new ResponseEntity<>(currentSnippet, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Snippet> deleteAll() {

        snippetRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Snippet> delete(@PathVariable("id") String id) {

        Snippet snippet = snippetRepository.findOne(id);
        if (snippet == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        snippetRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
