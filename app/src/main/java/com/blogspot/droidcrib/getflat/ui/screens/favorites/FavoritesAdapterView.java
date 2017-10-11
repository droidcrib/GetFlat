package com.blogspot.droidcrib.getflat.ui.screens.favorites;

import com.blogspot.droidcrib.getflat.model.card.Card;
import com.blogspot.droidcrib.getflat.ui.screens.all.CardsAdapter;

/**
 * Created by BulanovA on 10.10.2017.
 */

public interface FavoritesAdapterView {

    void markFavorite(Card card, CardsAdapter.CardViewHolder holder);

    void markNote(Card card, CardsAdapter.CardViewHolder holder);
}
