
package com.blogspot.droidcrib.getflat.model.parameters;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Price", id = "_id")
public class Price extends Model {

    @Column(name = "price")
    public String price;
    @Column(name = "serverid")
    public String serverid;
}