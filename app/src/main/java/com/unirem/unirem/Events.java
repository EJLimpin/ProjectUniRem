package com.unirem.unirem;

/**
 * Created by Basha on 26/03/2017.
 */

public class Events {

    private String Event_Title;
    private String Event_Details;
    private String Event_Location;
    private String Event_Date_and_Time;
    private String Privacy;
    private String images;

    public Events(String event_Title, String event_Details, String event_Location, String event_Date_and_Time, String privacy, String images) {
        this.Event_Title = event_Title;
        this.Event_Details = event_Details;
        this.Event_Location = event_Location;
        this.Event_Date_and_Time = event_Date_and_Time;
        this.Privacy = privacy;
        this.images = images;
    }

    private Events() {


    }

    public String getEvent_Title() {
        return Event_Title;
    }

    public void setEvent_Title(String event_Title) {
        Event_Title = event_Title;
    }

    public String getEvent_Details() {
        return Event_Details;
    }

    public void setEvent_Details(String event_Details) {
        Event_Details = event_Details;
    }

    public String getEvent_Location() {
        return Event_Location;
    }

    public void setEvent_Location(String event_Location) {
        Event_Location = event_Location;
    }

    public String getEvent_Date_and_Time() {
        return Event_Date_and_Time;
    }

    public void setEvent_Date_and_Time(String event_Date_and_Time) {
        Event_Date_and_Time = event_Date_and_Time;
    }

    public String getPrivacy() {
        return Privacy;
    }

    public void setPrivacy(String privacy) {
        Privacy = privacy;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
