package com.blogspot.droidcrib.getflat.ui.screens.all;

import com.blogspot.droidcrib.getflat.model.card.Card;

/**
 * Created by BulanovA on 10.10.2017.
 */

public interface ApartmentsListPresenter {

    void refreshList();

    void onCardDeleted(Card card);

    void onDestroy();
}
