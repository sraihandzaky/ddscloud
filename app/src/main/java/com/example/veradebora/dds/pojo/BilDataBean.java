package com.example.veradebora.dds.pojo;

/**
 * Created by Vera Debora on 8/21/2018.
 */

public class BilDataBean {
    /**
     * id : 135
     * date : 2018-08-20 22:42:31
     * date_expire : 2018-08-21 22:42:31
     * amount : 20000122
     * status : 1
     * id_user : 41
     * name_bank_account : t-money
     */

    private String id;
    private String date;
    private String date_expire;
    private String amount;
    private String status;
    private String id_user;
    private String name_bank_account;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate_expire() {
        return date_expire;
    }

    public void setDate_expire(String date_expire) {
        this.date_expire = date_expire;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getName_bank_account() {
        return name_bank_account;
    }

    public void setName_bank_account(String name_bank_account) {
        this.name_bank_account = name_bank_account;
    }
}
