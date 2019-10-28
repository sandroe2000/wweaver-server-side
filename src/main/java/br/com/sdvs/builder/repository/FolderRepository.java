package br.com.sdvs.builder.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.sdvs.builder.model.Folder;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
    
    @Query("SELECT f FROM Folder f WHERE f.parent.id LIKE ?1")
    Folder findByParent(Long parentId);

    Optional<Folder> findByIdAndDisabledIsNull(Long id);
}