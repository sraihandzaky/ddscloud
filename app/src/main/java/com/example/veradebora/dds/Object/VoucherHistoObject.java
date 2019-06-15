package com.example.veradebora.dds.Object;

/**
 * Created by Vera Debora on 8/21/2018.
 */

public class VoucherHistoObject {

    private String status;
    private String date;
    private String amount;

    public VoucherHistoObject(String status, String date, String amount) {
        this.status = status;
        this.date = date;
        this.amount = amount;
    }

    public String getStatus() {
        switch (status){
            case "1":
                return "Success";
        }
        return null;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
