package com.hackathon.genevents.modal;

/**
 * Created by venkatesh.kolla on 12/1/2015.
 */
public class AddEventDTO {

    private String EventName;
    private long FromDay;
    private long FromTime;
    private long ToDay;
    private long ToTime;
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

    public long getFromDay() {
        return FromDay;
    }

    public void setFromDay(long fromDay) {
        FromDay = fromDay;
    }

    public long getFromTime() {
        return FromTime;
    }

    public void setFromTime(long fromTime) {
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

    public long getToDay() {
        return ToDay;
    }

    public void setToDay(long toDay) {
        ToDay = toDay;
    }

    public long getToTime() {
        return ToTime;
    }

    public void setToTime(long toTime) {
        ToTime = toTime;
    }
}
