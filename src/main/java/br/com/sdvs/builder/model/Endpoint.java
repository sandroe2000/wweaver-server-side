package br.com.sdvs.builder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.sdvs.builder.enumerated.Verb;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Endpoint implements Serializable {

    private static final long serialVersionUID = -7761444701260005807L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Verb verb;

    @Column(nullable = false, unique = true)
    private String uri;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate disabled;

    @JsonIgnoreProperties("endpoint")
    @OneToMany(mappedBy = "endpoint",fetch=FetchType.LAZY, cascade={CascadeType.ALL})
    private Set<Field> fields = new HashSet<Field>();

    public Endpoint() {
    }

    public Endpoint(Long id, Verb verb, String uri, LocalDate disabled, Set<Field> fields) {
        this.id = id;
        this.verb = verb;
        this.uri = uri;
        this.disabled = disabled;
        this.fields = fields;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Verb getVerb() {
        return verb;
    }

    public void setVerb(Verb verb) {
        this.verb = verb;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public LocalDate getDisabled() {
        return disabled;
    }

    public void setDisabled(LocalDate disabled) {
        this.disabled = disabled;
    }

    public Set<Field> getFields() {
        return fields;
    }

    public void setFields(Set<Field> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "Endpoint [id=" + id + ", uri=" + uri + ", verb=" + verb + "]";
    }
}
