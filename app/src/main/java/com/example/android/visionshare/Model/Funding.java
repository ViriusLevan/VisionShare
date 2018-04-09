package com.example.android.visionshare.Model;

import java.io.Serializable;

public class Funding implements Serializable {

    String idplace;
    String idfunding;
    String targetfunding;
    String desfunding;
    String isstopfunding;
    String submitbyfunding;

    public Funding(){}

    public Funding(String idplace, String idfunding, String targetfunding, String desfunding, String isstopfunding, String submitbyfunding) {
        this.idplace = idplace;
        this.idfunding = idfunding;
        this.targetfunding = targetfunding;
        this.desfunding = desfunding;
        this.isstopfunding = isstopfunding;
        this.submitbyfunding = submitbyfunding;
    }

    public String getIdplace() {
        return idplace;
    }

    public void setIdplace(String idplace) {
        this.idplace = idplace;
    }

    public String getIdfunding() {
        return idfunding;
    }

    public void setIdfunding(String idfunding) {
        this.idfunding = idfunding;
    }

    public String getTargetfunding() {
        return targetfunding;
    }

    public void setTargetfunding(String targetfunding) {
        this.targetfunding = targetfunding;
    }

    public String getDesfunding() {
        return desfunding;
    }

    public void setDesfunding(String desfunding) {
        this.desfunding = desfunding;
    }

    public String getIsstopfunding() {
        return isstopfunding;
    }

    public void setIsstopfunding(String isstopfunding) {
        this.isstopfunding = isstopfunding;
    }

    public String getSubmitbyfunding() {
        return submitbyfunding;
    }

    public void setSubmitbyfunding(String submitbyfunding) {
        this.submitbyfunding = submitbyfunding;
    }
}
