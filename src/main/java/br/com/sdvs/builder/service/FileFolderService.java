package br.com.sdvs.builder.service;

import org.springframework.stereotype.Service;
import br.com.sdvs.builder.model.File;

@Service
public interface FileFolderService {

    boolean createFile(File file);
    boolean createFolder(Long id);
    String getAbsolutePath(Long idParent);
    String getSHA256(String content);
}
