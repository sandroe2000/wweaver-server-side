package br.com.acp.snippet.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Snippet implements Serializable {

    @Id
    private String id;
    private String description;
    private String icon;
    private String code;

    public Snippet() {
    }

    public Snippet(String description, String icon, String code) {
        this.description = description;
        this.icon = icon;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public String toString() {
        return "Snippet{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
