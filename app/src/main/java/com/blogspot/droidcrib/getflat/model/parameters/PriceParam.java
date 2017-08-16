
package com.blogspot.droidcrib.getflat.model.parameters;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "PriceParams", id = "_id")
public class PriceParam extends Model {

    @Column(name = "priceMax")
    public String priceMax;
    @Column(name = "priceMin")
    public String priceMin;
    @Column(name = "serverid")
    public String serverid;

    public static List<PriceParam> queryAll(){
        return new Select()
                .from(PriceParam.class)
                .execute();
    }

    @Override
    public String toString() {
        return priceMax;
    }
}