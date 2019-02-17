package net.ufoproducts;

import java.util.ArrayList;
import java.util.Date;

public class Alert {
    public String id;
    public String lat;
    public String lon;
    public Date time;
    public String request;
    public Alert(String i, String la, String lo, Date t, String req) {
        id = i;
        lat = la;
        lon = lo;
        time = t;
        request = req;
    }
    public static Alert getAlert(String alert) {
        String[] fields = alert.split(",");
        for(int x = 0; x < fields.length; x++) {
            System.out.println(fields[x]);
        }
        if(fields.length != 5) {
            System.err.println("Invalid request length: Either old version or not a Redux");
            return new Alert("Error", "0", "0",  new Date(), "invalid_req");
        }
        Date date = DateParser.parseDate(fields[3]);
        System.out.println(date);//for verification that I'm not retarded
        return new Alert(fields[0], fields[1], fields[2], date, fields[4]);
    }
    /*public String toCsv() {
        return id + "," + lat + "," + lon + "," + request;
    }*/
    public String toString() {
        return "ID: " + id + ", latitude: " + lat + ", longitude: " + lon + ", time: " + time + ", request: " + request;
    }
}
