package com.blogspot.droidcrib.getflat.networking;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.util.ArrayMap;

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






        return parametersMap;
    }
}
