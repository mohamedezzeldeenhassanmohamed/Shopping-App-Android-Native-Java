package com.example.shoppingapp;

public class Users {

    private int id;
    private String userName;
    private String fullName;
    private String userImage;
    private String userPassword;
    private String email;
    private String phone;

    public Users(int id, String userName, String fullName, String userImage, String userPassword, String email, String phone) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.userImage = userImage;
        this.userPassword = userPassword;
        this.email = email;
        this.phone = phone;
    }

    public Users(String userName, String fullName, String userImage, String userPassword, String email, String phone) {
        this.userName = userName;
        this.fullName = fullName;
        this.userImage = userImage;
        this.userPassword = userPassword;
        this.email = email;
        this.phone = phone;
    }

    public Users(int id, String fullName, String userImage, String email, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.userImage = userImage;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
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
}
