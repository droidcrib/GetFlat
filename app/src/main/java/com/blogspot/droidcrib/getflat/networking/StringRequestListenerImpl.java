package com.blogspot.droidcrib.getflat.networking;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.blogspot.droidcrib.getflat.model.card.Card;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import static com.blogspot.droidcrib.getflat.networking.JsonDecoder.getCardsFromJSON;
import static com.blogspot.droidcrib.getflat.networking.JsonDecoder.getJSONFromResponse;

/**
 * Created by BulanovA on 20.10.2017.
 */

public class StringRequestListenerImpl implements StringRequestListener {

    private static final String TAG = "RequestListenerImpl";


    private StringRequestListenerImpl(){
    }

    public static StringRequestListenerImpl getInstance(){
        return StringRequestListenerImpl.ListenerHolder.instance;
    }

    private static class ListenerHolder{
        private final static StringRequestListenerImpl instance = new StringRequestListenerImpl();
    }

    @Override
    public void onResponse(String response) {
        Log.d(TAG, "onResponse: StringRequestListenerImpl = " + response);
        // Updating database from here
        String stringResponse = getJSONFromResponse(response);
        List<Card> cardsList = getCardsFromJSON(stringResponse);
        JsonDecoder.saveCardsToDatabase(cardsList);
    }

    @Override
    public void onError(ANError anError) {

        Log.d(TAG, "onError: StringRequestListenerImpl = " + anError.toString());
    }
}
