package com.example.textmining.service.vo;

public class PositiviteJournalisteMoisVo {

    private  Double positivite ;
    private String journaliste ;

    public PositiviteJournalisteMoisVo(Double positivite, String journaliste) {
        this.positivite = positivite;
        this.journaliste = journaliste;
    }

    public PositiviteJournalisteMoisVo() {
    }

    public Double getPositivite() {
        return positivite;
    }

    public void setPositivite(Double positivite) {
        this.positivite = positivite;
    }

    public String getJournaliste() {
        return journaliste;
    }

    public void setJournaliste(String journaliste) {
        this.journaliste = journaliste;
    }
}
