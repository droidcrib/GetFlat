
package com.blogspot.droidcrib.getflat.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Table(name = "Geos", id = "_id")
public class Geo extends Model {

    @SerializedName("address")
    @Expose
    public Address address;
    @SerializedName("district")
    @Expose
    public District district;
    @SerializedName("microdistrict")
    @Expose
    public Microdistrict microdistrict;
    @SerializedName("building")
    @Expose
    public Object building;
    @Column(name = "Card", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Card card;

    public void insert(Card card){
        this.card = card;
        this.save();
    }


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

    @Override
    public String toString() {
        return "Geo{" +
                "\n  address=" + address +
                ",\n   district=" + district +
                ",\n   microdistrict=" + microdistrict +
                ",\n   building=" + building +
                '}';
    }

}
