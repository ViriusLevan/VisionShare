package com.example.android.visionshare.Model;

public class ListViewLayout {
    String id_firebase, title, num_of_comment, type;

    public ListViewLayout(String id_firebase, String title, String num_of_comment, String type) {
        this.id_firebase = id_firebase;
        this.title = title;
        this.num_of_comment = num_of_comment;
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
}
