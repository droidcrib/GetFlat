package com.blogspot.droidcrib.getflat.application;

import android.content.res.Configuration;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.blogspot.droidcrib.getflat.evenbus.NewNetworkRequestEvent;
import com.blogspot.droidcrib.getflat.networking.JsonDecoder;
import com.blogspot.droidcrib.getflat.networking.RestClient;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.stetho.Stetho;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import static com.blogspot.droidcrib.getflat.networking.JsonDecoder.getCardsFromJSON;
import static com.blogspot.droidcrib.getflat.networking.JsonDecoder.getJSONFromResponse;


/**
 * Created by BulanovA on 31.07.2017.
 */

public class App extends com.activeandroid.app.Application implements StringRequestListener {

    private static final String TAG = "getflat_app";
    public static boolean isConditionChanged = false;
    public static boolean isQueried = false;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "App --- onCreate: ");

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
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "App --- onConfigurationChanged: ");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "App --- onTerminate: ");
        EventBus.getDefault().unregister(this);
    }


    //
    // Network calls callbacks
    //
    @Override
    public void onResponse(String response) {
        //EventBus.getDefault().post(new NetworkResponseErrorEvent(response));
        Log.i(TAG, "App --- Network callback onResponse: " + response.length());
        // Updating database from here
        JsonDecoder.saveCardsToDatabase(getCardsFromJSON(getJSONFromResponse(response)));
    }

    @Override
    public void onError(ANError anError) {
        Log.e(TAG, "App --- Network callback onError: " + anError.toString());
    }


    // Start new network request
    @Subscribe
    public void onEvent(NewNetworkRequestEvent event) {
        RestClient.getRequest(event.getAddr(), event.getParams(), event.getPage());
    }


}
