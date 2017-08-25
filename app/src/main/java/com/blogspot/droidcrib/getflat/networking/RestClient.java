package com.blogspot.droidcrib.getflat.networking;


import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interfaces.StringRequestListener;
import com.blogspot.droidcrib.getflat.evenbus.NewNetworkRequestEvent;
import com.blogspot.droidcrib.getflat.model.parameters.ParamsMap;

import org.greenrobot.eventbus.EventBus;

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
        List<ParamsMap> list = ParamsMap.queryAllActive();
        for (ParamsMap params : list) {
            queryParams.put(params.param, params.value);
        }
        Log.d(TAG, "List<ParamsMap>: " + list);
        return queryParams;
    }

    public static void newGetRequest(String addr, ArrayMap<String, String> params) {
        EventBus.getDefault().post(new NewNetworkRequestEvent(addr, params));

    }
}
