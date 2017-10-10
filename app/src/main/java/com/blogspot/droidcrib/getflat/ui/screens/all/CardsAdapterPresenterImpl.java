package com.blogspot.droidcrib.getflat.ui.screens.all;


import com.blogspot.droidcrib.getflat.R;
import com.blogspot.droidcrib.getflat.model.card.Card;

/**
 * Created by BulanovA on 10.10.2017.
 */

public class CardsAdapterPresenterImpl implements CardsAdapterPresenter {

    private CardsAdapterView view;



    @Override
    public void setFavorite(Card card, CardsAdapter.CardViewHolder holder) {
        if (card.isFavourite != null && card.isFavourite) {
            Card.setFavourite(card.getId(), false);
            holder.favorites.setImageResource(R.drawable.ic_favorite_border_black_48dp);
        } else {
            Card.setFavourite(card.getId(), true);
            holder.favorites.setImageResource(R.drawable.ic_favorite_black_48dp);
        }
    }

    @Override
    public void clearFavorite() {

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
