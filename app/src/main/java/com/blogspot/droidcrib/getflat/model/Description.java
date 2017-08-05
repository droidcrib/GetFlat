
package com.blogspot.droidcrib.getflat.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Table(name = "Descriptions", id = "_id")
public class Description extends Model {

    @Column(name = "text")
    @SerializedName("text")
    @Expose
    public String text;
    @Column(name = "textHighlight")
    @SerializedName("textHighlight")
    @Expose
    public Boolean textHighlight;

    @Column(name = "card", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Card card;

    public void insert(Card card) {
        this.card = card;
        this.save();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getTextHighlight() {
        return textHighlight;
    }

    public void setTextHighlight(Boolean textHighlight) {
        this.textHighlight = textHighlight;
    }

}
