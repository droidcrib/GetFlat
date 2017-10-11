package com.blogspot.droidcrib.getflat.ui.screens.all;

import android.content.Context;
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
import com.blogspot.droidcrib.getflat.evenbus.FavoriteAddedEvent;
import com.blogspot.droidcrib.getflat.model.card.Card;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by BulanovA on 06.08.2017.
 */

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardViewHolder> implements CardsAdapterView {

    private List<Card> cardList;
    private static final String TAG = "CardCheck";
    private Context context;
    private CardsAdapterPresenter cardsPresenter;
    private ApartmentsListPresenter listPresenter;

    public CardsAdapter(List<Card> cards, Context context, ApartmentsListPresenter listPresenter) {
        this.cardList = cards;
        this.context = context;
        cardsPresenter = new CardsAdapterPresenterImpl(this);
        this.listPresenter = listPresenter;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_list_row, parent, false);

        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, final int position) {
        final Card card = cardList.get(position);
        Log.d(TAG, "onBindViewHolder: Card = " + card.toString());
        if (card.geo.address != null && card.geo.address.streetOrBuilding != null) {
            holder.street.setText(card.geo.address.streetOrBuilding);
        }
        if (card.geo.address != null
                && card.geo.address.house != null) {
            holder.number.setText(card.geo.address.house);
        }
        if (card.price != null) {
            holder.price.setText(card.price);
        }
        if (card.realtyFeatures != null && card.realtyFeatures.size() >= 1) {
            holder.rooms.setText(card.realtyFeatures.get(0).value);
        }
        if (card.realtyFeatures != null && card.realtyFeatures.size() >= 2) {
            holder.meters.setText(card.realtyFeatures.get(1).value);
        }
        if (card.realtyFeatures != null && card.realtyFeatures.size() >= 3) {
            holder.floor.setText(card.realtyFeatures.get(2).value);
        }
        if (card.description != null) {
            holder.description.setText(card.description.text);
        }
        if (card.isFavourite != null && card.isFavourite) {
            holder.favorites.setImageResource(R.drawable.ic_favorite_black_48dp);
        } else {
            holder.favorites.setImageResource(R.drawable.ic_favorite_border_black_48dp);
        }
        holder.photo.setImageResource(R.drawable.house_holder);
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
        }

        holder.favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardsPresenter.manageFavorite(card, holder);
                // TODO: add favorites list presenter here
//                favoritesListPresenter.refreshList();

//                favoritesSetter(card, holder);
                EventBus.getDefault().post(new FavoriteAddedEvent());
            }
        });


        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardsPresenter.deleteCard(card);

//                Card.setDeleted(card.pageId, true);
//                Deleted.insert(card);
//                EventBus.getDefault().post(new CardRemovedEvent(card.pageId));
            }
        });

        holder.note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardsPresenter.setNote(context, card);
//                MemoUtils.buildDialogMessageNewNote(context, card);

            }
        });
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }


    public class CardViewHolder extends RecyclerView.ViewHolder {
        public TextView street, number, price, rooms, meters,
                floor, description;
        ImageView photo, favorites, remove, note;

        public CardViewHolder(View view) {
            super(view);
            street = (TextView) view.findViewById(R.id.id_list_row_street);
            number = (TextView) view.findViewById(R.id.id_list_row_number);
            price = (TextView) view.findViewById(R.id.id_list_row_price);
            rooms = (TextView) view.findViewById(R.id.id_list_row_rooms);
            meters = (TextView) view.findViewById(R.id.id_list_row_meters);
            floor = (TextView) view.findViewById(R.id.id_list_row_floor);
            description = (TextView) view.findViewById(R.id.id_list_row_description);
            photo = (ImageView) view.findViewById(R.id.id_list_row_photo);
            favorites = (ImageView) view.findViewById(R.id.favorites);
            remove = (ImageView) view.findViewById(R.id.remove);
            note = (ImageView) view.findViewById(R.id.note);
        }
    }


    @Override
    public void markFavorite(Card card, CardViewHolder holder) {
        holder.favorites.setImageResource(R.drawable.ic_favorite_black_48dp);
    }

    @Override
    public void unmarkFavorite(Card card, CardViewHolder holder) {
        holder.favorites.setImageResource(R.drawable.ic_favorite_border_black_48dp);
    }


    @Override
    public void markNote(Card card, CardViewHolder holder) {

        // TODO: change icon depending on conditions

//        if (card.isFavourite != null && card.isFavourite) {
//            Card.setFavourite(card.getId(), false);
//            holder.favorites.setImageResource(R.drawable.ic_favorite_border_black_48dp);
//        } else {
//            Card.setFavourite(card.getId(), true);
//            holder.favorites.setImageResource(R.drawable.ic_favorite_black_48dp);
//        }
    }
}
