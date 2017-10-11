package com.blogspot.droidcrib.getflat.ui.screens.favorites;

import com.blogspot.droidcrib.getflat.ui.screens.all.ApartmentsListPresenter;
import com.blogspot.droidcrib.getflat.ui.screens.all.ApartmentsListView;

/**
 * Created by BulanovA on 10.10.2017.
 */

public class FavoritesListPresenterImpl implements FavoritesListPresenter {

    private FavoritesListView view;

    public FavoritesListPresenterImpl(FavoritesListView view) {
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
