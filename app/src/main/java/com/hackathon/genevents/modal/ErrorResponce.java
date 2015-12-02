package com.hackathon.genevents.modal;

/**
 * Created by venkatesh.kolla on 12/2/2015.
 */
public class ErrorResponce {

    private String ServiceResponseStatus;
    private Error Error;

    public com.hackathon.genevents.modal.Error getError() {
        return Error;
    }

    public void setError(com.hackathon.genevents.modal.Error error) {
        Error = error;
    }

    public String getServiceResponseStatus() {
        return ServiceResponseStatus;
    }

    public void setServiceResponseStatus(String serviceResponseStatus) {
        ServiceResponseStatus = serviceResponseStatus;
    }
}
