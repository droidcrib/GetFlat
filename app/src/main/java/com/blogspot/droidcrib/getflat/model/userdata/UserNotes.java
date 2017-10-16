package com.blogspot.droidcrib.getflat.model.userdata;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.blogspot.droidcrib.getflat.model.card.Card;

/**
 * Created by BulanovA on 04.09.2017.
 */

@Table(name = "UserNotes", id = "_id")
public class UserNotes extends Model {



    @Column(name = "text")
    public String text;

    @Column(name = "card", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Card card;


    public static void insert(String text, Card card){
        UserNotes note = new UserNotes();
        note.text = text;
        note.card = card;
        note.save();
    }

    public static void update(UserNotes note, String text){
        note.text = text;
        note.save();
    }

    public static UserNotes getNoteByCardId(Card card){
         UserNotes un = new Select()
                .from(UserNotes.class)
                .where("card = ?", card.getId())
                .executeSingle();

        return un;
    }

    public static void queryAll(){

    }

}
