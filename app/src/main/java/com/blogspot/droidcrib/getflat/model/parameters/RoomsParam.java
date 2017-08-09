
package com.blogspot.droidcrib.getflat.model.parameters;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Rooms", id = "_id")
public class RoomsParam extends Model {

    @Column(name = "roomCount")
    public String roomCount;
    @Column(name = "serverid")
    public String serverid;
}