package br.com.sdvs.builder.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class File implements Serializable {

    private static final long serialVersionUID = 8802212851010133569L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String path;
    
    @Lob
    private String content;
    private String hash;

    private Double size;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate created;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate modified;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate disabled;

    @ManyToOne
    @JsonIgnoreProperties({"parent", "folders", "files"})
    @JoinColumn(name="folder", nullable=false)
    protected Folder folder;

    public File() {
    }

    public File(Long id, String name, String path, String content, String hash, Double size, LocalDate created,
                LocalDate modified, LocalDate disabled, Folder folder) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.content = content;
        this.hash = hash;
        this.size = size;
        this.created = created;
        this.modified = modified;
        this.disabled = disabled;
        this.folder = folder;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
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

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public String getPath() {
        return path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    @Override
    public String toString() {
        return "File [hash=" + hash + ", id=" + id + ", name=" + name + "]";
    }
}
