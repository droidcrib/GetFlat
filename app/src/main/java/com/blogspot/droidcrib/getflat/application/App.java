package com.blogspot.droidcrib.getflat.application;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.blogspot.droidcrib.getflat.evenbus.NewNetworkRequestEvent;
import com.blogspot.droidcrib.getflat.evenbus.NewNetworkResponseEvent;
import com.blogspot.droidcrib.getflat.networking.RestClient;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.stetho.Stetho;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;



/**
 * Created by BulanovA on 31.07.2017.
 */

public class App extends com.activeandroid.app.Application implements StringRequestListener {

    private static final String TAG = "AppThis";

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);

        AndroidNetworking.initialize(getApplicationContext());

        // Create an InitializerBuilder
        Stetho.InitializerBuilder initializerBuilder =
                Stetho.newInitializerBuilder(this);

        // Enable Chrome DevTools
        initializerBuilder.enableWebKitInspector(
                Stetho.defaultInspectorModulesProvider(this)
        );

        // Enable command line interface
        initializerBuilder.enableDumpapp(
                Stetho.defaultDumperPluginsProvider(this)
        );

        // Use the InitializerBuilder to generate an Initializer
        Stetho.Initializer initializer = initializerBuilder.build();

        // Initialize Stetho with the Initializer
        Stetho.initialize(initializer);

        EventBus.getDefault().register(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        EventBus.getDefault().unregister(this);
    }

    // addr = "аренда-квартир-киев"
//    private void networkRequest(String addr, ArrayMap<String, String> params) {
//        AndroidNetworking.get("https://www.lun.ua/{addr}")
//                .addPathParameter("addr", addr)
//                .addQueryParameter(params)
//                .build()
//                .getAsString(this);
//    }


    @Override
    public void onResponse(String response) {
        EventBus.getDefault().post(new NewNetworkResponseEvent(response));
        Log.i(TAG, "APPLICATION onResponse: " + response.length());
    }

    @Override
    public void onError(ANError anError) {
        Log.e(TAG, "onError: " + anError.toString());
    }


    @Subscribe
    public void onEvent(NewNetworkRequestEvent event) {
        RestClient.getRequest(event.getAddr(), event.getParams(), this);
    }
}
