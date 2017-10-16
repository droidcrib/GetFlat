package com.blogspot.droidcrib.getflat.ui.screens.all;

import com.blogspot.droidcrib.getflat.model.card.Card;

/**
 * Created by BulanovA on 10.10.2017.
 */

public class ApartmentsListPresenterImpl implements ApartmentsListPresenter {

    private ApartmentsListView view;

    public ApartmentsListPresenterImpl(ApartmentsListView view) {
        this.view = view;
    }

    @Override
    public void refreshList() {
        view.reloadData();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onCardDeleted(Card card) {
        view.refreshAdapterDataSet(card);
    }
}
