package com.blogspot.droidcrib.getflat.networking;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.util.ArrayMap;

import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_AREA_TOTAL_MIN;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_CURRENCY;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_DISTRICT;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_HAS_PHOTOS;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_NEAR_SUBWAY;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_NEW_BIULDING;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_PRICE_MAX;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_ROOM_COUNT;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_SECONDARY_ONLY;
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

    public static ArrayMap<String, String> getQueryParameters(Context context){

        SharedPreferences prefs = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        ArrayMap<String, String> parametersMap = new ArrayMap<>();

        parametersMap.put( PARAM_NEW_BIULDING, prefs.;
        parametersMap.put( PARAM_NEAR_SUBWAY;
        parametersMap.put( PARAM_HAS_PHOTOS   ;
        parametersMap.put( PARAM_WITHOUT_BROKERS   ;
        parametersMap.put( PARAM_WITHOUT_FEE   ;
        parametersMap.put( PARAM_DISTRICT   ;
        parametersMap.put( PARAM_ROOM_COUNT  ;
        parametersMap.put( PARAM_AREA_TOTAL_MIN  ;
        parametersMap.put( PARAM_PRICE_MAX   ;
        parametersMap.put( PARAM_CURRENCY  ;
        parametersMap.put( PARAM_SECONDARY_ONLY ;
        //use these two together
        parametersMap.put( PARAM_SUBWAY    ;
        parametersMap.put( PARAM_SUBWAY_DISTANCE_MAX   ;



        return parametersMap;
    }
}
