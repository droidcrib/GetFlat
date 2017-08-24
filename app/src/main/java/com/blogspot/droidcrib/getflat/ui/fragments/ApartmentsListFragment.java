package com.blogspot.droidcrib.getflat.ui.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.util.ArrayMap;
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

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.blogspot.droidcrib.getflat.R;
import com.blogspot.droidcrib.getflat.model.card.Card;
import com.blogspot.droidcrib.getflat.networking.JsonDecoder;
import com.blogspot.droidcrib.getflat.networking.RestClient;
import com.blogspot.droidcrib.getflat.ui.adapters.CardsAdapter;

import java.util.List;

import static com.blogspot.droidcrib.getflat.utils.Parser.getPureJSON;


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

    private static final String TAG = "ApartmentsListFragment";
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
//        EventBus.getDefault().register(this);
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
        Log.d(TAG, "onResume: ");

        request();


//
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
//        EventBus.getDefault().unregister(this);
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


    @Override
    public Loader onCreateLoader(int id, Bundle args) {
//        return new AlarmRecordsLoader(getActivity());
        return new Loader(getActivity());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onLoadFinished(Loader loader, Object data) {
//        mCardsList = (List<AlarmRecord>) data;
//        AlarmsListAdapter adapter = new AlarmsListAdapter(getActivity(), mCardsList);
//        stickyList.setAdapter(adapter);
//        stickyList.setEmptyView(mEmptyView);
        // Restore previous state (including selected item index and scroll position)
        if (state != null) {
//            stickyList.onRestoreInstanceState(state);
        }

//        EventBus.getDefault().post(new AlarmsListLoadFinishedEvent());

    }

    @Override
    public void onLoaderReset(Loader loader) {
//        stickyList.setAdapter(null);
    }

//    @Subscribe
//    public void onEvent(NewCallEvent event) {
//        getLoaderManager().restartLoader(0, null, this);
//    }

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


    public void request() {
        ArrayMap<String, String> params = RestClient.getQueryParameters(getActivity());

        AndroidNetworking.get("https://www.lun.ua/{addr}")
                .addPathParameter("addr", "аренда-квартир-киев")
                .addQueryParameter(params)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        mResp = response;
                        mCardsList = JsonDecoder.getCardsJSON(getPureJSON(mResp));
                        mAdapter = new CardsAdapter(mCardsList);
                        Log.d(TAG, "onResponse: adapter " + mAdapter);

                        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                        mRecyclerView.setLayoutManager(mLayoutManager);
                        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                        mRecyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(TAG, "onError: " + anError.toString());
                    }
                })
        ;
    }
}
