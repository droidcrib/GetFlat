package com.blogspot.droidcrib.getflat.loaders;

import android.content.Context;

import com.blogspot.droidcrib.getflat.model.card.Card;

import java.util.List;


public class FlatRecordsLoader extends DatabaseLoader {

    public FlatRecordsLoader(Context context) {
        super(context);
    }

    @Override
    public List<Card> loadList() {
        return Card.queryAllNotDeleted();
    }
}