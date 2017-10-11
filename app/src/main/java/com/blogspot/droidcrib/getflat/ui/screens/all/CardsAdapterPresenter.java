package com.blogspot.droidcrib.getflat.ui.screens.all;

import android.content.Context;

import com.blogspot.droidcrib.getflat.model.card.Card;

/**
 * Created by BulanovA on 10.10.2017.
 */

public interface CardsAdapterPresenter {

    void manageFavorite(Card card, CardsAdapter.CardViewHolder holder);

    void setNote(Context context, Card card);

    void deleteCard(Card card);

    void showDetails();

    void complainAd();
}
