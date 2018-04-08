package com.example.android.visionshare.Model;

import java.io.Serializable;

public class BackerInfo implements Serializable {

    String idfunding;
    String idbackerinfo;
    String totalfunded;
    String uidbackerinfo;

    public BackerInfo(){}

    public BackerInfo(String idfunding, String idbackerinfo, String totalfunded, String uidbackerinfo) {
        this.idfunding = idfunding;
        this.idbackerinfo = idbackerinfo;
        this.totalfunded = totalfunded;
        this.uidbackerinfo = uidbackerinfo;
    }

    public String getIdfunding() {
        return idfunding;
    }

    public void setIdfunding(String idfunding) {
        this.idfunding = idfunding;
    }

    public String getIdbackerinfo() {
        return idbackerinfo;
    }

    public void setIdbackerinfo(String idbackerinfo) {
        this.idbackerinfo = idbackerinfo;
    }

    public String getTotalfunded() {
        return totalfunded;
    }

    public void setTotalfunded(String totalfunded) {
        this.totalfunded = totalfunded;
    }

    public String getUidbackerinfo() {
        return uidbackerinfo;
    }

    public void setUidbackerinfo(String uidbackerinfo) {
        this.uidbackerinfo = uidbackerinfo;
    }
}
