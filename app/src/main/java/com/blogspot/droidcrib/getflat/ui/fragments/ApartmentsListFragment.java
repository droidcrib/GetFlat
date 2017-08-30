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
import com.blogspot.droidcrib.getflat.evenbus.DatabaseUpdatedEvent;
import com.blogspot.droidcrib.getflat.evenbus.NewNetworkRequestEvent;
import com.blogspot.droidcrib.getflat.evenbus.NewNetworkResponseEvent;
import com.blogspot.droidcrib.getflat.evenbus.NoInternetEvent;
import com.blogspot.droidcrib.getflat.loaders.FlatRecordsLoader;
import com.blogspot.droidcrib.getflat.model.card.Card;
import com.blogspot.droidcrib.getflat.model.card.Geo;
import com.blogspot.droidcrib.getflat.networking.JsonDecoder;
import com.blogspot.droidcrib.getflat.networking.RestClient;
import com.blogspot.droidcrib.getflat.ui.adapters.CardsAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import static com.blogspot.droidcrib.getflat.networking.JsonDecoder.getJSONFromResponse;


/**
 * Created by BulanovA on 21.06.2017.
 */

public class ApartmentsListFragment extends Fragment implements LoaderManager.LoaderCallbacks {

    public static ApartmentsListFragment sApartmentsListFragment;
    private List<Card> mCardsList;
    private RecyclerView mRecyclerView;
    private CardsAdapter mAdapter;
    private long mRecordId;
    private Parcelable state;
    private TextView mEmptyView;

    private static final String TAG = "AppThis";
    private String mResp;

    //
    // Provides instance of ApartmentsListFragment
    //
    public static ApartmentsListFragment getInstance() {

        Log.d(TAG, "getInstance: ");

        if (sApartmentsListFragment == null) {
            sApartmentsListFragment = new ApartmentsListFragment();
        }
        return sApartmentsListFragment;
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

        View v = inflater.inflate(R.layout.fragment_list_apartments, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_all_apartments);


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume -- start network request ");
        RestClient.newGetRequest("аренда-квартир-киев", RestClient.getQueryParameters(getActivity()), getActivity());

//        // List items long click processing
//        stickyList.setOnCreateContextMenuListener(this);
//        getLoaderManager().restartLoader(0, null, this);
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
        return new FlatRecordsLoader(getActivity());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onLoadFinished(Loader loader, Object data) {

        mCardsList = (List<Card>) data;
        Log.d(TAG, "onLoadFinished: mCardsList = " + mCardsList.size());
        mAdapter = new CardsAdapter(mCardsList);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
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
    public void onEvent(NewNetworkResponseEvent event) {
        // TODO: move this to onLoadFinished
        Log.i(TAG, "FRAGMENT onResponse: " + event.getResponse().length());
//        mCardsList = JsonDecoder.getCardsFromJSON(getJSONFromResponse(event.getResponse()));
//        mAdapter = new CardsAdapter(mCardsList);
//        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.setAdapter(mAdapter);
    }

    @Subscribe
    public void onEventMainThread(DatabaseUpdatedEvent event) {
        //TODO: restart loader when database updated
        Log.d(TAG, "onEvent: FRAGMENT database updater event");
        getLoaderManager().restartLoader(0, null, this);

    }

    @Subscribe
    public void onEvent(NoInternetEvent event) {
        Snackbar.make(new View(getActivity()), "No connection", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }
}

