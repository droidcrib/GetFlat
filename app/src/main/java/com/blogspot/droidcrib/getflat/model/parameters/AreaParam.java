
package com.blogspot.droidcrib.getflat.model.parameters;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

@Table(name = "AreaParams", id = "_id")
public class AreaParam extends Model {

    @Column(name = "areaTotalMin")
    public String areaTotalMin;
    @Column(name = "serverid")
    public String serverid;


    public static List<AreaParam> queryAll(){
        return new Select()
                .from(AreaParam.class)
                .execute();
    }

    @Override
    public String toString() {
        return areaTotalMin;
    }
}