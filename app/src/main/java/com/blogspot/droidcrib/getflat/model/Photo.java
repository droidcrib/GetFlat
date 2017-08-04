
package com.blogspot.droidcrib.getflat.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Table(name = "Photos", id = "_id")
public class Photo extends Model{

    @Column(name = "title")
    @SerializedName("title")
    @Expose
    private String title;
    @Column(name = "url")
    @SerializedName("url")
    @Expose
    private String url;
    @Column(name = "url2x")
    @SerializedName("url2x")
    @Expose
    private String url2x;
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
