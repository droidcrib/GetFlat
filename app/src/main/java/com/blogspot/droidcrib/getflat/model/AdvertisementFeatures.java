
package com.blogspot.droidcrib.getflat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdvertisementFeatures {

    @SerializedName("isOwner")
    @Expose
    private IsOwner isOwner;
    @SerializedName("isExclusive")
    @Expose
    private IsExclusive isExclusive;

    public IsOwner getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(IsOwner isOwner) {
        this.isOwner = isOwner;
    }

    public IsExclusive getIsExclusive() {
        return isExclusive;
    }

    public void setIsExclusive(IsExclusive isExclusive) {
        this.isExclusive = isExclusive;
    }

}
