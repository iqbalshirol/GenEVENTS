package com.hackathon.genevents.modal;

/**
 * Created by venkatesh.kolla on 12/2/2015.
 */
public class GetEventsDTO {

    private String EventType;
    private String UserID;
    private String EventName;

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getEventType() {
        return EventType;
    }

    public void setEventType(String eventType) {
        EventType = eventType;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }
}
