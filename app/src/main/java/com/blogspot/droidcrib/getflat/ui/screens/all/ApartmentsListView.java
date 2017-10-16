package com.blogspot.droidcrib.getflat.ui.screens.all;

import com.blogspot.droidcrib.getflat.model.card.Card;

/**
 * Created by BulanovA on 27.09.2017.
 */

public interface ApartmentsListView {

    void showMemoDialog();

    void reloadData();

    void showProgress();

    void hideProgress();

    void showNoInternet();

    void hideNoInternet();

    void refreshAdapterDataSet(Card card);



}
