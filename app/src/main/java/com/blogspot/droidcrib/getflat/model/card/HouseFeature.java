
package com.blogspot.droidcrib.getflat.model.card;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.blogspot.droidcrib.getflat.model.card.Card;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Table(name = "HouseFeatures", id = "_id")
public class HouseFeature extends Model {

    @Column(name = "type")
    @SerializedName("type")
    @Expose
    public String type;
    @Column(name = "value")
    @SerializedName("value")
    @Expose
    public String value;
    @Column(name = "card", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Card card;

    public void insert(Card card) {
        this.card = card;
        this.save();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HouseFeature{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
