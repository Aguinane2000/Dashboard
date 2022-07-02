package com.example.textmining.service.vo;

public class ArticleJournalisteVo {

    private String journaliste ;
    private Long NbArticle;

    public ArticleJournalisteVo() {
    }

    public ArticleJournalisteVo(String journaliste, Long nbArticle) {
        this.journaliste = journaliste;
        NbArticle = nbArticle;
    }

    public String getJournaliste() {
        return journaliste;
    }

    public void setJournaliste(String journaliste) {
        this.journaliste = journaliste;
    }

    public Long getNbArticle() {
        return NbArticle;
    }

    public void setNbArticle(Long nbArticle) {
        NbArticle = nbArticle;
    }
}
