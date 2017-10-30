package com.blogspot.droidcrib.getflat.ui.activities;

// TODO: mark/unmark notes and favorites: setup icons
//TODO: при нажатии "детали" новое активити с двумя закладками детали(вебвью) и карта
//TODO: кэшируем фото во время его загрузки в ленте
//TODO: дизайн ленты
//TODO: боковое меню
//TODO: подсвечивать новые карточки в списке при обновлении с АПИ
//TODO: “LayoutManager is already attached to a RecyclerView” error
//TODO: screen rotation
//TODO: ProgressBar




//TODO: закладка "карта" со всеми точками. при клике на точку открываем детали ==>
//TODO: макет для landscape
//TODO: макеты для планшета
//TODO: макеты для маленьких экранов
//TODO: уведомление "вы вероятно сейчас смотрите ...."
//TODO: проверка новых объявлений через каждые ххх минут
//TODO: интеграция с вайбер: получение уедомлений о новых, отправка объявления контакту

//TODO: Добавить города
//TODO: реклама как позиция в ленте
//TODO: цветовая схема
//TODO: клик на кнопке "перейти к объявлению" - открываем сайт объявления в вебвью
//TODO: скайлайн как лого


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.androidnetworking.AndroidNetworking;
import com.blogspot.droidcrib.getflat.R;
import com.blogspot.droidcrib.getflat.networking.RestClient;
import com.blogspot.droidcrib.getflat.ui.screens.all.MainTabsPagerAdapter;
import com.blogspot.droidcrib.getflat.ui.screens.parameters.SelectionActivity;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "getflat_main_activity";
    private String mResp;

    private SharedPreferences mPrefs;
    private ViewPager mViewPager;
    private String mNoteText;
    private MainTabsPagerAdapter adapter;
    private long mAlarmRecordId;
    private FloatingActionButton mFab;
    private int mPagePosition;


    @Override
    protected void onResume() {
        super.onResume();
//        RestClient.getQueryParameters();
    }

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
        mTabLayout.addTab(mTabLayout.newTab().setText("Favourites"));
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
                Intent i = new Intent(MainActivity.this, SelectionActivity.class);
                startActivity(i);
//                Snackbar.make(view, "No connection", Snackbar.LENGTH_INDEFINITE)
//                        .setAction("Action", null).show();
            }
        });
    }
}
