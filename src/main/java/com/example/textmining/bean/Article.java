package com.example.textmining.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String journaliste;
    private String titre;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date_distribution;
    private String texte;
    private  int mois ;
    private int annee ;
    @OneToMany(mappedBy = "article")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Paragraphe> paragraphe;
    private Double positivite;
    private String signe ;

    public String getSigne() {
        return signe;
    }

    public void setSigne(String signe) {
        this.signe = signe;
    }

    public Article() {
    }


    public Article(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJournaliste() {
        return journaliste;
    }

    public void setJournaliste(String journaliste) {
        this.journaliste = journaliste;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDate_distribution() {
        return date_distribution;
    }

    public void setDate_distribution(Date date_distribution) {
        this.date_distribution = date_distribution;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public List<Paragraphe> getParagraphe() {
        return paragraphe;
    }

    public void setParagraphe(List<Paragraphe> paragraphe) {
        this.paragraphe = paragraphe;
    }

    public Double getPositivite() {
        return positivite;
    }

    public void setPositivite(Double positivite) {
        this.positivite = positivite;
    }
}
