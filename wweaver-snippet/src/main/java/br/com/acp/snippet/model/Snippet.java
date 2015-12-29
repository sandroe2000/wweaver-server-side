package br.com.acp.snippet.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Snippet implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String icon;
    @Lob
    private String code;

    public Snippet() {
    }

    public Snippet(String description, String icon, String code) {
        this.description = description;
        this.icon = icon;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
