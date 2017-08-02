
package com.blogspot.droidcrib.getflat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Presets {

    @SerializedName("differentFlats")
    @Expose
    private DifferentFlats differentFlats;

    public DifferentFlats getDifferentFlats() {
        return differentFlats;
    }

    public void setDifferentFlats(DifferentFlats differentFlats) {
        this.differentFlats = differentFlats;
    }

}
