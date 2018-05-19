package com.by.taxi.lovetaxi2.javabean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobGeoPoint;

/**
 * Created by 风吹草地 on 2018/5/8.
 */

public class driver_location extends BmobObject {

    private MyUser drivername;
    private Integer dl_rid;
    private  Integer dl_status;
    private BmobGeoPoint dl_location;

    public MyUser getDrivername() {
        return drivername;
    }

    public void setDrivername(MyUser drivername) {
        this.drivername = drivername;
    }



    public Integer getDl_rid() {
        return dl_rid;
    }

    public void setDl_rid(Integer dl_rid) {
        this.dl_rid = dl_rid;
    }



    public Integer getDl_status() {
        return dl_status;
    }

    public void setDl_status(Integer dl_status) {
        this.dl_status = dl_status;
    }



    public BmobGeoPoint getDl_location() {
        return dl_location;
    }

    public void setDl_location(BmobGeoPoint dl_location) {
        this.dl_location = dl_location;
    }


}
