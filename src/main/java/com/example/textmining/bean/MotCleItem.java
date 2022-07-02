package com.example.textmining.bean;

import javax.persistence.*;

@Entity
public class MotCleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Paragraphe paragraphe;
    @ManyToOne
    private MotCle motCle;

    public MotCleItem() {
    }

    public MotCleItem(Paragraphe paragraphe, MotCle motCle) {
        this.paragraphe = paragraphe;
        this.motCle = motCle;
    }

    public MotCleItem(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paragraphe getParagraphe() {
        return paragraphe;
    }

    public void setParagraphe(Paragraphe paragraphe) {
        this.paragraphe = paragraphe;
    }

    public MotCle getMotCle() {
        return motCle;
    }

    public void setMotCle(MotCle motCle) {
        this.motCle = motCle;
    }
}
