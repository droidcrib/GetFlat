package com.blogspot.droidcrib.getflat.networking;


import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.util.Log;

import com.blogspot.droidcrib.getflat.model.parameters.ParamsMap;

import java.util.List;

/**
 * Created by BulanovA on 01.08.2017.
 */

public class RestClient {

    private RestClient() {
        super();
    }

    private static final String TAG = "RestClient";

    public static ArrayMap<String, String> getQueryParameters(Context context) {

        ArrayMap<String, String> queryParams = new ArrayMap<>();
        List<ParamsMap> list = ParamsMap.queryAll();
        for (ParamsMap params : list) {
            if (!params.value.equals("0")) {
                queryParams.put(params.param, params.value);
            }
        }
        Log.d(TAG, "List<ParamsMap>: " + queryParams);
        return queryParams;
    }
}
