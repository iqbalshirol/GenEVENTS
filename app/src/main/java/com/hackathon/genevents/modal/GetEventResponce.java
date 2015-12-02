package com.hackathon.genevents.modal;

/**
 * Created by venkatesh.kolla on 12/2/2015.
 */
public class GetEventResponce {


    private String EventID;
    private String EventName;
    private String FromDay;
    private String FromTime;
    private String ToDay;
    private String ToTime;
    private String Location;
    private String Fee;
    private String ModeOfTravel;
    private String HostedBy;
    private String EventDesc;

    public String getEventDesc() {
        return EventDesc;
    }

    public void setEventDesc(String eventDesc) {
        EventDesc = eventDesc;
    }

    public String getEventID() {
        return EventID;
    }

    public void setEventID(String eventID) {
        EventID = eventID;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getFee() {
        return Fee;
    }

    public void setFee(String fee) {
        Fee = fee;
    }

    public String getFromDay() {
        return FromDay;
    }

    public void setFromDay(String fromDay) {
        FromDay = fromDay;
    }

    public String getFromTime() {
        return FromTime;
    }

    public void setFromTime(String fromTime) {
        FromTime = fromTime;
    }

    public String getHostedBy() {
        return HostedBy;
    }

    public void setHostedBy(String hostedBy) {
        HostedBy = hostedBy;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getModeOfTravel() {
        return ModeOfTravel;
    }

    public void setModeOfTravel(String modeOfTravel) {
        ModeOfTravel = modeOfTravel;
    }

    public String getToDay() {
        return ToDay;
    }

    public void setToDay(String toDay) {
        ToDay = toDay;
    }

    public String getToTime() {
        return ToTime;
    }

    public void setToTime(String toTime) {
        ToTime = toTime;
    }
}
