package br.com.sdvs.builder.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Folder implements Serializable {

    private static final long serialVersionUID = -886315072953158617L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String path;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", 
                locale = "pt-BR", timezone = "Brazil/East")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate created;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", 
                locale = "pt-BR", timezone = "Brazil/East")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate modified;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", 
                locale = "pt-BR", timezone = "Brazil/East")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate disabled;

    @JsonIgnoreProperties({"parent", "path"})
    @ManyToOne()
    @JoinColumn(name="parent")
    private Folder parent;

    public Folder() {
    }

    public Folder(Long id, 
                  String name, 
                  String  path, 
                  LocalDate created, 
                  LocalDate modified, 
                  LocalDate disabled, 
                  Folder parent) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.modified = modified;
        this.disabled = disabled;
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getModified() {
        return modified;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }

    public LocalDate getDisabled() {
        return disabled;
    }

    public void setDisabled(LocalDate disabled) {
        this.disabled = disabled;
    }

    public Folder getParent() {
        return parent;
    }

    public void setParent(Folder parent) {
        this.parent = parent;
    }
    
    @Override
    public String toString() {
        return "Folder [id=" + id + ", name=" + name + "]";
    }
}
