package br.com.sdvs.builder.vo;

import java.io.Serializable;

public class ParentFolderVo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;

    public ParentFolderVo() {
    }

    public ParentFolderVo(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "ParentFolder [id=" + id + ", name=" + name + "]";
    }
}