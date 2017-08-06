package com.blogspot.droidcrib.getflat.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blogspot.droidcrib.getflat.R;
import com.blogspot.droidcrib.getflat.model.card.Card;

import java.util.List;

/**
 * Created by BulanovA on 06.08.2017.
 */

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardViewHolder> {

    private List<Card> cardList;

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
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Card card = cardList.get(position);
        holder.address.setText(card.geo.address.getStreetOrBuilding() + " " +card.geo.address.house);
        holder.district.setText(card.geo.district.name);
        holder.microdistrict.setText(card.geo.microdistrict.name);
        holder.price.setText(card.price);
        holder.rooms.setText("4 rooms");
        holder.project.setText("good project");
        holder.meters.setText("150 meters");
        holder.year.setText("2017");
        holder.floor.setText("13-floor");
        holder.material.setText("square blocks");
        holder.descriprion.setText(card.description.text);

    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        public TextView address, district, microdistrict, price, rooms, project, meters, year,
                floor, material, descriprion;

        public CardViewHolder(View view) {
            super(view);
            address = (TextView) view.findViewById(R.id.id_list_row_address);
            district = (TextView) view.findViewById(R.id.id_list_row_district);
            microdistrict = (TextView) view.findViewById(R.id.id_list_row_microdistrict);
            price = (TextView) view.findViewById(R.id.id_list_row_price);
            rooms = (TextView) view.findViewById(R.id.id_list_row_rooms);
            project = (TextView) view.findViewById(R.id.id_list_row_project);
            meters = (TextView) view.findViewById(R.id.id_list_row_meters);
            year = (TextView) view.findViewById(R.id.id_list_row_year);
            floor = (TextView) view.findViewById(R.id.id_list_row_floor);
            material = (TextView) view.findViewById(R.id.id_list_row_material);
            descriprion = (TextView) view.findViewById(R.id.id_list_row_description);

        }
    }
}
