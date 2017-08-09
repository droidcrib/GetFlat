package com.blogspot.droidcrib.getflat.networking;

import android.util.Log;

import com.blogspot.droidcrib.getflat.model.card.Card;
import com.blogspot.droidcrib.getflat.model.card.HouseFeature;
import com.blogspot.droidcrib.getflat.model.card.Message;
import com.blogspot.droidcrib.getflat.model.card.RealtyFeature;

import java.util.List;

/**
 * Created by BulanovA on 02.08.2017.
 */

public class JsonDecoder {
    public static final String TAG = "JsonDecoder";

    private JsonDecoder() {
        super();
    }

    public static List<Card> getCardsJSON(String json) {
        Message message = GsonSingleton.getInstance().fromJson(json, Message.class);
        List<Card> categoriesList = message.getCards();


        // Save cards to database
        for (Card card : categoriesList) {
            Log.d(TAG, "getCardsJSON: " + card.toString());
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
}
