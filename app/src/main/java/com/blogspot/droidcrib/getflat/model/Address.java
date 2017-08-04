
package com.blogspot.droidcrib.getflat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("streetOrBuilding")
    @Expose
    private String streetOrBuilding;
    @SerializedName("streetOrBuildingFull")
    @Expose
    private String streetOrBuildingFull;
    @SerializedName("house")
    @Expose
    private String house;

    public String getStreetOrBuilding() {
        return streetOrBuilding;
    }

    public void setStreetOrBuilding(String streetOrBuilding) {
        this.streetOrBuilding = streetOrBuilding;
    }

    public String getStreetOrBuildingFull() {
        return streetOrBuildingFull;
    }

    public void setStreetOrBuildingFull(String streetOrBuildingFull) {
        this.streetOrBuildingFull = streetOrBuildingFull;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Address{" +
                "\n streetOrBuilding='" + streetOrBuilding + '\'' +
                ",\n streetOrBuildingFull='" + streetOrBuildingFull + '\'' +
                ",\n house='" + house + '\'' +
                '}';
    }
}
