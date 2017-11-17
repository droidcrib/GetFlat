package com.blogspot.droidcrib.getflat.ui.activities;

//TODO: mark/unmark notes and favorites: setup icons
//TODO: дизайн ленты
//TODO: подсвечивать новые карточки в списке при обновлении с АПИ
//TODO: “LayoutManager is already attached to a RecyclerView” error
//TODO: указывать в табе "Favorites" количество добавленных (циферка в красном кружочке)

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
//TODO: при нажатии "детали" новое активити с двумя закладками детали(вебвью) и карта
//TODO: screen rotation
//TODO: change refreshAdapterDataSet


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.blogspot.droidcrib.getflat.R;
import com.blogspot.droidcrib.getflat.ui.screens.all.MainTabsPagerAdapter;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

import static com.blogspot.droidcrib.getflat.contract.Constants.SHARED_PREFS;

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
    private TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adding an Network Interceptor for Debugging purpose
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        AndroidNetworking.initialize(getApplicationContext(), okHttpClient);

        mPrefs = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
//        mFab = (FloatingActionButton) findViewById(R.id.fab_main);

        //  Setup TabLayout
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.addTab(mTabLayout.newTab().setText("Settings"));
        mTabLayout.addTab(mTabLayout.newTab().setText("All"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Favorites"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        // Customize tabs
        setTabsParameters();

        //  Setup ViewPager
        mViewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new MainTabsPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(1);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout) {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mPagePosition = position;
                if (position == 0) {
                }
                if (position == 1) {
                }
                if (position == 2) {
                }
            }
        });


        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());

                TextView text = (TextView) tab.getCustomView();
                text.setTypeface(null, Typeface.BOLD);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                TextView text = (TextView) tab.getCustomView();
                text.setTypeface(null, Typeface.NORMAL);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }


    private void setTabsParameters() {
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {

            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            if (tab != null) {

                TextView tabTextView = new TextView(this);
                tabTextView.setAllCaps(true);
                tabTextView.setTextSize(14f);
                int textColor = getResources().getColor(R.color.icons);
                tabTextView.setTextColor(textColor);
                tab.setCustomView(tabTextView);

                tabTextView.getLayoutParams().width = ViewGroup.LayoutParams.WRAP_CONTENT;
                tabTextView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;

                tabTextView.setText(tab.getText());

                // First tab is the selected tab, so if i==0 then set BOLD typeface
                if (i == 0) {
                    tabTextView.setTypeface(null, Typeface.BOLD);
                }

            }

        }
    }

}
