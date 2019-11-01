package br.com.sdvs.builder.repository;

import br.com.sdvs.builder.model.Endpoint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Set;
import java.util.Optional;

@Repository
public interface EndpointRepository  extends JpaRepository<Endpoint, Long> {

    @Query("SELECT e FROM  Endpoint e WHERE UPPER(e.uri) LIKE ?1")
    Optional<Page<Endpoint>> findPageable(String uri, Pageable page);

    Optional<Endpoint> findByUri(String uri);
    Optional<Set<Endpoint>> findByDisabledIsNull();
}
