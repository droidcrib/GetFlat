package com.blogspot.droidcrib.getflat.ui.adapters;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.BitmapRequestListener;
import com.blogspot.droidcrib.getflat.R;
import com.blogspot.droidcrib.getflat.model.card.Card;

import java.util.List;

/**
 * Created by BulanovA on 06.08.2017.
 */

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardViewHolder> {

    private List<Card> cardList;
    private static final String TAG = "CardCheck";

    public CardsAdapter(List<Card> cards) {
        this.cardList = cards;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_list_row, parent, false);

        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, int position) {
        Card card = cardList.get(position);
        Log.d(TAG, "onBindViewHolder: Card = " + card.toString());
        if (card.geo.address != null && card.geo.address.streetOrBuilding != null) {
            holder.street.setText(card.geo.address.streetOrBuilding);
        }
        if (card.geo.address != null
                && card.geo.address.house != null) {
            holder.number.setText(card.geo.address.house);
        }
//        if (card.geo.district != null && card.geo.district.name != null) {
//            holder.district.setText(card.geo.district.name);
//        }
//        if (card.geo.microdistrict != null && card.geo.microdistrict.name != null) {
//            holder.microdistrict.setText(card.geo.microdistrict.name);
//        }
        if (card.price != null) {
            holder.price.setText(card.price);
        }
        if (card.realtyFeatures != null && card.realtyFeatures.size() >= 1) {
            holder.rooms.setText(card.realtyFeatures.get(0).value);
        }
//        if (card.houseFeatures != null && card.houseFeatures.size() >= 1) {
//            holder.project.setText(card.houseFeatures.get(0).value);
//        }
        if (card.realtyFeatures != null && card.realtyFeatures.size() >= 2) {
            holder.meters.setText(card.realtyFeatures.get(1).value);
        }
//        if (card.houseFeatures != null && card.houseFeatures.size() >= 2) {
//            holder.year.setText(card.houseFeatures.get(1).value);
//        }
        if (card.realtyFeatures != null && card.realtyFeatures.size() >= 3) {
            holder.floor.setText(card.realtyFeatures.get(2).value);
        }
//        if (card.houseFeatures != null && card.houseFeatures.size() >= 3) {
//            holder.material.setText(card.houseFeatures.get(2).value);
//        }
        if (card.description != null) {
            holder.descriprion.setText(card.description.text);
        }
        if (card.photo != null) {
            AndroidNetworking.get(card.photo.url)
                    .build()
                    .getAsBitmap(new BitmapRequestListener() {
                        @Override
                        public void onResponse(Bitmap bitmap) {
                            holder.photo.setImageBitmap(bitmap);
                            // do anything with bitmap
                        }
                        @Override
                        public void onError(ANError error) {
                            // handle error
                        }
                    });
//            holder.photo.setImageBitmap();
        }
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        public TextView street, number, district, microdistrict, price, rooms, project, meters, year,
                floor, material, descriprion;
        ImageView photo;

        public CardViewHolder(View view) {
            super(view);
            street = (TextView) view.findViewById(R.id.id_list_row_street);
            number = (TextView) view.findViewById(R.id.id_list_row_number);
//            district = (TextView) view.findViewById(R.id.id_list_row_district);
//            microdistrict = (TextView) view.findViewById(R.id.id_list_row_microdistrict);
            price = (TextView) view.findViewById(R.id.id_list_row_price);
            rooms = (TextView) view.findViewById(R.id.id_list_row_rooms);
//            project = (TextView) view.findViewById(R.id.id_list_row_project);
            meters = (TextView) view.findViewById(R.id.id_list_row_meters);
//            year = (TextView) view.findViewById(R.id.id_list_row_year);
            floor = (TextView) view.findViewById(R.id.id_list_row_floor);
//            material = (TextView) view.findViewById(R.id.id_list_row_material);
            descriprion = (TextView) view.findViewById(R.id.id_list_row_description);
            photo = (ImageView) view.findViewById(R.id.id_list_row_photo);

        }
    }
}
