package com.blogspot.droidcrib.getflat.ui.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.blogspot.droidcrib.getflat.R;
import com.blogspot.droidcrib.getflat.networking.JsonDecoder;
import com.blogspot.droidcrib.getflat.ui.adapters.MainTabsPagerAdapter;
import com.blogspot.droidcrib.getflat.ui.fragments.ApartmentsListFragment;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

import static com.blogspot.droidcrib.getflat.utils.Parser.getPureJSON;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RestTest";
    private String mResp;

    private SharedPreferences mPrefs;
    private ViewPager mViewPager;
    private String mNoteText;
    private MainTabsPagerAdapter adapter;
    private long mAlarmRecordId;
    private FloatingActionButton mFab;
    private int mPagePosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Adding an Network Interceptor for Debugging purpose
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        AndroidNetworking.initialize(getApplicationContext(), okHttpClient);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        mPrefs = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        mFab = (FloatingActionButton) findViewById(R.id.fab_main);

        //  Setup TabLayout
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.addTab(mTabLayout.newTab().setText("All"));
        //mTabLayout.addTab(mTabLayout.newTab().setText("Favourites"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //  Setup ViewPager
        mViewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new MainTabsPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout) {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mPagePosition = position;
                if (position == 0) {
                    mFab.setVisibility(View.INVISIBLE);
                }
                if (position == 1) {
                    mFab.setVisibility(View.VISIBLE);
                    mFab.setImageResource(R.drawable.ic_alarm_add_white_24dp);
                }
                if (position == 2) {
                    mFab.setVisibility(View.VISIBLE);
                    mFab.setImageResource(R.drawable.ic_note_add_white_24dp);
                }
            }
        });

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Button Pressed");
               ApartmentsListFragment.getInstance().request();

            }
        });
    }


    //district=1&roomCount=1&areaTotalMin=25&priceMax=4000&currency=2

//    private void request() {
//        AndroidNetworking.get("https://www.lun.ua/{addr}")
//                .addPathParameter("addr", "аренда-квартир-киев")
//                .addQueryParameter("district", "1")
//                .addQueryParameter("roomCount", "1")
//                .addQueryParameter("areaTotalMin", "25")
//                //.addQueryParameter("priceMax", "4000")
//                .addQueryParameter("currency", "2")
//                .build()
//                .getAsString(new StringRequestListener() {
//                    @Override
//                    public void onResponse(String response) {
//                        mResp = response;
//                        JsonDecoder.getCardsJSON(getPureJSON(mResp));
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//                        Log.d(TAG, "onError: " + anError.toString());
//                    }
//                })
//        ;
//    }
}
