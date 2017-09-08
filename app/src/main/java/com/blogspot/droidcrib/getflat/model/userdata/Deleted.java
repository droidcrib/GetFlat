package com.blogspot.droidcrib.getflat.model.userdata;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.blogspot.droidcrib.getflat.model.card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BulanovA on 04.09.2017.
 */

@Table(name = "Deleted", id = "_id")
public class Deleted extends Model {

    @Column(name = "pageId")
    public Integer pageId;

    public static void insert(Card card){
        Deleted deleted = new Deleted();
        deleted.pageId = card.pageId;
        deleted.save();
    }



    public static List<Integer> getDeletedPageIds() {
        List<Integer> ids = new ArrayList<>();
        List<Deleted> deletedList = new Select()
                .from(Deleted.class)
                .execute();
        for (Deleted deleted : deletedList) {
            ids.add(deleted.pageId);
        }
        return ids;
    }

}
