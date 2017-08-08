
package com.blogspot.droidcrib.getflat.model.parameters;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.blogspot.droidcrib.getflat.model.card.Card;
import com.blogspot.droidcrib.getflat.model.card.Geo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Table(name = "Cities", id = "_id")
public class City extends Model {

    @Column(name = "name")
    public String name;

//    @Column(name = "geo", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
//    public Geo geo;
//
//    public void insert(Card card) {
//        this.geo = card.geo;
//        this.save();
//    }
}