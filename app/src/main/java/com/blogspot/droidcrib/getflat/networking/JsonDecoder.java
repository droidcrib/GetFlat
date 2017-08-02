package com.blogspot.droidcrib.getflat.networking;

import android.util.Log;

import com.blogspot.droidcrib.getflat.model.card.Card;
import com.blogspot.droidcrib.getflat.model.Message;

import java.util.List;

/**
 * Created by BulanovA on 02.08.2017.
 */

public class JsonDecoder {
    public static final String TAG = "JsonDecoder";

    private JsonDecoder() {
        super();
    }

    public static void getCards(String json){
        Message message = GsonSingleton.getInstance().fromJson(json, Message.class);
        List<Card> categoriesList = message.getCards();

        for (Card card : categoriesList) {
            Log.d(TAG, "getCards: " + card.toString());
            card.insert();
            // TODO: save data to database
        }
    }

}
