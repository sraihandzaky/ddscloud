package com.example.veradebora.dds.Object;

/**
 * Created by Vera Debora on 8/20/2018.
 */

public class BillHistoryObject {

    private String Hostname;
    private String Status;

    public BillHistoryObject(String hostname, String status) {
        Hostname = hostname;
        Status = status;
    }

    public String getHostname() {

        return Hostname;
    }

    public void setHostname(String hostname) {
        Hostname = hostname;
    }

    public String getStatus() {
        switch (Status){
            case "1":
                return "Running";
        }
        return null;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
