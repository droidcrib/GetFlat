
package com.blogspot.droidcrib.getflat.model.parameters;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "RoomsParams", id = "_id")
public class RoomsParam extends Model {

    @Column(name = "roomCount")
    public String roomCount;
    @Column(name = "serverid")
    public String serverid;

    public static List<RoomsParam> queryAll(){
        return new Select()
                .from(RoomsParam.class)
                .execute();
    }

    @Override
    public String toString() {
        return roomCount;
    }
}