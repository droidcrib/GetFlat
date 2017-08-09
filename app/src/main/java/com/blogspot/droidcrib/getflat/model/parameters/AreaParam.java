
package com.blogspot.droidcrib.getflat.model.parameters;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Areas", id = "_id")
public class AreaParam extends Model {

    @Column(name = "areaTotalMin")
    public String areaTotalMin;
    @Column(name = "serverid")
    public String serverid;
}