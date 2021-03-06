
package com.blogspot.droidcrib.getflat.model.card;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.blogspot.droidcrib.getflat.model.card.Card;
import com.blogspot.droidcrib.getflat.model.card.Geo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Table(name = "Microdistricts", id = "_id")
public class Microdistrict extends Model{

    @Column(name = "name")
    @SerializedName("name")
    @Expose
    public String name;
    @Column(name = "searchUrl")
    @SerializedName("searchUrl")
    @Expose
    public String searchUrl;
    @Column(name = "geo", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Geo geo;

    public void insert(Card card){
        this.geo = card.geo;
        this.save();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    @Override
    public String toString() {
        return "Microdistrict{" +
                "\n name='" + name + '\'' +
                ",\n searchUrl='" + searchUrl + '\'' +
                '}';
    }
}
