package com.example.android.visionshare.Model;

import java.io.Serializable;

public class Model_FundingCom implements Serializable {

    String idfunding;
    String idfundingcom;
    String confundingcom;
    String timefundingcom;
    String uidfundingcom;

    public Model_FundingCom(){
    }

    public Model_FundingCom(String idfunding, String idfundingcom, String confundingcom, String timefundingcom, String uidfundingcom) {
        this.idfunding = idfunding;
        this.idfundingcom = idfundingcom;
        this.confundingcom = confundingcom;
        this.timefundingcom = timefundingcom;
        this.uidfundingcom = uidfundingcom;
    }

    public String getIdfunding() {
        return idfunding;
    }

    public void setIdfunding(String idfunding) {
        this.idfunding = idfunding;
    }

    public String getIdfundingcom() {
        return idfundingcom;
    }

    public void setIdfundingcom(String idfundingcom) {
        this.idfundingcom = idfundingcom;
    }

    public String getConfundingcom() {
        return confundingcom;
    }

    public void setConfundingcom(String confundingcom) {
        this.confundingcom = confundingcom;
    }

    public String getTimefundingcom() {
        return timefundingcom;
    }

    public void setTimefundingcom(String timefundingcom) {
        this.timefundingcom = timefundingcom;
    }

    public String getUidfundingcom() {
        return uidfundingcom;
    }

    public void setUidfundingcom(String uidfundingcom) {
        this.uidfundingcom = uidfundingcom;
    }
}
