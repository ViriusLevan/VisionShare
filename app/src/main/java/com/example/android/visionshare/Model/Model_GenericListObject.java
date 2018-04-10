package com.example.android.visionshare.Model;

import java.io.Serializable;

public class Model_GenericListObject implements Serializable{
    String id_firebase, title, num_of_comment, type,place, fundsGathered, fundingGoal;

    public Model_GenericListObject(String id_firebase, String title, String num_of_comment, String type) {
        this.id_firebase = id_firebase;
        this.title = title;
        this.num_of_comment = num_of_comment;
        this.type = type;
    }

    public Model_GenericListObject(String id_firebase, String title, String num_of_comment,
                                   String type, String place) {
        this.id_firebase = id_firebase;
        this.title = title;
        this.num_of_comment = num_of_comment;
        this.type = type;
        this.place = place;
    }

    public Model_GenericListObject(String id_firebase, String title, String num_of_comment,
                                   String type, String place, String fundsGathered,
                                   String fundingGoal) {
        this.id_firebase = id_firebase;
        this.title = title;
        this.num_of_comment = num_of_comment;
        this.type = type;
        this.place = place;
        this.fundsGathered = fundsGathered;
        this.fundingGoal = fundingGoal;
    }

    public Model_GenericListObject(String id_firebase, String type){
        this.id_firebase = id_firebase;
        this.type = type;
    }

    public String getId_firebase() {
        return id_firebase;
    }

    public void setId_firebase(String id_firebase) {
        this.id_firebase = id_firebase;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNum_of_comment() {
        return num_of_comment;
    }

    public void setNum_of_comment(String num_of_comment) {
        this.num_of_comment = num_of_comment;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getFundsGathered() {
        return fundsGathered;
    }

    public void setFundsGathered(String fundsGathered) {
        this.fundsGathered = fundsGathered;
    }

    public String getFundingGoal() {
        return fundingGoal;
    }

    public void setFundingGoal(String fundingGoal) {
        this.fundingGoal = fundingGoal;
    }
}
