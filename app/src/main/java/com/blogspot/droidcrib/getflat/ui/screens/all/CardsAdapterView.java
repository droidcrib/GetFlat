package com.blogspot.droidcrib.getflat.ui.screens.all;

import com.blogspot.droidcrib.getflat.model.card.Card;

/**
 * Created by BulanovA on 10.10.2017.
 */

public interface CardsAdapterView {

    void markFavorite(Card card, CardsAdapter.CardViewHolder holder);

    void unmarkFavorite(Card card, CardsAdapter.CardViewHolder holder);

    void markNote(Card card, CardsAdapter.CardViewHolder holder);

    void unmarkNote(Card card, CardsAdapter.CardViewHolder holder);
}
