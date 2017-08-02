
package com.blogspot.droidcrib.getflat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geo {

    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("district")
    @Expose
    private District district;
    @SerializedName("microdistrict")
    @Expose
    private Object microdistrict;
    @SerializedName("building")
    @Expose
    private Object building;

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Object getMicrodistrict() {
        return microdistrict;
    }

    public void setMicrodistrict(Object microdistrict) {
        this.microdistrict = microdistrict;
    }

    public Object getBuilding() {
        return building;
    }

    public void setBuilding(Object building) {
        this.building = building;
    }

}
