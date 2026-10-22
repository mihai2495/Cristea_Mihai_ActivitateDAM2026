package com.example.androidseminar4;

public class cameraFoto {
    public String denumire;
    public double pret;
    public Boolean areWifi;
    public String stare;
    public float rating;
    public Boolean areBlitz;

    public cameraFoto(String tip, double pret, Boolean areWifi, String stare, float rating, Boolean areBlitz) {
        this.denumire = tip;
        this.pret = pret;
        this.areWifi = areWifi;
        this.stare = stare;
        this.rating = rating;
        this.areBlitz = areBlitz;
    }

}
