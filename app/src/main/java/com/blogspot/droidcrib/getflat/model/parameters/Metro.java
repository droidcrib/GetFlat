
package com.blogspot.droidcrib.getflat.model.parameters;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Metros", id = "_id")
public class Metro extends Model {

    @Column(name = "name")
    public String name;
    @Column(name = "serverid")
    public String serverid;
    @Column(name = "lineid")
    public String lineid;

    @Column(name = "city", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public City city;
}