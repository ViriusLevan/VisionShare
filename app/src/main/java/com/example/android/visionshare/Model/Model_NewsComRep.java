package com.example.android.visionshare.Model;

import java.io.Serializable;

public class Model_NewsComRep implements Serializable {

    String idnewscom;
    String idnewscomrep;
    String connewscomrep;
    String timenewscomrep;
    String uidnewscomrep;

    public Model_NewsComRep(){}

    public Model_NewsComRep(String idnewscom, String idnewscomrep, String connewscomrep, String timenewscomrep, String uidnewscomrep) {
        this.idnewscom = idnewscom;
        this.idnewscomrep = idnewscomrep;
        this.connewscomrep = connewscomrep;
        this.timenewscomrep = timenewscomrep;
        this.uidnewscomrep = uidnewscomrep;
    }

    public String getIdnewscom() {
        return idnewscom;
    }

    public void setIdnewscom(String idnewscom) {
        this.idnewscom = idnewscom;
    }

    public String getIdnewscomrep() {
        return idnewscomrep;
    }

    public void setIdnewscomrep(String idnewscomrep) {
        this.idnewscomrep = idnewscomrep;
    }

    public String getConnewscomrep() {
        return connewscomrep;
    }

    public void setConnewscomrep(String connewscomrep) {
        this.connewscomrep = connewscomrep;
    }

    public String getTimenewscomrep() {
        return timenewscomrep;
    }

    public void setTimenewscomrep(String timenewscomrep) {
        this.timenewscomrep = timenewscomrep;
    }

    public String getUidnewscomrep() {
        return uidnewscomrep;
    }

    public void setUidnewscomrep(String uidnewscomrep) {
        this.uidnewscomrep = uidnewscomrep;
    }
}
