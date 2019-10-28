package br.com.sdvs.builder.controller;

import br.com.sdvs.builder.exception.NotContextException;
import br.com.sdvs.builder.model.Endpoint;
import br.com.sdvs.builder.repository.EndpointRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("endpoints")
public class EndpointRestController {

    private final EndpointRepository repository;

    EndpointRestController(EndpointRepository repository){
        this.repository = repository;
    }

    @GetMapping()
    Set<Endpoint> findByDisabledIsNull(){
        return repository.findByDisabledIsNull()
                .orElseThrow(() -> new NotContextException(String.format("Nenhum endipoint foi encontrado!")));
    }

    @GetMapping(value = "pageable")
    Page<Endpoint> findPageable(@RequestParam("uri") String uri,
                                @PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return repository.findPageable(uri.toUpperCase().concat("%"), pageable)
                .orElseThrow(() -> new NotContextException(String.format("Nenhum endipoint foi encontrado!")));
    }

    @GetMapping(value = "/{id}")
    Endpoint findById(@PathVariable("id") Long id){
        return repository.findById(id)
                .orElseThrow(() -> new NotContextException(String.format("Endipoint [id: %d] não encontrado!", id)));
    }

    @GetMapping(value = "/search/{uri}")
    Endpoint findOneByDescription(@PathVariable("uri") String uri) throws NotContextException {
        return repository.findByUri(uri.toUpperCase().concat("%"))
                .orElseThrow(() -> new NotContextException(String.format("Endipoint [uri: %s] não encontrado!", uri) ));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Endpoint create(@RequestBody Endpoint entity){
        return repository.save(entity);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Endpoint> update(@PathVariable("id") Long id,
                                    @RequestBody Endpoint entity) {
        return repository.findById(id)
                .map(record -> {
                    record.setVerb(entity.getVerb());
                    record.setUri(entity.getUri());
                    if(entity.getDisabled() != null){
                        record.setDisabled( LocalDate.now() );
                    }
                    record.setFields(entity.getFields());
                    Endpoint updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElseThrow(() -> new NotContextException(String.format("Endipoint [id: %d] não encontrado!", id)));
    }

    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable("id") long id) {        
        repository.deleteById(id);
    }
}