package com.unirem.unirem;

/**
 * Created by Basha on 26/03/2017.
 */

public class Events {

    private String Event_Title;
    private String Event_Details;
    private String Event_Location;
    private String Event_Date_and_Time;
    private String Privacytype;
    private String images;


    private Events(){


    }

    public Events(String event_Title, String event_Details, String event_Location, String event_Date_and_Time, String privacytype, String images) {
        this.Event_Title = event_Title;
        this.Event_Details = event_Details;
       this.Event_Location = event_Location;
        this.Event_Date_and_Time = event_Date_and_Time;
        this.Privacytype = privacytype;
        this.images = images;
    }

    public String getEvent_Title() {
        return Event_Title;
    }

    public void setEvent_Title(String event_Title) {
        this.Event_Title = event_Title;
    }

    public String getEvent_Details() {
        return Event_Details;
    }

    public void setEvent_Details(String event_Details) {
        this.Event_Details = event_Details;
    }

    public String getEvent_Location() {
        return Event_Location;
    }

    public void setEvent_Location(String event_Location) {
        this.Event_Location = event_Location;
    }

    public String getEvent_Date_and_Time() {
        return Event_Date_and_Time;
    }

    public void setEvent_Date_and_Time(String event_Date_and_Time) {
        this.Event_Date_and_Time = event_Date_and_Time;
    }

    public String getPrivacytype() {
        return Privacytype;
    }

    public void setPrivacytype(String privacytype) {
        this.Privacytype = privacytype;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
