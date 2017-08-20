package com.blogspot.droidcrib.getflat.networking;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.util.ArrayMap;
import android.util.Log;

import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_AREA_TOTAL_MIN;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_CURRENCY;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_DISTRICT;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_HAS_PHOTOS;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_NEAR_SUBWAY;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_NEW_BIULDING;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_PRICE_MAX;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_ROOM_COUNT;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_WITHOUT_BROKERS;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_WITHOUT_FEE;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_CHECKBOX_BUILDING;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_CHECKBOX_NO_BROKERS;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_CHECKBOX_NO_FEE;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_CHECKBOX_NEAR_SUBWAY;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_CHECKBOX_WITH_PHOTO;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_SPINNER_AREA;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_SPINNER_DISTRICT;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_SPINNER_PRICE;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_SPINNER_ROOMS;
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

        parametersMap.put(PARAM_NEW_BIULDING, prefs.getString(PREFS_CHECKBOX_BUILDING, "0"));
        parametersMap.put(PARAM_NEAR_SUBWAY, prefs.getString(PREFS_CHECKBOX_NEAR_SUBWAY, "0"));
        parametersMap.put(PARAM_HAS_PHOTOS, prefs.getString(PREFS_CHECKBOX_WITH_PHOTO, "0"));
        parametersMap.put(PARAM_WITHOUT_BROKERS, prefs.getString(PREFS_CHECKBOX_NO_BROKERS, "0"));
        parametersMap.put(PARAM_WITHOUT_FEE, prefs.getString(PREFS_CHECKBOX_NO_FEE, "0"));

        parametersMap.put(PARAM_DISTRICT, String.valueOf(prefs.getInt(PREFS_SPINNER_DISTRICT, 0)));
//        parametersMap.put(PARAM_SUBWAY, prefs.getString(, "0"));
//        parametersMap.put(PARAM_SUBWAY_DISTANCE_MAX, prefs.getString(, "0"));

        parametersMap.put(PARAM_ROOM_COUNT, String.valueOf(prefs.getInt(PREFS_SPINNER_ROOMS, 0)));
        parametersMap.put(PARAM_AREA_TOTAL_MIN, String.valueOf(prefs.getInt(PREFS_SPINNER_AREA, 0)));
        parametersMap.put(PARAM_PRICE_MAX, String.valueOf(prefs.getInt(PREFS_SPINNER_PRICE, 0)));
        parametersMap.put(PARAM_CURRENCY, "2");// Use UAH
//        parametersMap.put(PARAM_SECONDARY_ONLY, prefs.getString(, "0"));
        //use these two together

        for (android.support.v4.util.ArrayMap.Entry<String, String> pair : parametersMap.entrySet()) {
            Log.d(TAG, "getQueryParameters: " + pair.getKey() + " " + pair.getValue());
        }

        return parametersMap;
    }
}
