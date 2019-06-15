package com.example.veradebora.dds.pojo;

import java.util.List;

/**
 * Created by Vera Debora on 8/21/2018.
 */

public class VoucherHistoResponse {

    /**
     * result : true
     * message : billings data found
     * v_data : [{"id":"45","id_user":"41","code":"b5cf7636ca85000000","amount":"85000000","status":"1","created_at":"2018-07-20 10:17:17","updated_at":"2018-07-20 10:17:36"},{"id":"44","id_user":"41","code":"e997ad035630000","amount":"30000","status":"1","created_at":"2018-07-20 10:14:37","updated_at":"2018-07-20 10:14:53"},{"id":"43","id_user":"41","code":"fb22b11da330000","amount":"30000","status":"1","created_at":"2018-07-20 10:10:51","updated_at":"2018-07-20 10:12:54"}]
     */

    private boolean result;
    private String message;
    private List<VDataBean> v_data;

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

    public List<VDataBean> getV_data() {
        return v_data;
    }

    public void setV_data(List<VDataBean> v_data) {
        this.v_data = v_data;
    }
}
