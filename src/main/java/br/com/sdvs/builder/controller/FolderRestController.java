package br.com.sdvs.builder.controller;

import java.time.LocalDate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.sdvs.builder.model.Folder;
import br.com.sdvs.builder.repository.FolderRepository;
import br.com.sdvs.builder.service.FileFolderService;

@RestController
@RequestMapping("folders")
public class FolderRestController {

    private final FileFolderService service;
    private final FolderRepository folderRepository;

    FolderRestController(FileFolderService service, 
                         FolderRepository folderRepository){
        this.folderRepository = folderRepository;
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    Folder findById(@PathVariable("id") Long id) {        
        return folderRepository.findByIdAndDisabledIsNull(id).get();
    }

    @GetMapping(value = "/render/{id}")
    boolean render(@PathVariable("id") Long id) {
        return service.createFolder(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    Folder update(@PathVariable("id") Long id,
                  @RequestBody Folder folder) {
        return folderRepository.findById(id)
            .map(record -> {
                Long parent = folder.getParent().getId();
                String path = service.getAbsolutePath(parent);
                record.setName(folder.getName());
                record.setPath(path);
                record.setModified(LocalDate.now());
                if(folder.getDisabled() != null){
                    record.setDisabled(LocalDate.now());
                }
                record.setParent(folder.getParent());
                record.setFolders(folder.getFolders());
                record.setFiles(folder.getFiles());
                return folderRepository.save(record);
            }).orElseGet(() -> {
                folder.setId(id);
                return folderRepository.save(folder);
            });
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Folder save(@RequestBody Folder folder) {
        folder.setCreated(LocalDate.now());
        folder.setPath(service.getAbsolutePath(folder.getParent().getId()));
        return folderRepository.save(folder);
    }

    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable("id") long id) {
        folderRepository.deleteById(id);
    }
}