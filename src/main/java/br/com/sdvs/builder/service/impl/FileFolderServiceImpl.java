package br.com.sdvs.builder.service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import br.com.sdvs.builder.service.FileFolderService;
import br.com.sdvs.builder.model.File;
import br.com.sdvs.builder.model.Folder;
import br.com.sdvs.builder.repository.FileRepository;
import br.com.sdvs.builder.repository.FolderRepository;

@Service
public class FileFolderServiceImpl implements FileFolderService {

    @Value("${app.path}")
    private String pathToFileFolder;

    private final FileRepository fileRepository;
    private final FolderRepository folderRepository;

    FileFolderServiceImpl(FileRepository fileRepository, FolderRepository folderRepository){
        this.fileRepository = fileRepository;
        this.folderRepository = folderRepository;
    }

    @Override
    public boolean createFile(File file) {

        boolean isCreated = false;
        File entity = null;
        String appPath = pathToFileFolder.concat(file.getPath());

        try {
            entity = fileRepository.getOne(file.getId());
            if (entity != null) {
                FileWriter fw = new FileWriter(appPath.concat(entity.getName()));
                fw.write(entity.getContent());
                fw.close();
                isCreated = true;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return isCreated;
    }

    @Override
    public boolean createFolder(Folder folder) {
        
        boolean isCreated = false;
        Folder entity = null;
        String appPath = pathToFileFolder+folder.getPath()+"/"+folder.getName()+"/";

        try {
            entity = folderRepository.getOne(folder.getId());
            if (entity != null) {
                isCreated = new java.io.File(appPath).mkdirs();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return isCreated;
    }

    @Override
    public String getAbsolutePath(Long idParent) {
        
        String retorno = "";
        String dirSeparator = "/";
        List<String> foldersNames = new ArrayList<String>();
            
        do{
            Folder folder = folderRepository.findById(idParent).get();
            if(folder.getParent() == null){ 
                idParent = null;
            }else{
                idParent = folder.getParent().getId();
            }         
            foldersNames.add(folder.getName());
        }while(idParent != null);

        for (int i = foldersNames.size() - 1; i >= 0; i--) {
            retorno += foldersNames.get(i).concat(dirSeparator);
        }

        return dirSeparator.concat(retorno);
    }

    @Override
    public String getSHA256(String content) {
        
        String result = null;

        try { 

            MessageDigest md = MessageDigest.getInstance("SHA-256"); 
            byte[] messageDigest = md.digest(content.getBytes(StandardCharsets.UTF_8)); 
            BigInteger number = new BigInteger(1, messageDigest); 
            StringBuilder hexString = new StringBuilder(number.toString(16));
  
            while (hexString.length() < 32) { 
                hexString.insert(0, '0'); 
            } 
            result =  hexString.toString(); 
        } catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        }

        return result;
    }
}

