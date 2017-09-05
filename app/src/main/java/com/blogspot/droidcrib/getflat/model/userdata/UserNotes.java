package com.blogspot.droidcrib.getflat.model.userdata;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.blogspot.droidcrib.getflat.model.card.Card;

/**
 * Created by BulanovA on 04.09.2017.
 */

@Table(name = "UserNotes", id = "_id")
public class UserNotes extends Model {

    @Column(name = "userNote")
    public String userNote;

    @Column(name = "card", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Card card;

}
