package com.blogspot.droidcrib.getflat.ui.screens.all;


import android.content.Context;

import com.blogspot.droidcrib.getflat.model.card.Card;
import com.blogspot.droidcrib.getflat.model.userdata.Deleted;
import com.blogspot.droidcrib.getflat.utils.MemoUtils;

/**
 * Created by BulanovA on 10.10.2017.
 */

public class CardsAdapterPresenterImpl implements CardsAdapterPresenter {

    private CardsAdapterView view;

    public CardsAdapterPresenterImpl(CardsAdapterView view) {
        this.view = view;
    }

    @Override
    public void manageFavorite(Card card, CardsAdapter.CardViewHolder holder) {
        if (card.isFavourite != null && card.isFavourite) {
            Card.setFavourite(card.getId(), false);
            view.unmarkFavorite(card, holder);
        } else {
            Card.setFavourite(card.getId(), true);
            view.markFavorite(card, holder);
        }
    }


    @Override
    public void setNote(Context context, Card card) {
        MemoUtils.buildDialogMessageNewNote(context, card);
    }

    @Override
    public void deleteCard(Card card) {
        Card.setDeleted(card.pageId, true);
        Deleted.insert(card);
    }

    @Override
    public void showDetails() {

    }

    @Override
    public void complainAd() {

    }
}
