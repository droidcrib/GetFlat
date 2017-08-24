package com.blogspot.droidcrib.getflat.networking;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.util.ArrayMap;
import android.util.Log;

import com.blogspot.droidcrib.getflat.model.parameters.AreaParam;

import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_AREA_TOTAL_MIN;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_CURRENCY;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_DISTRICT;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_HAS_PHOTOS;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_NEAR_SUBWAY;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_NEW_BIULDING;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_PRICE_MAX;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_ROOM_COUNT;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_SUBWAY;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_SUBWAY_DISTANCE_MAX;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_WITHOUT_BROKERS;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_WITHOUT_FEE;
import static com.blogspot.droidcrib.getflat.contract.Constants.SHARED_PREFS;

/**
 * Created by BulanovA on 01.08.2017.
 */

public class RestClient {

    private RestClient() {
        super();
    }

    private static final String TAG = "RestClient";

    public static ArrayMap<String, String> getQueryParameters(Context context) {

        SharedPreferences prefs = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        ArrayMap<String, String> parametersMap = new ArrayMap<>();

        // читаем все параметры из преференс в мап потом в цикле проходим по мап и удаляем все, у которых
        // значения равны -1

        // значене это колонка serverId. переделать ниже
//        parametersMap.put(PARAM_NEW_BIULDING, prefs.getString(PREFS_CHECKBOX_BUILDING, "0"));
//        parametersMap.put(PARAM_NEAR_SUBWAY, prefs.getString(PREFS_CHECKBOX_NEAR_SUBWAY, "0"));
//        parametersMap.put(PARAM_HAS_PHOTOS, prefs.getString(PREFS_CHECKBOX_WITH_PHOTO, "0"));
//        parametersMap.put(PARAM_WITHOUT_BROKERS, prefs.getString(PREFS_CHECKBOX_NO_BROKERS, "0"));
//        parametersMap.put(PARAM_WITHOUT_FEE, prefs.getString(PREFS_CHECKBOX_NO_FEE, "0"));
//        parametersMap.put(PARAM_CURRENCY, "2");// Use UAH
//
//        int distrIndex = prefs.getInt(PREFS_SPINNER_DISTRICT, 1);
//        int subwayIndex = prefs.getInt(PREFS_SPINNER_SUBWAY, 1);
//        int subwayDistIndex = prefs.getInt(PREFS_SPINNER_SUBWAY_DISTANCE, 1);
//        int roomsIndex = prefs.getInt(PREFS_SPINNER_ROOMS, 1);
//        int areaIndex = prefs.getInt(PREFS_SPINNER_AREA, 1);
//        int priceIndex =   prefs.getInt(PREFS_SPINNER_PRICE, 1);
//
//        Log.d(TAG, "========================= queryServerIdByRowId: " + AreaParam.queryServerIdByRowId(areaIndex));
//
//        parametersMap.put(PARAM_DISTRICT, String.valueOf(prefs.getInt(PREFS_SPINNER_DISTRICT, 0)));
//        parametersMap.put(PARAM_SUBWAY, String.valueOf(prefs.getInt(PREFS_SPINNER_SUBWAY, 0)));
//        parametersMap.put(PARAM_SUBWAY_DISTANCE_MAX, String.valueOf(prefs.getInt(PREFS_SPINNER_SUBWAY_DISTANCE, 0)));
//        parametersMap.put(PARAM_ROOM_COUNT, String.valueOf(prefs.getInt(PREFS_SPINNER_ROOMS, 0)));
//        parametersMap.put(PARAM_AREA_TOTAL_MIN, String.valueOf(prefs.getInt(PREFS_SPINNER_AREA, 0)));
//        parametersMap.put(PARAM_PRICE_MAX, String.valueOf(prefs.getInt(PREFS_SPINNER_PRICE, 0)));

//        parametersMap.put(PARAM_SECONDARY_ONLY, prefs.getString(, "0"));
        //use these two together

        for (android.support.v4.util.ArrayMap.Entry<String, String> pair : parametersMap.entrySet()) {
            Log.d(TAG, "getQueryParameters: " + pair.getKey() + " " + pair.getValue());
        }

        return parametersMap;
    }
}
