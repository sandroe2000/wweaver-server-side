package br.com.sdvs.builder.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.sdvs.builder.model.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

    Set<File> findByFolderIdOrderByNameAsc(Long id);
}