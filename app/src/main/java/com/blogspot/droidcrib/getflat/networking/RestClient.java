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
import com.blogspot.droidcrib.getflat.evenbus.NoInternetEvent;
import com.blogspot.droidcrib.getflat.model.parameters.ParamsMap;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.List;

/**
 * Created by BulanovA on 01.08.2017.
 */

public class RestClient {


    private static final String TAG = "getflat_RestClient";
    private static boolean returnValue = false;
    public static boolean isNetworkConnected = true;
    public static boolean isOnline = true;



    private RestClient() {
        super();
    }

    public static ArrayMap<String, String> getQueryParameters() {
        ArrayMap<String, String> queryParams = new ArrayMap<>();
        List<ParamsMap> list = ParamsMap.queryAllActive();
        for (ParamsMap params : list) {
            queryParams.put(params.param, params.value);
        }


        Log.d(TAG, "List<ParamsMap>: " + queryParams);
        return queryParams;
    }

    public static void getRequest(String address, ArrayMap<String, String> params, int pageNum){

        AndroidNetworking.get("https://www.lun.ua/{addr}")
                .addPathParameter("addr", address)
                .addQueryParameter(params)
                .addQueryParameter("page",String.valueOf(pageNum))
                .build()
                .getAsString(StringRequestListenerImpl.getInstance());
    }

    public static void newGetRequest(String addr, ArrayMap<String, String> params, int page) {
        EventBus.getDefault().post(new NewNetworkRequestEvent(addr, params, page));
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
                        Toast.makeText(context, "!!! internet_connected !!!", Toast.LENGTH_LONG).show();
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

    // TCP/HTTP/DNS (depending on the port, 53=DNS, 80=HTTP, etc.)
    public static boolean isOnline() {
        try {
            int timeoutMs = 1500;
            Socket sock = new Socket();
            SocketAddress sockaddr = new InetSocketAddress("8.8.8.8", 53);

            sock.connect(sockaddr, timeoutMs);
            sock.close();

            return true;
        } catch (IOException e) {
            return false;
        }
    }


}
