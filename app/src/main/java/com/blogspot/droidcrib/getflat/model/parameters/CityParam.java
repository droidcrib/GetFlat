
package com.blogspot.droidcrib.getflat.model.parameters;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.blogspot.droidcrib.getflat.model.card.Card;
import com.blogspot.droidcrib.getflat.model.card.Geo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Table(name = "CityParams", id = "_id")
public class CityParam extends Model {

    @Column(name = "name")
    public String name;
    @Column(name = "serverid")
    public String serverid;


    public List<CityParam> queryAll(){
        return new Select()
                .from(CityParam.class)
                .execute();
    }
}