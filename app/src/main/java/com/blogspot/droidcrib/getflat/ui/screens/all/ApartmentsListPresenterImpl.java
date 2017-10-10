package com.blogspot.droidcrib.getflat.ui.screens.all;

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
        view.refreshList();
    }

    @Override
    public void addFavorite() {

    }

    @Override
    public void addNote() {

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

    @Override
    public void onDestroy() {

    }
}
