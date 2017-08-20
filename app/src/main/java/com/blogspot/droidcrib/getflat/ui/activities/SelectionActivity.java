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
import com.blogspot.droidcrib.getflat.networking.RestClient;

import java.util.List;

import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_CHECKBOX_BUILDING;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_CHECKBOX_NO_BROKERS;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_CHECKBOX_NO_FEE;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_CHECKBOX_NEAR_SUBWAY;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_CHECKBOX_WITH_PHOTO;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_RADIO_DISTRICT;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_RADIO_METRO;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_SPINNER_AREA;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_SPINNER_CITY;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_SPINNER_DISTRICT;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_SPINNER_PRICE;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_SPINNER_ROOMS;
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
    private List<AreaParam> mAreas;
    private List<DistrictParam> mDistricts;
    private List<RoomsParam> mRooms;
    private List<CityParam> mCities;
    private List<PriceParam> mPrices;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        mPrefs = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        RestClient.getQueryParameters(this);


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
        mAreas = AreaParam.queryAll();
        mDistricts = DistrictParam.queryAll();
        mRooms = RoomsParam.queryAll();
        mCities = CityParam.queryAll();
        mPrices = PriceParam.queryAll();

        ArrayAdapter<AreaParam> areaAdapter = new ArrayAdapter<AreaParam>(this, android.R.layout.simple_spinner_item, mAreas);
        ArrayAdapter<DistrictParam> districtAdapter = new ArrayAdapter<DistrictParam>(this, android.R.layout.simple_spinner_item, mDistricts);
        ArrayAdapter<RoomsParam> roomAdapter = new ArrayAdapter<RoomsParam>(this, android.R.layout.simple_spinner_item, mRooms);
        ArrayAdapter<CityParam> cityAdapter = new ArrayAdapter<CityParam>(this, android.R.layout.simple_spinner_item, mCities);
        ArrayAdapter<PriceParam> priceAdapter = new ArrayAdapter<PriceParam>(this, android.R.layout.simple_spinner_item, mPrices);

        spinnerArea.setAdapter(areaAdapter);
        spinnerDistrict.setAdapter(districtAdapter);
        spinnerRooms.setAdapter(roomAdapter);
        spinnerPrice.setAdapter(priceAdapter);
        spinnerCity.setAdapter(cityAdapter);
        spinnerArea.setOnItemSelectedListener(spinnerItemSelectedListener);
        spinnerDistrict.setOnItemSelectedListener(spinnerItemSelectedListener);
        spinnerRooms.setOnItemSelectedListener(spinnerItemSelectedListener);
        spinnerPrice.setOnItemSelectedListener(spinnerItemSelectedListener);
        spinnerCity.setOnItemSelectedListener(spinnerItemSelectedListener);

        // Setup radiobuttons
        mRadioButtonDistrict.setOnClickListener(radioButtonClickListener);
        mRadioButtonMetro.setOnClickListener(radioButtonClickListener);

        // Setup checkboxes
        mCheckBoxNewBuilding.setOnCheckedChangeListener(checkedChangeListener);
        mCheckBoxNearSubway.setOnCheckedChangeListener(checkedChangeListener);
        mCheckBoxWithPhoto.setOnCheckedChangeListener(checkedChangeListener);
//        mCheckBoxWithPhoto.setChecked(true);
//        mPrefs.edit().putString(PREFS_CHECKBOX_WITH_PHOTO, mCheckBoxWithPhoto.isChecked() ? "1" : "0").apply();
        mCheckBoxNoFee.setOnCheckedChangeListener(checkedChangeListener);
        mCheckBoxNoBrokers.setOnCheckedChangeListener(checkedChangeListener);


        // Set last defined values
        // checkboxes
        String s = mPrefs.getString(PREFS_CHECKBOX_BUILDING, "0");
        mCheckBoxNewBuilding.setChecked(s.equals("1"));
        s = mPrefs.getString(PREFS_CHECKBOX_NEAR_SUBWAY, "0");
        mCheckBoxNearSubway.setChecked(s.equals("1"));
        s = mPrefs.getString(PREFS_CHECKBOX_WITH_PHOTO, "0");
        mCheckBoxWithPhoto.setChecked(s.equals("1"));
        s = mPrefs.getString(PREFS_CHECKBOX_NO_BROKERS, "0");
        mCheckBoxNoBrokers.setChecked(s.equals("1"));
        s = mPrefs.getString(PREFS_CHECKBOX_NO_FEE, "0");
        mCheckBoxNoFee.setChecked(s.equals("1"));
        // radio
        s = mPrefs.getString(PREFS_RADIO_DISTRICT, "0");
        mRadioButtonDistrict.setChecked(s.equals("1"));
        s = mPrefs.getString(PREFS_RADIO_METRO, "0");
        mRadioButtonMetro.setChecked(s.equals("1"));

        if (mRadioButtonDistrict.isChecked()) {
            //TODO: set values for district or metro spinner
        }

        // spinners
        int i = mPrefs.getInt(PREFS_SPINNER_DISTRICT, 0);
        spinnerDistrict.setSelection(i);
