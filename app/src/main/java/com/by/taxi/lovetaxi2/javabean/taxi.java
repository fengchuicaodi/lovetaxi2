package com.by.taxi.lovetaxi2.javabean;

import cn.bmob.v3.BmobObject;

/**
 * Created by 风吹草地 on 2018/5/13.
 */

public class taxi extends BmobObject {

    private String taxi_type;
    private String taxi_color;
    private String license_number;
    private MyUser drivername;

    public String getTaxi_type() {
        return taxi_type;
    }

    public void setTaxi_type(String taxi_type) {
        this.taxi_type = taxi_type;
    }



    public String getTaxi_color() {
        return taxi_color;
    }

    public void setTaxi_color(String taxi_color) {
        this.taxi_color = taxi_color;
    }

    public String getLicense_number() {
        return license_number;
    }

    public void setLicense_number(String license_number) {
        this.license_number = license_number;
    }


    public MyUser getDrivername() {
        return drivername;
    }

    public void setDrivername(MyUser drivername) {
        this.drivername = drivername;
    }
}
