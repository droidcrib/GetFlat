
package com.blogspot.droidcrib.getflat.model.card;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActionElementsLabels {

    @SerializedName("additionalAdvertisements")
    @Expose
    private Object additionalAdvertisements;
    @SerializedName("complaint")
    @Expose
    private String complaint;

    public Object getAdditionalAdvertisements() {
        return additionalAdvertisements;
    }

    public void setAdditionalAdvertisements(Object additionalAdvertisements) {
        this.additionalAdvertisements = additionalAdvertisements;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

}
