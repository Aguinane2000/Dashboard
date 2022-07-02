package com.example.textmining.bean;

import javax.persistence.*;

@Entity
public class Frequence {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    @ManyToOne
    private MotCle motcle ;
    @ManyToOne
    private   Article article ;

    private double frequence ;



    public Frequence(MotCle motcle, Article article, double frequence) {
        this.motcle = motcle;
        this.article = article;
        this.frequence = frequence;
    }



    public Frequence() {
    }

    public Frequence(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MotCle getMotcle() {
        return motcle;
    }

    public void setMotcle(MotCle motcle) {
        this.motcle = motcle;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public double getfrequence() {
        return frequence;
    }

    public void setfrequence(double frequence) {
        this.frequence = frequence;
    }
}
