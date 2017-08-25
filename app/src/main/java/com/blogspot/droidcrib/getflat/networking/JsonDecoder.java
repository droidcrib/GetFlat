package com.blogspot.droidcrib.getflat.networking;

import android.os.AsyncTask;
import android.util.Log;

import com.blogspot.droidcrib.getflat.evenbus.DatabaseUpdatedEvent;
import com.blogspot.droidcrib.getflat.model.card.Card;
import com.blogspot.droidcrib.getflat.model.card.HouseFeature;
import com.blogspot.droidcrib.getflat.model.card.Message;
import com.blogspot.droidcrib.getflat.model.card.RealtyFeature;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by BulanovA on 02.08.2017.
 */

public class JsonDecoder {
    public static final String TAG = "AppThis";

    private JsonDecoder() {
        super();
    }

    public static List<Card> getCardsFromJSON(String json) {
        Message message = GsonSingleton.getInstance().fromJson(json, Message.class);
        List<Card> cardsList = message.getCards();
        Log.d(TAG, "getCardsFromJSON: "   + cardsList.size());
        return cardsList;
    }


    public static void saveCardsToDatabase(final List<Card> cardsList) {
        Log.d(TAG, "saveCardsToDatabase: " + cardsList.size());
        new Thread(new Runnable() {
            @Override
            public void run() {
                //Save cards to database
                for (Card card : cardsList) {
                    card.insert();
                    card.geo.insert(card);
                    if (card.geo.address != null) {
                        card.geo.address.insert(card);
                    }
                    if (card.geo.district != null) {
                        card.geo.district.insert(card);
                    }
                    if (card.geo.microdistrict != null) {
                        card.geo.microdistrict.insert(card);
                    }
                    if (card.geo.building != null) {
                        card.geo.building.insert(card);
                    }
                    card.photo.insert(card);
                    card.description.insert(card);
                    card.sourceLink.insert(card);
                    card.time.insert(card);

                    List<HouseFeature> hf = card.houseFeatures;
                    for (HouseFeature feature : hf) {
                        feature.insert(card);
                    }
                    List<RealtyFeature> rf = card.realtyFeatures;
                    for (RealtyFeature feature : rf) {
                        feature.insert(card);
                    }
                }
                // TODO: post "finished" event from here
                EventBus.getDefault().post(new DatabaseUpdatedEvent());
            }
        }).start();
    }

    public static String getJSONFromResponse(final String httpResponse) {

        Pattern p = Pattern.compile("(__APP_INITIAL_STATE__\\s+=\\s+)(.+)(;)");
        Matcher m = p.matcher(httpResponse);
        if (m.find()) {
            Log.d(TAG, "MATCH");
//                    Log.d(TAG, "getJSONFromResponse: " + m.group(2));
//                    saveHtmlFile(m.group(2));
        } else {
            Log.d(TAG, "NO MATCH");
        }


        return m.group(2);
    }
}
