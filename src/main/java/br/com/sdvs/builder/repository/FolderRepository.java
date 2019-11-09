package br.com.sdvs.builder.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.sdvs.builder.model.Folder;

@Repository
public interface FolderRepository extends CrudRepository<Folder, Long> {
    
    @Query("SELECT f FROM Folder f WHERE f.parent.id LIKE ?1")
    Set<Folder> findByParentOrderByNameAsc(Long id);
    
    Optional<Folder> findByIdAndDisabledIsNull(Long id);
}