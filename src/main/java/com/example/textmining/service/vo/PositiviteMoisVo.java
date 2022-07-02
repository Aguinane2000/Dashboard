package com.example.textmining.service.vo;

public class PositiviteMoisVo {

   private double  positivite;
   private int mois ;



    public PositiviteMoisVo() {
    }

    public PositiviteMoisVo(double positivite, int mois) {
        this.positivite = positivite;
        this.mois = mois;
    }

    public double getPositivite() {
        return positivite;
    }

    public void setPositivite(double positivite) {
        this.positivite = positivite;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }
}
