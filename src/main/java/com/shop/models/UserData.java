package com.shop.models;

public class UserData {
    private String userName;
    private String userLastName;
    private String password;
    private String email ;


    public UserData setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserData setUserLastName(String userLastName) {
        this.userLastName = userLastName;
        return this;
    }

    public UserData setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserData setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                '}';
    }
}
