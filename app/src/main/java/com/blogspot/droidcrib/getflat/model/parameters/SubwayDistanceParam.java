
package com.blogspot.droidcrib.getflat.model.parameters;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "SubwayDistanceParams", id = "_id")
public class SubwayDistanceParam extends Model {

    @Column(name = "subwayDistanceMax")
    public String subwayDistanceMax;

    @Column(name = "serverid")
    public String serverid;

    public List<SubwayDistanceParam> queryAll(){
        return new Select()
                .from(SubwayDistanceParam.class)
                .execute();
    }

}