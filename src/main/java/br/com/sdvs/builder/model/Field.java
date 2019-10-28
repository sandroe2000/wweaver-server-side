package br.com.sdvs.builder.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Field implements Serializable {

    private static final long serialVersionUID = -3044375219621331175L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate disabled;

    @JsonIgnoreProperties("fields")
    @ManyToOne
    @JoinColumn(name="endpoint", nullable=false)
    private Endpoint endpoint;

    public Field() {
    }

    public Field(Long id, String name, LocalDate disabled, Endpoint endpoint) {
        this.id = id;
        this.name = name;
        this.disabled = disabled;
        this.endpoint = endpoint;
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

    public LocalDate getDisabled() {
        return disabled;
    }

    public void setDisabled(LocalDate disabled) {
        this.disabled = disabled;
    }

    public Endpoint getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public String toString() {
        return "Field [id=" + id + ", name=" + name + "]";
    }
    
}
