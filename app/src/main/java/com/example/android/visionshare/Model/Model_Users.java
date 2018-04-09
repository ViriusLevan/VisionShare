package com.example.android.visionshare.Model;

import java.io.Serializable;

public class Model_Users implements Serializable{

    String nama;
    String email;
    String phone;
    String uid;
    String password;

    public Model_Users(){
    }

    public Model_Users(String nama, String email, String phone, String uid, String password) {
        this.nama = nama;
        this.email = email;
        this.phone = phone;
        this.uid = uid;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
