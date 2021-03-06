
package com.blogspot.droidcrib.getflat.model.card;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.blogspot.droidcrib.getflat.model.card.Card;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Table(name = "Photos", id = "_id")
public class Photo extends Model{

    @Column(name = "title")
    @SerializedName("title")
    @Expose
    public String title;
    @Column(name = "url")
    @SerializedName("url")
    @Expose
    public String url;
    @Column(name = "url2x")
    @SerializedName("url2x")
    @Expose
    public String url2x;
    @Column(name = "card", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Card card;

    public void insert(Card card){
        this.card = card;
        this.save();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl2x() {
        return url2x;
    }

    public void setUrl2x(String url2x) {
        this.url2x = url2x;
    }

}
