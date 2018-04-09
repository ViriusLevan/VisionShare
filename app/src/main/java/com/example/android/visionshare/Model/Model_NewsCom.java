package com.example.android.visionshare.Model;

import java.io.Serializable;

public class Model_NewsCom implements Serializable {

    String idnews;
    String idnewscom;
    String connewscom;
    String timenewscom;
    String uidnewscom;

    public Model_NewsCom(){
    }

    public Model_NewsCom(String idnews, String idnewscom, String connewscom, String timenewscom, String uidnewscom) {
        this.idnews = idnews;
        this.idnewscom = idnewscom;
        this.connewscom = connewscom;
        this.timenewscom = timenewscom;
        this.uidnewscom = uidnewscom;
    }

    public String getIdnews() {
        return idnews;
    }

    public void setIdnews(String idnews) {
        this.idnews = idnews;
    }

    public String getIdnewscom() {
        return idnewscom;
    }

    public void setIdnewscom(String idnewscom) {
        this.idnewscom = idnewscom;
    }

    public String getConnewscom() {
        return connewscom;
    }

    public void setConnewscom(String connewscom) {
        this.connewscom = connewscom;
    }

    public String getTimenewscom() {
        return timenewscom;
    }

    public void setTimenewscom(String timenewscom) {
        this.timenewscom = timenewscom;
    }

    public String getUidnewscom() {
        return uidnewscom;
    }

    public void setUidnewscom(String uidnewscom) {
        this.uidnewscom = uidnewscom;
    }
}
