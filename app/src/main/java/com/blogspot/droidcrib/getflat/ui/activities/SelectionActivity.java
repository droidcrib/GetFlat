package com.blogspot.droidcrib.getflat.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;

import com.blogspot.droidcrib.getflat.R;

/**
 * Created by BulanovA on 07.08.2017.
 */

public class SelectionActivity extends AppCompatActivity {

    private Spinner mSpinnerCity;
    private Spinner mSpinnerDistrict;
    private Spinner mSpinnerRooms;
    private Spinner mSpinnerArea;
    private Spinner mSpinnerPrice;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        mSpinnerCity = (Spinner) findViewById(R.id.spinner_city);
        mSpinnerDistrict = (Spinner) findViewById(R.id.spinner_district);
        mSpinnerRooms = (Spinner) findViewById(R.id.spinner_rooms);
        mSpinnerArea = (Spinner) findViewById(R.id.spinner_area);
        mSpinnerPrice = (Spinner) findViewById(R.id.spinner_price);
    }
}
