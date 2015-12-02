package com.hackathon.genevents.modal;

/**
 * Created by venkatesh.kolla on 12/1/2015.
 */
public class LoginDTO {
    private String userName;
    private String password;
    private String UserRegistrationKey;

    public LoginDTO(String userName, String password, String userRegistrationKey) {
        this.password = password;
        this.userName = userName;
        UserRegistrationKey = userRegistrationKey;
    }

    public String getUserRegistrationKey() {
        return UserRegistrationKey;
    }

    public void setUserRegistrationKey(String userRegistrationKey) {
        UserRegistrationKey = userRegistrationKey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        userName = userName;
    }
}
