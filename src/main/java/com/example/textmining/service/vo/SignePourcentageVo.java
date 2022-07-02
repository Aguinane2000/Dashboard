package com.example.textmining.service.vo;


public class SignePourcentageVo {

    private long pourcentage ;
    private String signe ;

    public SignePourcentageVo() {

    }

    public SignePourcentageVo(long pourcentage, String signe) {
        this.pourcentage = pourcentage;
        this.signe = signe;
    }

    public long getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(long pourcentage) {
        this.pourcentage = pourcentage;
    }

    public String getSigne() {
        return signe;
    }

    public void setSigne(String signe) {
        this.signe = signe;
    }
}
