package com.example.android.visionshare.Model;

import java.io.Serializable;

public class Model_FundingComRep implements Serializable {

    String idfundingcom;
    String idfundingcomrep;
    String confundingcomrep;
    String timefundingcomrep;
    String uidfundingcomrep;

    public Model_FundingComRep(){}

    public Model_FundingComRep(String idfundingcom, String idfundingcomrep, String confundingcomrep, String timefundingcomrep, String uidfundingcomrep) {
        this.idfundingcom = idfundingcom;
        this.idfundingcomrep = idfundingcomrep;
        this.confundingcomrep = confundingcomrep;
        this.timefundingcomrep = timefundingcomrep;
        this.uidfundingcomrep = uidfundingcomrep;
    }

    public String getIdfundingcom() {
        return idfundingcom;
    }

    public void setIdfundingcom(String idfundingcom) {
        this.idfundingcom = idfundingcom;
    }

    public String getIdfundingcomrep() {
        return idfundingcomrep;
    }

    public void setIdfundingcomrep(String idfundingcomrep) {
        this.idfundingcomrep = idfundingcomrep;
    }

    public String getConfundingcomrep() {
        return confundingcomrep;
    }

    public void setConfundingcomrep(String confundingcomrep) {
        this.confundingcomrep = confundingcomrep;
    }

    public String getTimefundingcomrep() {
        return timefundingcomrep;
    }

    public void setTimefundingcomrep(String timefundingcomrep) {
        this.timefundingcomrep = timefundingcomrep;
    }

    public String getUidfundingcomrep() {
        return uidfundingcomrep;
    }

    public void setUidfundingcomrep(String uidfundingcomrep) {
        this.uidfundingcomrep = uidfundingcomrep;
    }
}
