package com.blogspot.droidcrib.getflat.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by BulanovA on 31.07.2017.
 */

@Table(name = "ApiRecords", id = "_id")
public class ApiRecord extends Model {

    @Column(name = "year")
    public int year;
}
