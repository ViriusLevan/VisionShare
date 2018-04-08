package com.example.android.visionshare.Model;

import java.io.Serializable;

public class News implements Serializable {

    String idplace;
    String idnews;
    String connews;
    String timenews;
    String submitbynews;

    public News(){}

    public News(String idplace, String idnews, String connews, String timenews, String submitbynews) {
        this.idplace = idplace;
        this.idnews = idnews;
        this.connews = connews;
        this.timenews = timenews;
        this.submitbynews = submitbynews;
    }

    public String getIdplace() {
        return idplace;
    }

    public void setIdplace(String idplace) {
        this.idplace = idplace;
    }

    public String getIdnews() {
        return idnews;
    }

    public void setIdnews(String idnews) {
        this.idnews = idnews;
    }

    public String getConnews() {
        return connews;
    }

    public void setConnews(String connews) {
        this.connews = connews;
    }

    public String getTimenews() {
        return timenews;
    }

    public void setTimenews(String timenews) {
        this.timenews = timenews;
    }

    public String getSubmitbynews() {
        return submitbynews;
    }

    public void setSubmitbynews(String submitbynews) {
        this.submitbynews = submitbynews;
    }
}
