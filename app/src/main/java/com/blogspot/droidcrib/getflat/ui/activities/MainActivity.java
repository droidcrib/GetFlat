package com.blogspot.droidcrib.getflat.ui.activities;

//TODO: mark/unmark notes and favorites: setup icons
//TODO: при нажатии "детали" новое активити с двумя закладками детали(вебвью) и карта
//TODO: кэшируем фото во время его загрузки в ленте
//TODO: дизайн ленты
//TODO: боковое меню
//TODO: подсвечивать новые карточки в списке при обновлении с АПИ
//TODO: “LayoutManager is already attached to a RecyclerView” error
//TODO: screen rotation
//TODO: change refreshAdapterDataSet
//TODO: при добавлении в конец списка сдвигать скролл немного вниз
//TODO: при добавлении в начало списка сдвигаем скролл в самый верх + тост "New cards available"


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


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.blogspot.droidcrib.getflat.R;
import com.blogspot.droidcrib.getflat.model.card.Card;
import com.blogspot.droidcrib.getflat.model.parameters.ParamsMap;
import com.blogspot.droidcrib.getflat.networking.RestClient;
import com.blogspot.droidcrib.getflat.ui.screens.all.MainTabsPagerAdapter;
import com.blogspot.droidcrib.getflat.ui.screens.parameters.SelectionActivity;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_PATH;
import static com.blogspot.droidcrib.getflat.contract.Constants.PATH_RENT_KYIV;
import static com.blogspot.droidcrib.getflat.contract.Constants.PATH_SALE_KYIV;
import static com.blogspot.droidcrib.getflat.contract.Constants.SHARED_PREFS;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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

        mPrefs = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
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
//                    mFab.setVisibility(View.INVISIBLE);
                }
                if (position == 1) {
//                    mFab.setVisibility(View.VISIBLE);
//                    mFab.setImageResource(R.drawable.ic_alarm_add_white_24dp);
                }
                if (position == 2) {
//                    mFab.setVisibility(View.VISIBLE);
//                    mFab.setImageResource(R.drawable.ic_note_add_white_24dp);
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


        // Navigation Drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


//        mFab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(MainActivity.this, SelectionActivity.class);
//                startActivity(i);
////                Snackbar.make(view, "No connection", Snackbar.LENGTH_INDEFINITE)
////                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Log.d(TAG, "onNavigationItemSelected: pressed");
//
//        if (id == R.id.nav_rent_flat) {
//            ParamsMap.updateParameter(PARAM_PATH, PATH_RENT_KYIV);
//            Card.deleteAllNotFavorites();
//            RestClient.newGetRequest(ParamsMap.getValue(PARAM_PATH),RestClient.getQueryParameters(),1);
//
//        } else if (id == R.id.nav_sale_flat) {
//            ParamsMap.updateParameter(PARAM_PATH, PATH_SALE_KYIV);
//            Card.deleteAllNotFavorites();
//            RestClient.newGetRequest(ParamsMap.getValue(PARAM_PATH),RestClient.getQueryParameters(),1);
//        } else
//
            if (id == R.id.nav_parameters) {
            Intent i = new Intent(MainActivity.this, SelectionActivity.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
