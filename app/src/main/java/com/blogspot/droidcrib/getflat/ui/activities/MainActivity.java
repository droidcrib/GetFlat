package com.blogspot.droidcrib.getflat.ui.activities;

//TODO: записываем в базу только те, для которых не существет такого pageid
//TODO: кэшируем фото во время его загрузки в ленте
//TODO: список "favorites"
//TODO: закладка "карта"

//TODO: при нажатии "детали" новое активити с двумя закладками детали и карта

//TODO: бесконечный скролинг
//TODO: загружать картинки во вьюшки
//TODO: проверка дубликатов при вставке
//TODO: зарегистрировать сетевой колбек в апликейшене
//TODO: дизайн ленты
//TODO: закладка "favorites"
//TODO: закладка карта - показывать выбранные по критериям
//TODO: при изменении критериев стираем все записи, кроме тех, что были отмечены как "favorites" и тех, для которых есть заметка
//TODO: новая таблица для заметок
//TODO: макет для landscape
//TODO: макеты для планшета
//TODO: макеты для маленьких экранов
//TODO: уведомление "вы вероятно сейчас смотрите ...."
//TODO: проверка новых объявлений через каждые ххх минут
//TODO: интеграция с вайбер: получение уедомлений о новых, отправка объявления контакту
//TODO: боковое меню
//TODO: Добавить города
//TODO: реклама как позиция в ленте
//TODO: цветовая схема
//TODO: клик на кнопке "перейти к объявлению" - открываем сайт объявления в вебвью

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import com.blogspot.droidcrib.getflat.ui.adapters.MainTabsPagerAdapter;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

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
    protected void onResume() {
        super.onResume();
        RestClient.getQueryParameters(this);
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
                Intent i = new Intent(MainActivity.this, SelectionActivity.class);
                startActivity(i);
//                Snackbar.make(view, "No connection", Snackbar.LENGTH_INDEFINITE)
//                        .setAction("Action", null).show();
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
//                        JsonDecoder.getCardsFromJSON(getJSONFromResponse(mResp));
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
