
package com.blogspot.droidcrib.getflat.model.parameters;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "CityDistricts", id = "_id")
public class DistrictParam extends Model {

    @Column(name = "district")
    public String district;
    @Column(name = "serverid")
    public String serverid;

    @Column(name = "city", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public CityParam city;
}