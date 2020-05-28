package com.example.mobile_inventory_new;

public class Service {
    private String date;
    private String quan;
    private String desc;
    public Service(String date,String quan,String desc){
        this.date=date;
        this.quan=quan;
        this.desc=desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
