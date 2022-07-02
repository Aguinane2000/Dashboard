package com.example.textmining.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class MotCle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle ;
    @OneToMany(mappedBy = "motCle")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<MotCleItem> motCleItems;

    public MotCle() {
    }

    public MotCle(String libelle, List<MotCleItem> motCleItems) {
        this.libelle = libelle;
        this.motCleItems = motCleItems;
    }

    public MotCle(Long id) {
        this.id = id;
    }

    public String getMot() {
        return libelle;
    }

    public void setMot(String libelle) {
        this.libelle = libelle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MotCleItem> getMotCleItems() {
        return motCleItems;
    }

    public void setMotCleItems(List<MotCleItem> motCleItems) {
        this.motCleItems = motCleItems;
    }
}
