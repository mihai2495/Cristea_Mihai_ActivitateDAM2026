package com.example.androidseminar4;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class cameraFoto implements Parcelable {
    public String denumire;
    public double pret;
    public boolean areWifi;
    public String stare;
    public float rating;
    public boolean areBlitz;

    public cameraFoto(String denumire, double pret, boolean areWifi,
                      String stare, float rating, boolean areBlitz) {
        this.denumire = denumire;
        this.pret = pret;
        this.areWifi = areWifi;
        this.stare = stare;
        this.rating = rating;
        this.areBlitz = areBlitz;
    }

    protected cameraFoto(Parcel in) {
        denumire = in.readString();
        pret = in.readDouble();
        areWifi = in.readByte() != 0;
        stare = in.readString();
        rating = in.readFloat();
        areBlitz = in.readByte() != 0;
    }

    public static final Creator<cameraFoto> CREATOR = new Creator<cameraFoto>() {
        @Override
        public cameraFoto createFromParcel(Parcel in) {
            return new cameraFoto(in);
        }

        @Override
        public cameraFoto[] newArray(int size) {
            return new cameraFoto[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(denumire);
        dest.writeDouble(pret);
        dest.writeByte((byte) (areWifi ? 1 : 0));
        dest.writeString(stare);
        dest.writeFloat(rating);
        dest.writeByte((byte) (areBlitz ? 1 : 0));
    }

    @NonNull
    @Override
    public String toString() {
        return "Camera: " + denumire +
                "\nPret: " + pret + " RON" +
                "\nStare: " + stare +
                "\nWiFi: " + (areWifi ? "Da" : "Nu") +
                "\nBlitz: " + (areBlitz ? "Da" : "Nu") +
                "\nRating: " + rating;
    }
}