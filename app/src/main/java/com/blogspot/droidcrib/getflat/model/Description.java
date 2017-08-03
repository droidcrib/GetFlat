
package com.blogspot.droidcrib.getflat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Description {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("textHighlight")
    @Expose
    private Object textHighlight;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Object getTextHighlight() {
        return textHighlight;
    }

    public void setTextHighlight(Object textHighlight) {
        this.textHighlight = textHighlight;
    }

}
