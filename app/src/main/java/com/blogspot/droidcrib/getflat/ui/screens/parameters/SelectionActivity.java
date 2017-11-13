package com.blogspot.droidcrib.getflat.ui.screens.parameters;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.blogspot.droidcrib.getflat.R;
import com.blogspot.droidcrib.getflat.model.card.Card;
import com.blogspot.droidcrib.getflat.model.parameters.AreaParam;
import com.blogspot.droidcrib.getflat.model.parameters.CityParam;
import com.blogspot.droidcrib.getflat.model.parameters.DistrictParam;
import com.blogspot.droidcrib.getflat.model.parameters.ParamsMap;
import com.blogspot.droidcrib.getflat.model.parameters.PriceParam;
import com.blogspot.droidcrib.getflat.model.parameters.RoomsParam;
import com.blogspot.droidcrib.getflat.model.parameters.SubwayDistanceParam;
import com.blogspot.droidcrib.getflat.model.parameters.SubwayParam;
import com.blogspot.droidcrib.getflat.networking.RestClient;

import java.util.List;

import static com.blogspot.droidcrib.getflat.application.App.isConditionChanged;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_AREA_TOTAL_MIN;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_CURRENCY;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_DISTRICT;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_HAS_PHOTOS;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_NEAR_SUBWAY;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_NEW_BIULDING;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_PRICE_MAX;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_ROOM_COUNT;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_SUBWAY;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_SUBWAY_DISTANCE_MAX;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_WITHOUT_BROKERS;
import static com.blogspot.droidcrib.getflat.contract.Constants.PARAM_WITHOUT_FEE;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_RADIO_DISTRICT;
import static com.blogspot.droidcrib.getflat.contract.Constants.PREFS_RADIO_METRO;
import static com.blogspot.droidcrib.getflat.contract.Constants.SHARED_PREFS;

/**
 * Created by BulanovA on 07.08.2017.
 */

public class SelectionActivity extends AppCompatActivity {

