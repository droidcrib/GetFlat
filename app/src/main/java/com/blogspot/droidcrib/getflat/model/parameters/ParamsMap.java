package com.blogspot.droidcrib.getflat.model.parameters;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by BulanovA on 23.08.2017.
 */


@Table(name = "ParamsMap", id = "_id")
public class ParamsMap extends Model {

    @Column(name = "param")
    public String param;
    @Column(name = "value")
    public String value;
    @Column(name = "position")
    public int position;


    public static List<ParamsMap> queryAll() {
        return new Select()
                .from(ParamsMap.class)
                .execute();
    }

    public static String getValue(String paramName) {
        ParamsMap paramsMap = new Select()
                .from(ParamsMap.class)
                .where("param = ?", paramName)
                .executeSingle();
        return paramsMap.value;
    }

    public static int getPos(String paramName) {
        ParamsMap paramsMap = new Select()
                .from(ParamsMap.class)
                .where("param = ?", paramName)
                .executeSingle();
        return paramsMap.position;
    }


    public static void updateParameter(String paramName, String newValue, int position) {
        ParamsMap paramsMap = new Select()
                .from(ParamsMap.class)
                .where("param = ?", paramName)
                .executeSingle();

        paramsMap.value = newValue;
        paramsMap.position = position;
        paramsMap.save();
    }

    public static void updateParameter(String paramName, String newValue) {
        ParamsMap paramsMap = new Select()
                .from(ParamsMap.class)
                .where("param = ?", paramName)
                .executeSingle();

        paramsMap.value = newValue;
        paramsMap.save();

    }

    @Override
    public String toString() {
        return param + " " + value;
    }
}
