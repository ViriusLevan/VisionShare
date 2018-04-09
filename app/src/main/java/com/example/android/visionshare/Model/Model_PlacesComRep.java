package com.example.android.visionshare.Model;

import java.io.Serializable;

public class Model_PlacesComRep implements Serializable {

    String idplacecom;
    String idplacecomrep;
    String conplacecomrep;
    String timeplacecomrep;
    String uidplacecomrep;

    public Model_PlacesComRep(){
    }

    public Model_PlacesComRep(String idplacecom, String idplacecomrep, String conplacecomrep, String timeplacecomrep, String uidplacecomrep) {
        this.idplacecom = idplacecom;
        this.idplacecomrep = idplacecomrep;
        this.conplacecomrep = conplacecomrep;
        this.timeplacecomrep = timeplacecomrep;
        this.uidplacecomrep = uidplacecomrep;
    }

    public String getIdplacecom() {
        return idplacecom;
    }

    public void setIdplacecom(String idplacecom) {
        this.idplacecom = idplacecom;
    }

    public String getIdplacecomrep() {
        return idplacecomrep;
    }

    public void setIdplacecomrep(String idplacecomrep) {
        this.idplacecomrep = idplacecomrep;
    }

    public String getConplacecomrep() {
        return conplacecomrep;
    }

    public void setConplacecomrep(String conplacecomrep) {
        this.conplacecomrep = conplacecomrep;
    }

    public String getTimeplacecomrep() {
        return timeplacecomrep;
    }

    public void setTimeplacecomrep(String timeplacecomrep) {
        this.timeplacecomrep = timeplacecomrep;
    }

    public String getUidplacecomrep() {
        return uidplacecomrep;
    }

    public void setUidplacecomrep(String uidplacecomrep) {
        this.uidplacecomrep = uidplacecomrep;
    }
}
