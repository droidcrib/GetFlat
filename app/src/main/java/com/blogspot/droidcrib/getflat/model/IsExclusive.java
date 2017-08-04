
package com.blogspot.droidcrib.getflat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IsExclusive {

    @SerializedName("value")
    @Expose
    private Boolean value;
    @SerializedName("valueLabel")
    @Expose
    private Object valueLabel;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Object getValueLabel() {
        return valueLabel;
    }

    public void setValueLabel(Object valueLabel) {
        this.valueLabel = valueLabel;
    }

}
