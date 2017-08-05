
package com.blogspot.droidcrib.getflat.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Table(name = "SourceLinks", id = "_id")
public class SourceLink extends Model {

    @Column(name = "labelSiteName")
    @SerializedName("labelSiteName")
    @Expose
    public String labelSiteName;
    @Column(name = "labelMore")
    @SerializedName("labelMore")
    @Expose
    public String labelMore;
    @Column(name = "url")
    @SerializedName("url")
    @Expose
    public String url;
    @Column(name = "gaBaseAttributes")
    @SerializedName("gaBaseAttributes")
    @Expose
    public GaBaseAttributes gaBaseAttributes;

    @Column(name = "card", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Card card;

    public void insert(Card card) {
        this.card = card;
        this.save();
    }


    public String getLabelSiteName() {
        return labelSiteName;
    }

    public void setLabelSiteName(String labelSiteName) {
        this.labelSiteName = labelSiteName;
    }

    public String getLabelMore() {
        return labelMore;
    }

    public void setLabelMore(String labelMore) {
        this.labelMore = labelMore;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public GaBaseAttributes getGaBaseAttributes() {
        return gaBaseAttributes;
    }

    public void setGaBaseAttributes(GaBaseAttributes gaBaseAttributes) {
        this.gaBaseAttributes = gaBaseAttributes;
    }

}
