
package com.blogspot.droidcrib.getflat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendCompleted {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("closeButtonLabel")
    @Expose
    private String closeButtonLabel;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCloseButtonLabel() {
        return closeButtonLabel;
    }

    public void setCloseButtonLabel(String closeButtonLabel) {
        this.closeButtonLabel = closeButtonLabel;
    }

}
