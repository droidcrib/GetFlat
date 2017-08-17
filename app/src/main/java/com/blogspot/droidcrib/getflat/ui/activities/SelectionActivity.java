package com.blogspot.droidcrib.getflat.ui.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.blogspot.droidcrib.getflat.R;
import com.blogspot.droidcrib.getflat.model.parameters.AreaParam;
import com.blogspot.droidcrib.getflat.model.parameters.CityParam;
import com.blogspot.droidcrib.getflat.model.parameters.DistrictParam;
import com.blogspot.droidcrib.getflat.model.parameters.PriceParam;
import com.blogspot.droidcrib.getflat.model.parameters.RoomsParam;

import java.util.List;

import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_CHECKBOX_BUILDING;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_CHECKBOX_NO_BROKERS;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_CHECKBOX_NO_FEE;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_CHECKBOX_SUBWAY;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_CHECKBOX_WITH_PHOTO;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_RADIO_DISTRICT;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_RADIO_METRO;
import static com.blogspot.droidcrib.getflat.contract.Constants.SHARED_PREFS;

/**
 * Created by BulanovA on 07.08.2017.
 */

public class SelectionActivity extends AppCompatActivity {

    private static final String TAG = "SelectionActivity";

    private RadioButton mRadioButtonDistrict;
    private RadioButton mRadioButtonMetro;
    private CheckBox mCheckBoxNewBuilding;
    private CheckBox mCheckBoxNearSubway;
    private CheckBox mCheckBoxWithPhoto;
    private CheckBox mCheckBoxNoFee;
    private CheckBox mCheckBoxNoBrokers;
    private SharedPreferences mPrefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        mPrefs = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        Spinner spinnerCity = (Spinner) findViewById(R.id.spinner_city);
        Spinner spinnerDistrict = (Spinner) findViewById(R.id.spinner_district);
        Spinner spinnerRooms = (Spinner) findViewById(R.id.spinner_rooms);
        Spinner spinnerArea = (Spinner) findViewById(R.id.spinner_area);
        Spinner spinnerPrice = (Spinner) findViewById(R.id.spinner_price);
        mRadioButtonDistrict = (RadioButton) findViewById(R.id.radiobutton_district);
        mRadioButtonMetro = (RadioButton) findViewById(R.id.radiobutton_metro);
        mCheckBoxNewBuilding = (CheckBox) findViewById(R.id.checkbox_new_building);
        mCheckBoxNearSubway = (CheckBox) findViewById(R.id.checkbox_near_subway);
        mCheckBoxWithPhoto = (CheckBox) findViewById(R.id.checkbox_with_photo);
        mCheckBoxNoFee = (CheckBox) findViewById(R.id.checkbox_no_fee);
        mCheckBoxNoBrokers = (CheckBox) findViewById(R.id.checkbox_no_brokers);

        // Setup spinners
        List<AreaParam> areas = AreaParam.queryAll();
        List<DistrictParam> districts = DistrictParam.queryAll();
        List<RoomsParam> rooms = RoomsParam.queryAll();
        List<CityParam> cities = CityParam.queryAll();
        List<PriceParam> prices = PriceParam.queryAll();

        ArrayAdapter<AreaParam> areaAdapter = new ArrayAdapter<AreaParam>(this, android.R.layout.simple_spinner_item, areas);
        ArrayAdapter<DistrictParam> districtAdapter = new ArrayAdapter<DistrictParam>(this, android.R.layout.simple_spinner_item, districts);
        ArrayAdapter<RoomsParam> roomAdapter = new ArrayAdapter<RoomsParam>(this, android.R.layout.simple_spinner_item, rooms);
        ArrayAdapter<CityParam> cityAdapter = new ArrayAdapter<CityParam>(this, android.R.layout.simple_spinner_item, cities);
        ArrayAdapter<PriceParam> priceAdapter = new ArrayAdapter<PriceParam>(this, android.R.layout.simple_spinner_item, prices);

        spinnerArea.setAdapter(areaAdapter);
        spinnerDistrict.setAdapter(districtAdapter);
        spinnerRooms.setAdapter(roomAdapter);
        spinnerPrice.setAdapter(priceAdapter);
        spinnerCity.setAdapter(cityAdapter);
        spinnerArea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // Setup radiobuttons
        mRadioButtonDistrict.setOnClickListener(radioButtonClickListener);
        mRadioButtonMetro.setOnClickListener(radioButtonClickListener);

