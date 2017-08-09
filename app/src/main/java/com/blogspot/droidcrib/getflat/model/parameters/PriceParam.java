
package com.blogspot.droidcrib.getflat.model.parameters;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Prices", id = "_id")
public class PriceParam extends Model {

    @Column(name = "priceMax")
    public String priceMax;
    @Column(name = "priceMin")
    public String priceMin;
    @Column(name = "serverid")
    public String serverid;
}