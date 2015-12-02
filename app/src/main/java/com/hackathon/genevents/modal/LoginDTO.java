package com.hackathon.genevents.modal;

/**
 * Created by venkatesh.kolla on 12/1/2015.
 */
public class LoginDTO {
    private String UserName;
    private String Password;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