        // Setup checkboxes
        mCheckBoxNewBuilding.setOnCheckedChangeListener(checkedChangeListener);
        mCheckBoxNearSubway.setOnCheckedChangeListener(checkedChangeListener);
        mCheckBoxWithPhoto.setOnCheckedChangeListener(checkedChangeListener);
        mCheckBoxWithPhoto.setChecked(true);
        mCheckBoxNoFee.setOnCheckedChangeListener(checkedChangeListener);
        mCheckBoxNoBrokers.setOnCheckedChangeListener(checkedChangeListener);


    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton) v;
            switch (rb.getId()) {
                case R.id.radiobutton_district:
                    Log.d(TAG, "onClick: DISTRICT radiobutton selected " + mRadioButtonDistrict.isChecked());
                    Log.d(TAG, "onClick: METRO radiobutton selected " + mRadioButtonMetro.isChecked());
                    mPrefs.edit().putBoolean(PREFS_RADIO_DISTRICT, mRadioButtonDistrict.isChecked()).apply();
                    mPrefs.edit().putBoolean(PREFS_RADIO_METRO, mRadioButtonMetro.isChecked()).apply();

                    break;
                case R.id.radiobutton_metro:
                    Log.d(TAG, "onClick: DISTRICT radiobutton selected " + mRadioButtonDistrict.isChecked());
                    Log.d(TAG, "onClick: METRO radiobutton selected " + mRadioButtonMetro.isChecked());
                    mPrefs.edit().putBoolean(PREFS_RADIO_DISTRICT, mRadioButtonDistrict.isChecked()).apply();
                    mPrefs.edit().putBoolean(PREFS_RADIO_METRO, mRadioButtonMetro.isChecked()).apply();
                    break;

                default:
                    break;
            }
        }
    };

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            CheckBox checkBox = (CheckBox) compoundButton;
            switch (checkBox.getId()) {
                case R.id.checkbox_new_building:
                    Log.d(TAG, "onCheckedChanged: new building " + mCheckBoxNewBuilding.isChecked());
                    mPrefs.edit().putBoolean(PREFS_CHECKBOX_BUILDING, mCheckBoxNewBuilding.isChecked()).apply();
                    break;
                case R.id.checkbox_near_subway:
                    Log.d(TAG, "onCheckedChanged: near subway " + mCheckBoxNearSubway.isChecked());
                    mPrefs.edit().putBoolean(PREFS_CHECKBOX_SUBWAY, mCheckBoxNearSubway.isChecked()).apply();
                    break;
                case R.id.checkbox_with_photo:
                    Log.d(TAG, "onCheckedChanged: with photo " + mCheckBoxWithPhoto.isChecked());
                    mPrefs.edit().putBoolean(PREFS_CHECKBOX_WITH_PHOTO, mCheckBoxWithPhoto.isChecked()).apply();
                    break;
                case R.id.checkbox_no_fee:
                    Log.d(TAG, "onCheckedChanged: no feee " + mCheckBoxNoFee.isChecked());
                    mPrefs.edit().putBoolean(PREFS_CHECKBOX_NO_FEE, mCheckBoxNoFee.isChecked()).apply();
                    break;
                case R.id.checkbox_no_brokers:
                    Log.d(TAG, "onCheckedChanged: no brockers " + mCheckBoxNoBrokers.isChecked());
                    mPrefs.edit().putBoolean(PREFS_CHECKBOX_NO_BROKERS, mCheckBoxNoBrokers.isChecked()).apply();
                    break;


                default:
                    break;
            }
        }
    };

    AdapterView.OnItemSelectedListener spinnerItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Spinner spinner = (Spinner) view;
            switch (spinner.getId()) {
                case R.id.:

                    break;
                case R.id.:

                    break;
                case R.id.:

                    break;
                case R.id.:

                    break;
                case R.id.:

                    break;

                default:
                    break;
            }

            @Override
            public void onNothingSelected (AdapterView < ? > adapterView){

            }
        }

        ;


    }
