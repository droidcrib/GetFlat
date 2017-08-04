
package com.blogspot.droidcrib.getflat.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Table(name = "Addresses", id = "_id")
public class Address extends Model {

    @Column(name = "streetOrBuilding")
    @SerializedName("streetOrBuilding")
    @Expose
    public String streetOrBuilding;
    @Column(name = "streetOrBuildingFull")
    @SerializedName("streetOrBuildingFull")
    @Expose
    public String streetOrBuildingFull;
    @Column(name = "house")
    @SerializedName("house")
    @Expose
    public String house;
    @Column(name = "geo", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Geo geo;

    public void insert(Card card){
        this.geo = card.geo;
        this.save();
    }

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
