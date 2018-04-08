package com.example.android.visionshare.Model;

import java.io.Serializable;

public class Model_Submission implements Serializable{

    private String description, locationOrPlace, name, status, submittedBy, type;
    private int fundingGoal;

    public Model_Submission(){}

    public Model_Submission(String type, String name, String description, String location, String status,
                            String submittedBy, int fundingGoal){

        this.type               = type;
        this.name               = name;
        this.description        = description;
        this.locationOrPlace    = location;
        this.status             = status;
        this.submittedBy        = submittedBy;
        this.fundingGoal        = fundingGoal;
    }

    public String getName()             {return name;}
    public String getDescription()      {return description;}
    public String getLocationOrPlace()  {return locationOrPlace;}
    public String getStatus()           {return status;}
    public String getSubmittedBy()      {return submittedBy;}
    public String getType()             {return type;}
    public int getFundingGoal()         {return fundingGoal;}

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocationOrPlace(String locationOrPlace) {
        this.locationOrPlace = locationOrPlace;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFundingGoal(int fundingGoal) {
        this.fundingGoal = fundingGoal;
    }
}
