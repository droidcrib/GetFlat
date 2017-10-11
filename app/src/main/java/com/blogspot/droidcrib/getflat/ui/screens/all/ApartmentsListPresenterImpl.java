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
    public void onDestroy() {

    }
}