//        PARAM_SUBWAY, prefs.getString(, "0"));
//        PARAM_SUBWAY_DISTANCE_MAX, prefs.getString(, "0"));

        i = mPrefs.getInt(PREFS_SPINNER_ROOMS, 0);
        spinnerRooms.setSelection(i);
        i = mPrefs.getInt(PREFS_SPINNER_AREA, 0);
        spinnerArea.setSelection(i);
        i = mPrefs.getInt(PREFS_SPINNER_PRICE, 0);
        spinnerPrice.setSelection(i);

    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton) v;
            switch (rb.getId()) {
                case R.id.radiobutton_district:
                    Log.d(TAG, "onClick: DISTRICT radiobutton selected " + mRadioButtonDistrict.isChecked());
                    Log.d(TAG, "onClick: METRO radiobutton selected " + mRadioButtonMetro.isChecked());
                    mPrefs.edit().putString(PREFS_RADIO_DISTRICT, mRadioButtonDistrict.isChecked() ? "1" : "0").apply();
                    mPrefs.edit().putString(PREFS_RADIO_METRO, mRadioButtonMetro.isChecked() ? "1" : "0").apply();

                    break;
                case R.id.radiobutton_metro:
                    Log.d(TAG, "onClick: DISTRICT radiobutton selected " + mRadioButtonDistrict.isChecked());
                    Log.d(TAG, "onClick: METRO radiobutton selected " + mRadioButtonMetro.isChecked());
                    mPrefs.edit().putString(PREFS_RADIO_DISTRICT, mRadioButtonDistrict.isChecked() ? "1" : "0").apply();
                    mPrefs.edit().putString(PREFS_RADIO_METRO, mRadioButtonMetro.isChecked() ? "1" : "0").apply();
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
                    mPrefs.edit().putString(PREFS_CHECKBOX_BUILDING, mCheckBoxNewBuilding.isChecked() ? "1" : "0").apply();
                    break;
                case R.id.checkbox_near_subway:
                    Log.d(TAG, "onCheckedChanged: near subway " + mCheckBoxNearSubway.isChecked());
                    mPrefs.edit().putString(PREFS_CHECKBOX_NEAR_SUBWAY, mCheckBoxNearSubway.isChecked() ? "1" : "0").apply();
                    break;
                case R.id.checkbox_with_photo:
                    Log.d(TAG, "onCheckedChanged: with photo " + mCheckBoxWithPhoto.isChecked());
                    mPrefs.edit().putString(PREFS_CHECKBOX_WITH_PHOTO, mCheckBoxWithPhoto.isChecked() ? "1" : "0").apply();
                    break;
                case R.id.checkbox_no_fee:
                    Log.d(TAG, "onCheckedChanged: no feee " + mCheckBoxNoFee.isChecked());
                    mPrefs.edit().putString(PREFS_CHECKBOX_NO_FEE, mCheckBoxNoFee.isChecked() ? "1" : "0").apply();
                    break;
                case R.id.checkbox_no_brokers:
                    Log.d(TAG, "onCheckedChanged: no brockers " + mCheckBoxNoBrokers.isChecked());
                    mPrefs.edit().putString(PREFS_CHECKBOX_NO_BROKERS, mCheckBoxNoBrokers.isChecked() ? "1" : "0").apply();
                    break;
                default:
                    break;
            }
        }
    };

    AdapterView.OnItemSelectedListener spinnerItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Spinner spinner = (Spinner) adapterView;
            switch (spinner.getId()) {
                case R.id.spinner_city:
                    Log.d(TAG, "onItemSelected: position = " + i + " id = " + l + " item name = " + mCities.get(i).toString());
                    mPrefs.edit().putInt(PREFS_SPINNER_CITY, i).apply();
                    break;
                case R.id.spinner_district:
                    Log.d(TAG, "onItemSelected: position = " + i + " id = " + l + " item name = " + mDistricts.get(i).toString());
                    mPrefs.edit().putInt(PREFS_SPINNER_DISTRICT, i).apply();
                    break;
                case R.id.spinner_rooms:
                    Log.d(TAG, "onItemSelected: position = " + i + " id = " + l + " item name = " + mRooms.get(i).toString());
                    mPrefs.edit().putInt(PREFS_SPINNER_ROOMS, i).apply();
                    break;
                case R.id.spinner_area:
                    Log.d(TAG, "onItemSelected: position = " + i + " id = " + l + " item name = " + mAreas.get(i).toString());
                    mPrefs.edit().putInt(PREFS_SPINNER_AREA, i).apply();
                    break;
                case R.id.spinner_price:
                    Log.d(TAG, "onItemSelected: position = " + i + " id = " + l + " item name = " + mPrices.get(i).toString());
                    mPrefs.edit().putInt(PREFS_SPINNER_PRICE, i).apply();
                    break;

                default:
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    };


}
