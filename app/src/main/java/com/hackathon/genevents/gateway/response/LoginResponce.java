package com.hackathon.genevents.gateway.response;

/**
 * Created by venkatesh.kolla on 12/2/2015.
 */
public class LoginResponce {

    private String isAuhthenticated;
    private String ServiceResponseStatus;
    private String Error;

    public String getError() {
        return Error;
    }

    public void setError(String error) {
        Error = error;
    }

    public String getIsAuhthenticated() {
        return isAuhthenticated;
    }

    public void setIsAuhthenticated(String isAuhthenticated) {
        this.isAuhthenticated = isAuhthenticated;
    }

    public String getServiceResponseStatus() {
        return ServiceResponseStatus;
    }

    public void setServiceResponseStatus(String serviceResponseStatus) {
        ServiceResponseStatus = serviceResponseStatus;
    }
}
