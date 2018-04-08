package com.example.android.visionshare.Model;

import java.io.Serializable;

public class PlacesCom implements Serializable {

    String idplace;
    String idplacecom;
    String conplacecom;
    String timeplacecom;
    String uidplacecom;

    public PlacesCom(){
    }

    public PlacesCom(String idplace, String idplacecom, String conplacecom, String timeplacecom, String uidplacecom) {
        this.idplace = idplace;
        this.idplacecom = idplacecom;
        this.conplacecom = conplacecom;
        this.timeplacecom = timeplacecom;
        this.uidplacecom = uidplacecom;
    }

    public String getIdplace() {
        return idplace;
    }

    public void setIdplace(String idplace) {
        this.idplace = idplace;
    }

    public String getIdplacecom() {
        return idplacecom;
    }

    public void setIdplacecom(String idplacecom) {
        this.idplacecom = idplacecom;
    }

    public String getConplacecom() {
        return conplacecom;
    }

    public void setConplacecom(String conplacecom) {
        this.conplacecom = conplacecom;
    }

    public String getTimeplacecom() {
        return timeplacecom;
    }

    public void setTimeplacecom(String timeplacecom) {
        this.timeplacecom = timeplacecom;
    }

    public String getUidplacecom() {
        return uidplacecom;
    }

    public void setUidplacecom(String uidplacecom) {
        this.uidplacecom = uidplacecom;
    }
}
