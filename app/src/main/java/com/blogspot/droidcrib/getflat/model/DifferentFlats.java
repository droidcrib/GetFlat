
package com.blogspot.droidcrib.getflat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DifferentFlats {

    @SerializedName("selectedOptionValue")
    @Expose
    private String selectedOptionValue;

    public String getSelectedOptionValue() {
        return selectedOptionValue;
    }

    public void setSelectedOptionValue(String selectedOptionValue) {
        this.selectedOptionValue = selectedOptionValue;
    }

}
