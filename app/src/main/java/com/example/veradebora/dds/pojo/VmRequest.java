package com.example.veradebora.dds.pojo;

/**
 * Created by Vera Debora on 8/24/2018.
 */

public class VmRequest {

    /**
     * result : true
     * message : request vm succesfully
     * vm_data : {"id":"226","identifier_vm":"92a2606c3322ffdf9723d237728bf3a8","user_name":"Vera","id_user":"32","id_vm":"default","ip_vm":"default","image":"eef9d93d-c05c-45de-85c4-05561d9b959b","flavor":"2_4_80","keypair":"not-set","hostname":"Mr.A-Z","usage_purpose":"created by system","supervisor":"created by system","supervisor_phone_number":"created by system","date_request":"2018-07-30 15:58:33","status":"1","date_approval":"default","id_admin":"0"}
     */

    private boolean result;
    private String message;
    private VmDataBean vm_data;

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

    public VmDataBean getVm_data() {
        return vm_data;
    }

    public void setVm_data(VmDataBean vm_data) {
        this.vm_data = vm_data;
    }

    public static class VmDataBean {
        /**
         * id : 226
         * identifier_vm : 92a2606c3322ffdf9723d237728bf3a8
         * user_name : Vera
         * id_user : 32
         * id_vm : default
         * ip_vm : default
         * image : eef9d93d-c05c-45de-85c4-05561d9b959b
         * flavor : 2_4_80
         * keypair : not-set
         * hostname : Mr.A-Z
         * usage_purpose : created by system
         * supervisor : created by system
         * supervisor_phone_number : created by system
         * date_request : 2018-07-30 15:58:33
         * status : 1
         * date_approval : default
         * id_admin : 0
         */

        private String id;
        private String identifier_vm;
        private String user_name;
        private String id_user;
        private String id_vm;
        private String ip_vm;
        private String image;
        private String flavor;
        private String keypair;
        private String hostname;
        private String usage_purpose;
        private String supervisor;
        private String supervisor_phone_number;
        private String date_request;
        private String status;
        private String date_approval;
        private String id_admin;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIdentifier_vm() {
            return identifier_vm;
        }

        public void setIdentifier_vm(String identifier_vm) {
            this.identifier_vm = identifier_vm;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getId_user() {
            return id_user;
        }

        public void setId_user(String id_user) {
            this.id_user = id_user;
        }

        public String getId_vm() {
            return id_vm;
        }

        public void setId_vm(String id_vm) {
            this.id_vm = id_vm;
        }

        public String getIp_vm() {
            return ip_vm;
        }

        public void setIp_vm(String ip_vm) {
            this.ip_vm = ip_vm;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getFlavor() {
            return flavor;
        }

        public void setFlavor(String flavor) {
            this.flavor = flavor;
        }

        public String getKeypair() {
            return keypair;
        }

        public void setKeypair(String keypair) {
            this.keypair = keypair;
        }

        public String getHostname() {
            return hostname;
        }

        public void setHostname(String hostname) {
            this.hostname = hostname;
        }

        public String getUsage_purpose() {
            return usage_purpose;
        }

        public void setUsage_purpose(String usage_purpose) {
            this.usage_purpose = usage_purpose;
        }

        public String getSupervisor() {
            return supervisor;
        }

        public void setSupervisor(String supervisor) {
            this.supervisor = supervisor;
        }

        public String getSupervisor_phone_number() {
            return supervisor_phone_number;
        }

        public void setSupervisor_phone_number(String supervisor_phone_number) {
            this.supervisor_phone_number = supervisor_phone_number;
        }

        public String getDate_request() {
            return date_request;
        }

        public void setDate_request(String date_request) {
            this.date_request = date_request;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDate_approval() {
            return date_approval;
        }

        public void setDate_approval(String date_approval) {
            this.date_approval = date_approval;
        }

        public String getId_admin() {
            return id_admin;
        }

        public void setId_admin(String id_admin) {
            this.id_admin = id_admin;
        }
    }
}
