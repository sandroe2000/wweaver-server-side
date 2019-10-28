package br.com.sdvs.builder.service;

import org.springframework.stereotype.Service;
import br.com.sdvs.builder.model.File;
import br.com.sdvs.builder.model.Folder;

@Service
public interface FileFolderService {

    boolean createFile(File file);
    boolean createFolder(Folder folder);
    String getAbsolutePath(Long idParent);
    String getSHA256(String content);
}
