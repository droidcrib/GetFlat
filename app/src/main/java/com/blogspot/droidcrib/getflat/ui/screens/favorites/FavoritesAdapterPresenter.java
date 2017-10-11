package com.blogspot.droidcrib.getflat.ui.screens.favorites;

import android.content.Context;

import com.blogspot.droidcrib.getflat.model.card.Card;
import com.blogspot.droidcrib.getflat.ui.screens.all.CardsAdapter;

/**
 * Created by BulanovA on 10.10.2017.
 */

public interface FavoritesAdapterPresenter {

    void manageFavorite();

    void setNote();

    void deleteCard();

    void showDetails();

    void complainAd();
}
