
package com.blogspot.droidcrib.getflat.model.parameters;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Districts", id = "_id")
public class District extends Model {

    @Column(name = "name")
    public String name;
    @Column(name = "serverid")
    public String serverid;

    @Column(name = "city", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public City city;
}