
package com.blogspot.droidcrib.getflat.model.parameters;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "SubwayDistances", id = "_id")
public class SubwayDistance extends Model {

    @Column(name = "subwayDistanceMax")
    public String subwayDistanceMax;

}