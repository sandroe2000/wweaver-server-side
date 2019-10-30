package br.com.sdvs.builder.controller;

import br.com.sdvs.builder.exception.NotContextException;
import br.com.sdvs.builder.model.File;
import br.com.sdvs.builder.repository.FileRepository;
import br.com.sdvs.builder.service.FileFolderService;
import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("files")
public class FileRestController {

    private final FileFolderService service;
    private final FileRepository fileRepository;

    public FileRestController(FileFolderService service, FileRepository fileRepository) {
        this.fileRepository = fileRepository;
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    File findById(@PathVariable("id") Long id) {
        return fileRepository.findById(id)
                .orElseThrow(() -> new NotContextException(String.format("Nenhuma Arquivo foi encontrado!")));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    File update(@PathVariable("id") Long id, @RequestBody File file) {
        return fileRepository.findById(id)
            .map(record -> {
                record.setName( file.getName() );
                record.setContent( file.getContent() );
                record.setModified( LocalDate.now() );
                if(file.getDisabled() != null){
                    record.setDisabled( LocalDate.now() );
                }
                record.setFolder( file.getFolder() );
                record.setPath( service.getAbsolutePath(file.getFolder().getId()) );
                record.setHash( service.getSHA256(file.getContent()) );
                return fileRepository.save(record);
            }).orElseGet(() -> {
                file.setId(id);
                return fileRepository.save(file);
            });
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    File save(@RequestBody File file) {
        file.setCreated(LocalDate.now());
        file.setPath( service.getAbsolutePath(file.getFolder().getId()) );
        file.setHash( service.getSHA256(file.getContent()) );
        return fileRepository.save(file);
    }

    @PostMapping(value = "/render", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createFile(@RequestBody File file) {
        boolean isCreated = service.createFile(file);
        return new ResponseEntity<>(isCreated, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable("id") long id) {
        fileRepository.deleteById(id);
    }
}
