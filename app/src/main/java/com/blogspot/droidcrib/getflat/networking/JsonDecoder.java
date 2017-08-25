package com.blogspot.droidcrib.getflat.networking;

import android.util.Log;

import com.blogspot.droidcrib.getflat.model.card.Card;
import com.blogspot.droidcrib.getflat.model.card.HouseFeature;
import com.blogspot.droidcrib.getflat.model.card.Message;
import com.blogspot.droidcrib.getflat.model.card.RealtyFeature;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by BulanovA on 02.08.2017.
 */

public class JsonDecoder {
    public static final String TAG = "JsonDecoder";

    private JsonDecoder() {
        super();
    }

    public static List<Card> getCardsFromJSON(String json) {
        Message message = GsonSingleton.getInstance().fromJson(json, Message.class);
        List<Card> categoriesList = message.getCards();


        //Save cards to database
        for (Card card : categoriesList) {
            Log.d(TAG, "getCardsFromJSON: " + card.toString());
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
        return categoriesList;
    }

    public static String getPureJSON(final String httpResponse) {

        Pattern p = Pattern.compile("(__APP_INITIAL_STATE__\\s+=\\s+)(.+)(;)");
        Matcher m = p.matcher(httpResponse);
        if (m.find()) {
            Log.d(TAG, "MATCH");
//                    Log.d(TAG, "getPureJSON: " + m.group(2));
//                    saveHtmlFile(m.group(2));
        } else {
            Log.d(TAG, "NO MATCH");
        }


        return m.group(2);
    }
}
