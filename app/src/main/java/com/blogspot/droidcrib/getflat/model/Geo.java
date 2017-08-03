
package com.blogspot.droidcrib.getflat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geo {

    @SerializedName("address")
    @Expose
    private Address address;

    @Override
    public String toString() {
        return "Geo{" +
                "\n  address=" + address +
                ",\n   district=" + district +
                ",\n   microdistrict=" + microdistrict +
                ",\n   building=" + building +
                '}';
    }

    @SerializedName("district")
    @Expose
    private District district;
    @SerializedName("microdistrict")
    @Expose
    private Microdistrict microdistrict;
    @SerializedName("building")
    @Expose
    private Object building;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Microdistrict getMicrodistrict() {
        return microdistrict;
    }

    public void setMicrodistrict(Microdistrict microdistrict) {
        this.microdistrict = microdistrict;
    }

    public Object getBuilding() {
        return building;
    }

    public void setBuilding(Object building) {
        this.building = building;
    }

}
