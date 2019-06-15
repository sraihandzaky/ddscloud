package com.example.veradebora.dds.pojo;

import java.util.List;

/**
 * Created by Vera Debora on 8/21/2018.
 */

public class TopUpHistoResponse {

    /**
     * result : true
     * message : billings data found
     * bil_data : [{"id":"135","date":"2018-08-20 22:42:31","date_expire":"2018-08-21 22:42:31","amount":"20000122","status":"1","id_user":"41","name_bank_account":"t-money"},{"id":"132","date":"2018-08-20 11:34:10","date_expire":"2018-08-21 11:34:10","amount":"15147","status":"0","id_user":"41","name_bank_account":"Manduri"},{"id":"129","date":"2018-08-03 14:28:20","date_expire":"2018-08-04 14:28:20","amount":"14136","status":"0","id_user":"41","name_bank_account":"Creep"},{"id":"128","date":"2018-08-02 11:36:49","date_expire":"2018-08-03 11:36:49","amount":"50426","status":"0","id_user":"41","name_bank_account":"Kudaku"},{"id":"127","date":"2018-07-31 17:56:30","date_expire":"2018-08-01 17:56:30","amount":"18763","status":"0","id_user":"41","name_bank_account":"Sutejo"},{"id":"115","date":"2018-07-19 16:11:57","date_expire":"2018-07-20 16:11:57","amount":"55660","status":"0","id_user":"41","name_bank_account":"Mandiri"},{"id":"110","date":"2018-07-19 15:36:01","date_expire":"2018-07-20 15:36:01","amount":"75238","status":"0","id_user":"41","name_bank_account":"Mandiri"},{"id":"109","date":"2018-07-19 13:49:05","date_expire":"2018-07-20 13:49:05","amount":"60221","status":"0","id_user":"41","name_bank_account":"Mandiri"},{"id":"108","date":"2018-07-19 13:47:41","date_expire":"2018-07-20 13:47:41","amount":"50922","status":"0","id_user":"41","name_bank_account":"Mandiri"},{"id":"107","date":"2018-07-19 13:44:50","date_expire":"2018-07-20 13:44:50","amount":"100326","status":"0","id_user":"41","name_bank_account":"Mandiri"},{"id":"106","date":"2018-07-19 13:42:33","date_expire":"2018-07-20 13:42:33","amount":"200731","status":"0","id_user":"41","name_bank_account":"Mandiri"},{"id":"105","date":"2018-07-19 13:32:06","date_expire":"2018-07-20 13:32:06","amount":"150691","status":"0","id_user":"41","name_bank_account":"Mandiri"},{"id":"104","date":"2018-07-17 15:04:13","date_expire":"2018-07-18 15:04:13","amount":"50000563","status":"0","id_user":"41","name_bank_account":"Mandiri"},{"id":"103","date":"2018-07-17 14:56:46","date_expire":"2018-07-18 14:56:46","amount":"100000668","status":"0","id_user":"41","name_bank_account":"Mandiri"},{"id":"91","date":"2018-07-13 11:46:16","date_expire":"2018-07-14 11:46:16","amount":"55930","status":"0","id_user":"41","name_bank_account":"Mandiri"},{"id":"90","date":"2018-07-13 11:45:29","date_expire":"2018-07-14 11:45:29","amount":"55912","status":"0","id_user":"41","name_bank_account":"Mandiri"},{"id":"89","date":"2018-07-13 11:43:45","date_expire":"2018-07-14 11:43:45","amount":"777948","status":"0","id_user":"41","name_bank_account":"Mandiri"},{"id":"88","date":"2018-07-13 11:40:56","date_expire":"2018-07-14 11:40:56","amount":"100394","status":"0","id_user":"41","name_bank_account":"andre"},{"id":"85","date":"2018-07-13 11:36:48","date_expire":"2018-07-14 11:36:48","amount":"100782","status":"0","id_user":"41","name_bank_account":"andre"},{"id":"84","date":"2018-07-13 11:36:40","date_expire":"2018-07-14 11:36:40","amount":"100626","status":"0","id_user":"41","name_bank_account":"andre"},{"id":"83","date":"2018-07-13 11:36:31","date_expire":"2018-07-14 11:36:31","amount":"100544","status":"0","id_user":"41","name_bank_account":"andre"},{"id":"82","date":"2018-07-13 11:35:51","date_expire":"2018-07-14 11:35:51","amount":"100229","status":"0","id_user":"41","name_bank_account":"andre"},{"id":"81","date":"2018-07-13 11:35:40","date_expire":"2018-07-14 11:35:40","amount":"100794","status":"0","id_user":"41","name_bank_account":"BCA"},{"id":"80","date":"2018-07-13 11:35:26","date_expire":"2018-07-14 11:35:26","amount":"100301","status":"0","id_user":"41","name_bank_account":"BCA"},{"id":"79","date":"2018-07-13 11:35:16","date_expire":"2018-07-14 11:35:16","amount":"100725","status":"0","id_user":"41","name_bank_account":"BCA"},{"id":"78","date":"2018-07-13 11:35:02","date_expire":"2018-07-14 11:35:02","amount":"100177","status":"0","id_user":"41","name_bank_account":"Mandiri"},{"id":"77","date":"2018-07-11 11:42:10","date_expire":"2018-07-12 11:42:10","amount":"10000182","status":"1","id_user":"41","name_bank_account":"t-money"},{"id":"76","date":"2018-07-11 11:42:06","date_expire":"2018-07-12 11:42:06","amount":"10000651","status":"1","id_user":"41","name_bank_account":"t-money"},{"id":"73","date":"2018-06-28 11:38:03","date_expire":"2018-06-29 11:38:03","amount":"1000398","status":"1","id_user":"41","name_bank_account":"t-money"},{"id":"72","date":"2018-05-15 15:42:29","date_expire":"2018-05-16 15:42:29","amount":"56223","status":"1","id_user":"41","name_bank_account":"t-money"}]
     */

    private boolean result;
    private String message;
    private List<BilDataBean> bil_data;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<BilDataBean> getBil_data() {
        return bil_data;
    }

    public void setBil_data(List<BilDataBean> bil_data) {
        this.bil_data = bil_data;
    }
}
