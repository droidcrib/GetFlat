
package com.blogspot.droidcrib.getflat.model.parameters;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "DistrictParams", id = "_id")
public class DistrictParam extends Model {

    @Column(name = "district")
    public String district;
    @Column(name = "serverid")
    public String serverid;

    @Column(name = "city", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public CityParam city;

    public List<DistrictParam> queryAll(){
        return new Select()
                .from(DistrictParam.class)
                .execute();
    }
}