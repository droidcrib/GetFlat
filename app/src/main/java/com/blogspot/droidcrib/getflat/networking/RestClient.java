package com.blogspot.droidcrib.getflat.networking;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.util.ArrayMap;
import android.util.Log;

import com.blogspot.droidcrib.getflat.model.parameters.AreaParam;
import com.blogspot.droidcrib.getflat.model.parameters.ParamsMap;

import java.util.List;

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
        ArrayMap<String, String> queryParams = new ArrayMap<>();
        List<ParamsMap> list = ParamsMap.queryAll();
        for (ParamsMap params : list) {
            if(!params.value.equals("0")){
                queryParams.put(params.param, params.value);
            }
        }


        Log.d(TAG, "List<ParamsMap>: " + queryParams);
        return queryParams;
    }
}
