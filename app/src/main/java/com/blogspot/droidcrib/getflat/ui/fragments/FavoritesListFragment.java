package com.blogspot.droidcrib.getflat.ui.fragments;

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
import com.blogspot.droidcrib.getflat.evenbus.CardRemovedEvent;
import com.blogspot.droidcrib.getflat.evenbus.FavoriteAddedEvent;
import com.blogspot.droidcrib.getflat.evenbus.FavoriteRemovedEvent;
import com.blogspot.droidcrib.getflat.evenbus.NoInternetEvent;
import com.blogspot.droidcrib.getflat.loaders.FavoriteRecordsLoader;
import com.blogspot.droidcrib.getflat.model.card.Card;
import com.blogspot.droidcrib.getflat.ui.adapters.FavoritesAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;


/**
 * Created by BulanovA on 21.06.2017.
 */

public class FavoritesListFragment extends Fragment implements LoaderManager.LoaderCallbacks {

    public static FavoritesListFragment sFavoritesListFragment;
    private List<Card> mCardsList;
    private RecyclerView mRecyclerView;
    private FavoritesAdapter mAdapter;
    private long mRecordId;
    private Parcelable state;
    private TextView mEmptyView;
    //    int positionIndex;
//    int topView;
//    LinearLayoutManager llManager = new LinearLayoutManager(getActivity());
    int currentVisiblePosition = 0;

    private static final String TAG = "FavoritesListFragment";
    private String mResp;

    //
    // Provides instance of ApartmentsListFragment
    //
    public static FavoritesListFragment getInstance() {

        Log.d(TAG, "getInstance: ");

        if (sFavoritesListFragment == null) {
            sFavoritesListFragment = new FavoritesListFragment();
        }
        return sFavoritesListFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");

        View v = inflater.inflate(R.layout.fragment_list_favorite_apartments, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_favorite_apartments);


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume -- start network request ");

//        // List items long click processing
//        stickyList.setOnCreateContextMenuListener(this);
        getLoaderManager().restartLoader(0, null, this);
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

        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    public void scrollToListItem(long id) {
//        for (int i = 0; i < stickyList.getCount(); i++) {
//            if (stickyList.getItemIdAtPosition(i) == id) {
//                stickyList.setSelection(i);
//                return;
//            }
//        }
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
        return new FavoriteRecordsLoader(getActivity());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onLoadFinished(Loader loader, Object data) {

        mCardsList = (List<Card>) data;
        Log.d(TAG, "onLoadFinished: mCardsList = " + mCardsList.size());
        mAdapter = new FavoritesAdapter(mCardsList);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.scrollToPosition(currentVisiblePosition);
        currentVisiblePosition = 0;

    }


//        mCardsList = (List<AlarmRecord>) data;
//        AlarmsListAdapter adapter = new AlarmsListAdapter(getActivity(), mCardsList);
//        stickyList.setAdapter(adapter);
//        stickyList.setEmptyView(mEmptyView);
    // Restore previous state (including selected item index and scroll position)
//        if (state != null) {
//            stickyList.onRestoreInstanceState(state);
//        }

//        EventBus.getDefault().post(new AlarmsListLoadFinishedEvent());


    @Override
    public void onLoaderReset(Loader loader) {
//        stickyList.setAdapter(null);
        mRecyclerView.setAdapter(null);
    }


//    /**
//     * Removes record from database and correspondent data directory from storage
//     */
//    private class RemoveRecordTask extends AsyncTask<Long, Void, Void> {
//
//        protected Void doInBackground(Long... args) {
//            AlarmRecord.deleteRecordById(args[0]);
//            return null;
//        }
//
//        protected void onPostExecute(Void result) {
//            getLoaderManager().restartLoader(0, null, ApartmentsListFragment.this);
//        }
//    }


    @Subscribe
    public void onEvent(NoInternetEvent event) {
        Snackbar.make(new View(getActivity()), "No connection", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }

    @Subscribe
    public void onEvent(FavoriteAddedEvent event) {
        getLoaderManager().restartLoader(0, null, this);
    }

    @Subscribe
    public void onEvent(FavoriteRemovedEvent event) {
        currentVisiblePosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        Log.d(TAG, "onPause: currentVisiblePosition = " + currentVisiblePosition);
        getLoaderManager().restartLoader(0, null, this);
    }

    @Subscribe
    public void onEvent(CardRemovedEvent event) {
        currentVisiblePosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        for (Card c : mCardsList) {
            if (c.pageId == event.getPageId()) {
                mCardsList.remove(c);
                mAdapter.notifyDataSetChanged();
            }
        }
    }
}

