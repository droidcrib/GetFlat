package com.blogspot.droidcrib.getflat.ui.screens.favorites;


import android.content.Context;

import com.blogspot.droidcrib.getflat.R;
import com.blogspot.droidcrib.getflat.model.card.Card;
import com.blogspot.droidcrib.getflat.model.userdata.Deleted;
import com.blogspot.droidcrib.getflat.ui.screens.all.CardsAdapter;
import com.blogspot.droidcrib.getflat.ui.screens.all.CardsAdapterPresenter;
import com.blogspot.droidcrib.getflat.ui.screens.all.CardsAdapterView;
import com.blogspot.droidcrib.getflat.utils.MemoUtils;

/**
 * Created by BulanovA on 10.10.2017.
 */

public class FavoritesAdapterPresenterImpl implements FavoritesAdapterPresenter {

    private FavoritesListView view;
    private Context context;

    public FavoritesAdapterPresenterImpl(FavoritesListView view) {
        this.view = view;
    }

    @Override
    public void manageFavorite() {

    }


    @Override
    public void setNote() {
    }

    @Override
    public void deleteCard() {

    }

    @Override
    public void showDetails() {

    }

    @Override
    public void complainAd() {

    }
}
