package com.blogspot.droidcrib.getflat.ui.screens.all;

import com.blogspot.droidcrib.getflat.model.card.Card;

/**
 * Created by BulanovA on 10.10.2017.
 */

public interface CardsAdapterPresenter {

    void setFavorite(Card card, CardsAdapter.CardViewHolder holder);

    void clearFavorite();

    void setNote();

    void deleteCard();

    void showDetails();

    void complainAd();
}
