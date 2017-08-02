
package com.blogspot.droidcrib.getflat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IsExclusive {

    @SerializedName("value")
    @Expose
    private Object value;
    @SerializedName("valueLabel")
    @Expose
    private Object valueLabel;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValueLabel() {
        return valueLabel;
    }

    public void setValueLabel(Object valueLabel) {
        this.valueLabel = valueLabel;
    }

}