    private static final String TAG = "getflat_Selection";

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
    private List<SubwayParam> mSubways;
    private List<SubwayDistanceParam> mSubwayDistances;
    private Spinner spinnerSubway;
    private Spinner spinnerSubwayDistance;
    private Spinner spinnerDistrict;
    private TextView districtMetroLabel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_selection);
        ImageView doneImage = (ImageView) findViewById(R.id.selection_toolbar_done);
        doneImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectionActivity.this.finish();
            }
        });


        mPrefs = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        Spinner spinnerCity = (Spinner) findViewById(R.id.spinner_city);
        spinnerDistrict = (Spinner) findViewById(R.id.spinner_district);
        Spinner spinnerRooms = (Spinner) findViewById(R.id.spinner_rooms);
        Spinner spinnerArea = (Spinner) findViewById(R.id.spinner_area);
        Spinner spinnerPrice = (Spinner) findViewById(R.id.spinner_price);
        spinnerSubway = (Spinner) findViewById(R.id.spinner_subway);
        spinnerSubwayDistance = (Spinner) findViewById(R.id.spinner_subway_distance);
        mRadioButtonDistrict = (RadioButton) findViewById(R.id.radiobutton_district);
        mRadioButtonMetro = (RadioButton) findViewById(R.id.radiobutton_metro);
        mCheckBoxNewBuilding = (CheckBox) findViewById(R.id.checkbox_new_building);
        mCheckBoxNearSubway = (CheckBox) findViewById(R.id.checkbox_near_subway);
        mCheckBoxWithPhoto = (CheckBox) findViewById(R.id.checkbox_with_photo);
        mCheckBoxNoFee = (CheckBox) findViewById(R.id.checkbox_no_fee);
        mCheckBoxNoBrokers = (CheckBox) findViewById(R.id.checkbox_no_brokers);
        districtMetroLabel = (TextView) findViewById(R.id.id_district_metro);

        // Setup spinners
        mAreas = AreaParam.queryAll();
        mDistricts = DistrictParam.queryAll();
        mRooms = RoomsParam.queryAll();
        mCities = CityParam.queryAll();
        mPrices = PriceParam.queryAll();
        mSubways = SubwayParam.queryAll();
        mSubwayDistances = SubwayDistanceParam.queryAll();

        ArrayAdapter<AreaParam> areaAdapter = new ArrayAdapter<AreaParam>(this, android.R.layout.simple_spinner_item, mAreas);
        ArrayAdapter<DistrictParam> districtAdapter = new ArrayAdapter<DistrictParam>(this, android.R.layout.simple_spinner_item, mDistricts);
        ArrayAdapter<RoomsParam> roomAdapter = new ArrayAdapter<RoomsParam>(this, android.R.layout.simple_spinner_item, mRooms);
        ArrayAdapter<CityParam> cityAdapter = new ArrayAdapter<CityParam>(this, android.R.layout.simple_spinner_item, mCities);
        ArrayAdapter<PriceParam> priceAdapter = new ArrayAdapter<PriceParam>(this, android.R.layout.simple_spinner_item, mPrices);
        ArrayAdapter<SubwayParam> subwayAdapter = new ArrayAdapter<SubwayParam>(this, android.R.layout.simple_spinner_item, mSubways);
        ArrayAdapter<SubwayDistanceParam> subwayDistanceAdapter = new ArrayAdapter<SubwayDistanceParam>(this, android.R.layout.simple_spinner_item, mSubwayDistances);

        spinnerArea.setAdapter(areaAdapter);
        spinnerDistrict.setAdapter(districtAdapter);
        spinnerRooms.setAdapter(roomAdapter);
        spinnerPrice.setAdapter(priceAdapter);
        spinnerCity.setAdapter(cityAdapter);
        spinnerSubway.setAdapter(subwayAdapter);
        spinnerSubwayDistance.setAdapter(subwayDistanceAdapter);

        spinnerArea.setOnItemSelectedListener(spinnerItemSelectedListener);
        spinnerDistrict.setOnItemSelectedListener(spinnerItemSelectedListener);
        spinnerRooms.setOnItemSelectedListener(spinnerItemSelectedListener);
        spinnerPrice.setOnItemSelectedListener(spinnerItemSelectedListener);
        spinnerCity.setOnItemSelectedListener(spinnerItemSelectedListener);
        spinnerSubway.setOnItemSelectedListener(spinnerItemSelectedListener);
        spinnerSubwayDistance.setOnItemSelectedListener(spinnerItemSelectedListener);

        // Setup radiobuttons
        mRadioButtonDistrict.setOnClickListener(radioButtonClickListener);
        mRadioButtonMetro.setOnClickListener(radioButtonClickListener);

        // Setup checkboxes
        mCheckBoxNewBuilding.setOnCheckedChangeListener(checkedChangeListener);
        mCheckBoxNearSubway.setOnCheckedChangeListener(checkedChangeListener);
        mCheckBoxWithPhoto.setOnCheckedChangeListener(checkedChangeListener);
        mCheckBoxNoFee.setOnCheckedChangeListener(checkedChangeListener);
        mCheckBoxNoBrokers.setOnCheckedChangeListener(checkedChangeListener);


        // Set last defined values
        // checkboxes
        mCheckBoxNewBuilding.setChecked(ParamsMap.getValue(PARAM_NEW_BIULDING).equals("1"));
        mCheckBoxNearSubway.setChecked(ParamsMap.getValue(PARAM_NEAR_SUBWAY).equals("1"));
        mCheckBoxWithPhoto.setChecked(ParamsMap.getValue(PARAM_HAS_PHOTOS).equals("1"));
        mCheckBoxNoBrokers.setChecked(ParamsMap.getValue(PARAM_WITHOUT_BROKERS).equals("1"));
        mCheckBoxNoFee.setChecked(ParamsMap.getValue(PARAM_WITHOUT_FEE).equals("1"));
        // radio

        if (mPrefs.getString(PREFS_RADIO_METRO, "0").equals("1")) {
            String label = getResources().getString(R.string.label_district);
            districtMetroLabel.setText(label);
            mRadioButtonMetro.setChecked(true);
            setSubwayVisible();

        } else {
            String label = getResources().getString(R.string.label_metro);
            districtMetroLabel.setText(label);
            mRadioButtonDistrict.setChecked(true);
            setDistrictVisible();

        }
        // spinners
        spinnerDistrict.setSelection(ParamsMap.getPos(PARAM_DISTRICT));
        spinnerSubway.setSelection(ParamsMap.getPos(PARAM_SUBWAY));
        spinnerSubwayDistance.setSelection(ParamsMap.getPos(PARAM_SUBWAY_DISTANCE_MAX));
        spinnerRooms.setSelection(ParamsMap.getPos(PARAM_ROOM_COUNT));
        spinnerArea.setSelection(ParamsMap.getPos(PARAM_AREA_TOTAL_MIN));
        spinnerPrice.setSelection(ParamsMap.getPos(PARAM_PRICE_MAX));

        if (mRadioButtonDistrict.isChecked()) {
            String label = getResources().getString(R.string.label_district);
            districtMetroLabel.setText(label);
            spinnerSubway.setVisibility(View.GONE);
            spinnerSubwayDistance.setVisibility(View.GONE);
        } else {
            String label = getResources().getString(R.string.label_metro);
            districtMetroLabel.setText(label);
        }

    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton) v;
            String label = "";
            switch (rb.getId()) {
                case R.id.radiobutton_district:
                    mPrefs.edit().putString(PREFS_RADIO_DISTRICT, mRadioButtonDistrict.isChecked() ? "1" : "0").apply();
                    mPrefs.edit().putString(PREFS_RADIO_METRO, mRadioButtonMetro.isChecked() ? "1" : "0").apply();
                    setDistrictVisible();
                     label = getResources().getString(R.string.label_district);
                    districtMetroLabel.setText(label);
                    break;

                case R.id.radiobutton_metro:
                    mPrefs.edit().putString(PREFS_RADIO_DISTRICT, mRadioButtonDistrict.isChecked() ? "1" : "0").apply();
                    mPrefs.edit().putString(PREFS_RADIO_METRO, mRadioButtonMetro.isChecked() ? "1" : "0").apply();
                    setSubwayVisible();
                    label = getResources().getString(R.string.label_metro);
                    districtMetroLabel.setText(label);
                    break;

                default:
                    break;
            }
            isConditionChanged = true;
        }
    };

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            CheckBox checkBox = (CheckBox) compoundButton;
            switch (checkBox.getId()) {
                case R.id.checkbox_new_building:
                    Log.d(TAG, "onCheckedChanged: new building " + mCheckBoxNewBuilding.isChecked());
                    ParamsMap.updateParameter(PARAM_NEW_BIULDING, mCheckBoxNewBuilding.isChecked() ? "1" : "0");
                    break;
                case R.id.checkbox_near_subway:
                    Log.d(TAG, "onCheckedChanged: near subway " + mCheckBoxNearSubway.isChecked());
                    ParamsMap.updateParameter(PARAM_NEAR_SUBWAY, mCheckBoxNearSubway.isChecked() ? "1" : "0");
                    break;
                case R.id.checkbox_with_photo:
                    Log.d(TAG, "onCheckedChanged: with photo " + mCheckBoxWithPhoto.isChecked());
                    ParamsMap.updateParameter(PARAM_HAS_PHOTOS, mCheckBoxWithPhoto.isChecked() ? "1" : "0");
                    break;
                case R.id.checkbox_no_fee:
                    Log.d(TAG, "onCheckedChanged: no fee " + mCheckBoxNoFee.isChecked());
                    ParamsMap.updateParameter(PARAM_WITHOUT_FEE, mCheckBoxNoFee.isChecked() ? "1" : "0");
                    break;
                case R.id.checkbox_no_brokers:
                    Log.d(TAG, "onCheckedChanged: no brokers " + mCheckBoxNoBrokers.isChecked());
                    ParamsMap.updateParameter(PARAM_WITHOUT_BROKERS, mCheckBoxNoBrokers.isChecked() ? "1" : "0");
                    break;
                default:
                    break;
            }
            isConditionChanged = true;

        }
    };


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
        if(isConditionChanged){
            isConditionChanged = false;
            Card.deleteAllNotFavorites();
            RestClient.newGetRequest("аренда-квартир-киев", RestClient.getQueryParameters(), 1);
        }

    }

    AdapterView.OnItemSelectedListener spinnerItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Spinner spinner = (Spinner) adapterView;
            switch (spinner.getId()) {
                case R.id.spinner_city:
                    Log.d(TAG, "onItemSelected: position = " + i + " id = " + l + " item name = " + mCities.get(i).toString());
                    break;
                case R.id.spinner_district:
                    Log.d(TAG, "onItemSelected: position = " + i + " serverid = " + mDistricts.get(i).serverid + " item name = " + mDistricts.get(i).toString());
                    ParamsMap.updateParameter(PARAM_DISTRICT, mDistricts.get(i).serverid, i);
                    break;
                case R.id.spinner_rooms:
                    Log.d(TAG, "onItemSelected: position = " + i + " id = " + l + " item name = " + mRooms.get(i).toString());
                    ParamsMap.updateParameter(PARAM_ROOM_COUNT, mRooms.get(i).serverid, i);
                    break;
                case R.id.spinner_area:
                    Log.d(TAG, "onItemSelected: position = " + i + " id = " + l + " item name = " + mAreas.get(i).toString());
                    ParamsMap.updateParameter(PARAM_AREA_TOTAL_MIN, mAreas.get(i).serverid, i);
                    break;
                case R.id.spinner_price:
                    Log.d(TAG, "onItemSelected: position = " + i + " id = " + l + " item name = " + mPrices.get(i).toString());
                    ParamsMap.updateParameter(PARAM_PRICE_MAX, mPrices.get(i).serverid, i);
                    if (i == 0) {
                        ParamsMap.updateParameter(PARAM_CURRENCY, "0");
                    } else {
                        ParamsMap.updateParameter(PARAM_CURRENCY, "2");
                    }
                    break;
                case R.id.spinner_subway:
                    Log.d(TAG, "onItemSelected: position = " + i + " id = " + l + " item name = " + mSubways.get(i).toString());
                    ParamsMap.updateParameter(PARAM_SUBWAY, mSubways.get(i).serverid, i);
                    break;
                case R.id.spinner_subway_distance:
                    Log.d(TAG, "onItemSelected: position = " + i + " id = " + l + " item name = " + mSubwayDistances.get(i).toString());
                    ParamsMap.updateParameter(PARAM_SUBWAY_DISTANCE_MAX, mSubwayDistances.get(i).serverid, i);
                    break;

                default:
                    break;
            }
            isConditionChanged = true;

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    };


    private void setDistrictVisible() {
        spinnerSubway.setVisibility(View.GONE);
        spinnerSubwayDistance.setVisibility(View.GONE);
        spinnerDistrict.setVisibility(View.VISIBLE);
        ParamsMap.updateParameter(PARAM_SUBWAY, "0", 0);
        ParamsMap.updateParameter(PARAM_SUBWAY_DISTANCE_MAX, "0", 0);
    }

    private void setSubwayVisible() {
        spinnerSubway.setVisibility(View.VISIBLE);
        spinnerSubwayDistance.setVisibility(View.VISIBLE);
        spinnerDistrict.setVisibility(View.GONE);
        ParamsMap.updateParameter(PARAM_DISTRICT, "0", 0);
    }

}
