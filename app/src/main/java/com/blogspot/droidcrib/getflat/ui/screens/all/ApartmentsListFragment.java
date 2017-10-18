package com.blogspot.droidcrib.getflat.ui.screens.all;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.blogspot.droidcrib.getflat.R;
import com.blogspot.droidcrib.getflat.evenbus.DatabaseUpdatedEvent;
import com.blogspot.droidcrib.getflat.evenbus.FavoriteRemovedEvent;
import com.blogspot.droidcrib.getflat.evenbus.NoInternetEvent;
import com.blogspot.droidcrib.getflat.loaders.FlatRecordsLoader;
import com.blogspot.droidcrib.getflat.model.card.Card;
import com.blogspot.droidcrib.getflat.networking.RestClient;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static com.blogspot.droidcrib.getflat.application.App.isQueried;


/**
 * Created by BulanovA on 21.06.2017.
 */

public class ApartmentsListFragment extends Fragment implements ApartmentsListView, LoaderManager.LoaderCallbacks {


    private int nextPage = 1;
    public static ApartmentsListFragment sApartmentsListFragment;
    private List<Card> mCardsList;
    private RecyclerView mRecyclerView;
    private CardsAdapter mAdapter;
    private long mRecordId;
    private Parcelable state;
    private TextView mEmptyView;
    int currentVisiblePosition = 0;
    private ApartmentsListPresenter presenter;
    private Snackbar mSnackbar;
    // Store a member variable for the listener
    private EndlessRecyclerViewScrollListener scrollListener;
    LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

    private static final String TAG = "ApartmentsListFragment";
    private String mResp;

    //
    // Provides instance of ApartmentsListFragment
    //
    public static ApartmentsListFragment getInstance() {

        Log.d(TAG, "ApartmentsListFragment -- getInstance: ");

        if (sApartmentsListFragment == null) {
            sApartmentsListFragment = new ApartmentsListFragment();
        }
        return sApartmentsListFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ApartmentsListPresenterImpl(this);

        Log.d(TAG, "ApartmentsListFragment -- onCreate: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "ApartmentsListFragment -- onStart: ");
        EventBus.getDefault().register(this);
        mCardsList = new ArrayList<Card>();
        Log.d(TAG, "ApartmentsListFragment -- onCreateView: mCardsList = " + mCardsList.size());
        mAdapter = new CardsAdapter(mCardsList, getActivity(), presenter);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Retain an instance so that you can call `resetState()` for fresh searches
        scrollListener = new EndlessRecyclerViewScrollListener(mLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to the bottom of the list
                loadNextDataFromApi(page);
                Log.d(TAG, "onLoadMore: called" + page + " " + totalItemsCount + " " + view);

            }
        };
        // Adds the scroll listener to RecyclerView
        mRecyclerView.addOnScrollListener(scrollListener);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "ApartmentsListFragment -- onCreateView: ");

        View v = inflater.inflate(R.layout.fragment_list_apartments, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_all_apartments);



        return v;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "ApartmentsListFragment -- onConfigurationChanged: ");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        isQueried = false;
        Log.d(TAG, "ApartmentsListFragment -- onDestroy: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "ApartmentsListFragment -- onResume ");
        // Load data from database on application start
        getLoaderManager().restartLoader(0, null, this);


//        // List items long click processing
//        stickyList.setOnCreateContextMenuListener(this);

//
//        // List items click processing
//        stickyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                AlarmsListAdapter.ViewHolder holder = (AlarmsListAdapter.ViewHolder) (view.getTag());
//                holder.memoShort.setVisibility(holder.memoShort.isShown() ? View.GONE : View.VISIBLE);
//                holder.memo.setVisibility(holder.memo.isShown() ? View.GONE : View.VISIBLE);
//            }
//        });
    }

    @Override
    public void onPause() {
        // Save ListView state @ onPause
//        state = stickyList.onSaveInstanceState();
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    //////////////////////////////////////////////////////////////////////////////////////////////
    // Context menu
    //////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.item_list_menu_context_alarms, menu);
        // Get long-pressed item id
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        mRecordId = info.id;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.context_menu_item_delete_card:

                return true;
            case R.id.context_menu_item_edit_card:

                return true;
        }
        return super.onContextItemSelected(item);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    // Loaders
    //////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new FlatRecordsLoader(getActivity());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onLoadFinished(Loader loader, Object data) {
        Log.d(TAG, "onLoadFinished: ");

        int curSize = mAdapter.getItemCount();
        List<Card> newCardsList = (ArrayList<Card>) data;
        mCardsList.addAll(newCardsList);
        mAdapter.notifyItemRangeInserted(curSize, newCardsList.size());

        // Restore scrolling position
        mRecyclerView.scrollToPosition(currentVisiblePosition);
        currentVisiblePosition = 0;

        if (!isQueried) {
            currentVisiblePosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
            RestClient.newGetRequest("аренда-квартир-киев", RestClient.getQueryParameters());
            isQueried = true;
        }
    }

    @Override
    public void onLoaderReset(Loader loader) {
//        stickyList.setAdapter(null);
        mRecyclerView.setAdapter(null);
    }


    //////////////////////////////////////////////////////////////////////////////////////////////
    // EventBus
    //////////////////////////////////////////////////////////////////////////////////////////////



    @Subscribe
    public void onEventMainThread(DatabaseUpdatedEvent event) {
        //TODO: restart loader when database updated
        Log.d(TAG, "ApartmentsListFragment -- onEvent: FRAGMENT database updater event");
        // Save scrolling position
        this.reloadData();

    }

    @Subscribe
    public void onEvent(NoInternetEvent event) {
        Snackbar.make(new View(getActivity()), "No connection", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }

    @Subscribe
    public void onEvent(FavoriteRemovedEvent event) {
        Log.d(TAG, "ApartmentsListFragment -- onEvent: FavoriteAddedEvent happens");
        currentVisiblePosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        getLoaderManager().restartLoader(0, null, this);
    }



    //////////////////////////////////////////////////////////////////////////////////////////////
    // Callbacks ApartmentsListView
    //////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void showMemoDialog() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showNoInternet() {
        mSnackbar = Snackbar.make(new View(getActivity()), "No connection", Snackbar.LENGTH_INDEFINITE)
                .setAction("Action", null);
        mSnackbar.show();
    }

    @Override
    public void hideNoInternet() {
        mSnackbar.dismiss();
    }

    @Override
    public void reloadData() {
        getLoaderManager().restartLoader(0, null, this);
    }

    @Override
    public void refreshAdapterDataSet(Card card) {
        currentVisiblePosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        Iterator it = mCardsList.iterator();
        while (it.hasNext()) {
            Card c = (Card) it.next();
            if (c.pageId == card.pageId) {
                it.remove();
                mAdapter.notifyDataSetChanged();
            }
        }
    }



    private void loadNextDataFromApi(int page) {
        // TODO: start new api request from here
        Log.d(TAG, "================ ::::::: ================ loadNextDataFromApi: CALLED !!!!");
//        mAdapter.notifyItemRangeInserted(30, 30);
    }
}

