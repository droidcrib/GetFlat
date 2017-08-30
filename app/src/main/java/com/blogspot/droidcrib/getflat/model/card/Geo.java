
package com.blogspot.droidcrib.getflat.model.card;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Table(name = "Geos", id = "_id")
public class Geo extends Model {

    @Column(name = "address")
    @SerializedName("address")
    @Expose
    public Address address;
    @Column(name = "district")
    @SerializedName("district")
    @Expose
    public District district;
    @Column(name = "microdistrict")
    @SerializedName("microdistrict")
    @Expose
    public Microdistrict microdistrict;
    @Column(name = "building")
    @SerializedName("building")
    @Expose
    public Building building;

    @Column(name = "card", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Card card;

    public void insert(Card card) {
        this.card = card;
        this.save();
    }

    public List<Address> getAddresses() {
        return getMany(Address.class, "geo");
    }

    public List<District> getDistricts() {
        return getMany(District.class, "geo");
    }

    public List<Microdistrict> getMicrodistricts() {
        return getMany(Microdistrict.class, "geo");
    }

    public List<Building> getBuildings() {
        return getMany(Building.class, "geo");
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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "\n address=" + address +
                ",\n  district=" + district +
                ",\n  microdistrict=" + microdistrict +
                ",\n  building=" + building +
                '}';
    }
}
