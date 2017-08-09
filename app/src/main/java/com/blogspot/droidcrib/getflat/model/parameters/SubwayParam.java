
package com.blogspot.droidcrib.getflat.model.parameters;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Subways", id = "_id")
public class SubwayParam extends Model {

    @Column(name = "subway")
    public String subway;
    @Column(name = "serverid")
    public String serverid;
    @Column(name = "lineid")
    public String lineid;

    @Column(name = "city", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public CityParam city;
}