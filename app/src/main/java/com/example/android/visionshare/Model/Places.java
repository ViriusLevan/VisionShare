package com.example.android.visionshare.Model;

import java.io.Serializable;

public class Places implements Serializable {

    String idplace;
    String namaplace;
    String desplace;
    String lokasiplace;
    String longitudeplace;
    String latitudeplace;
    String submitbyplace;
    String waktupostplace;

    public Places(){
    }

    public Places(String idplace, String namaplace, String desplace, String lokasiplace, String longitudeplace, String latitudeplace, String submitbyplace, String waktupostplace) {
        this.idplace = idplace;
        this.namaplace = namaplace;
        this.desplace = desplace;
        this.lokasiplace = lokasiplace;
        this.longitudeplace = longitudeplace;
        this.latitudeplace = latitudeplace;
        this.submitbyplace = submitbyplace;
        this.waktupostplace = waktupostplace;
    }

    public String getIdplace() {
        return idplace;
    }

    public void setIdplace(String idplace) {
        this.idplace = idplace;
    }

    public String getNamaplace() {
        return namaplace;
    }

    public void setNamaplace(String namaplace) {
        this.namaplace = namaplace;
    }

    public String getDesplace() {
        return desplace;
    }

    public void setDesplace(String desplace) {
        this.desplace = desplace;
    }

    public String getLokasiplace() {
        return lokasiplace;
    }

    public void setLokasiplace(String lokasiplace) {
        this.lokasiplace = lokasiplace;
    }

    public String getLongitudeplace() {
        return longitudeplace;
    }

    public void setLongitudeplace(String longitudeplace) {
        this.longitudeplace = longitudeplace;
    }

    public String getLatitudeplace() {
        return latitudeplace;
    }

    public void setLatitudeplace(String latitudeplace) {
        this.latitudeplace = latitudeplace;
    }

    public String getSubmitbyplace() {
        return submitbyplace;
    }

    public void setSubmitbyplace(String submitbyplace) {
        this.submitbyplace = submitbyplace;
    }

    public String getWaktupostplace() {
        return waktupostplace;
    }

    public void setWaktupostplace(String waktupostplace) {
        this.waktupostplace = waktupostplace;
    }
}
