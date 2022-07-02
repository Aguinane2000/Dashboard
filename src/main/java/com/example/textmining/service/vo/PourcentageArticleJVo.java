package com.example.textmining.service.vo;


public class PourcentageArticleJVo {

    private long pourcentage ;
    private String journaliste ;

    public PourcentageArticleJVo(long pourcentage, String journaliste) {
        this.pourcentage = pourcentage;
        this.journaliste = journaliste;
    }

    public PourcentageArticleJVo() {
    }

    public long getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(long pourcentage) {
        this.pourcentage = pourcentage;
    }

    public String getJournaliste() {
        return journaliste;
    }

    public void setJournaliste(String journaliste) {
        this.journaliste = journaliste;
    }
}
