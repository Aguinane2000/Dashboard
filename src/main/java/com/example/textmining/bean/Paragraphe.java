package com.example.textmining.bean;

import javax.persistence.*;

@Entity
public class Paragraphe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String corps;
    @ManyToOne
    private Article article;

    public Paragraphe() {
    }

    public Paragraphe(String corps, Article article) {
        this.corps = corps;
        this.article = article;
    }

    public Paragraphe(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
