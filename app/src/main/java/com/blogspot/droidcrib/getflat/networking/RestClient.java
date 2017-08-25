package com.blogspot.droidcrib.getflat.networking;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interfaces.StringRequestListener;
import com.blogspot.droidcrib.getflat.evenbus.NewNetworkRequestEvent;
import com.blogspot.droidcrib.getflat.model.parameters.ParamsMap;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
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

    public static void checkNetworkConnection(final Context context) {

        new AsyncTask<Void, Void, Boolean[]>() {

            @Override
            protected Boolean[] doInBackground(Void... voids) {
                Boolean[] values = new Boolean[2];
                values[0] = isNetworkAvailable(context);
                values[1] = isOnline();
                return values;
            }

            @Override
            protected void onPostExecute(Boolean[] values) {
                super.onPostExecute(values);
                if (values[0]) {
                    if (values[1]) {
                        return;
                    }
                    Toast.makeText(context, "no_internet_connection", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(context, "no_network_connection", Toast.LENGTH_LONG).show();
                }

            }
        }.execute();

    }


    // Checking Network is Connected
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    // Checking the Internet is Connected
    public static boolean isOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }


}
