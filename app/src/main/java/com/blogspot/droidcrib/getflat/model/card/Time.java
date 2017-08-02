
package com.blogspot.droidcrib.getflat.model.card;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Time {

    @SerializedName("updateTime")
    @Expose
    private String updateTime;
    @SerializedName("addTime")
    @Expose
    private String addTime;
    @SerializedName("addTimeLabel")
    @Expose
    private String addTimeLabel;
    @SerializedName("updateTimeLabel")
    @Expose
    private String updateTimeLabel;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getAddTimeLabel() {
        return addTimeLabel;
    }

    public void setAddTimeLabel(String addTimeLabel) {
        this.addTimeLabel = addTimeLabel;
    }

    public String getUpdateTimeLabel() {
        return updateTimeLabel;
    }

    public void setUpdateTimeLabel(String updateTimeLabel) {
        this.updateTimeLabel = updateTimeLabel;
    }

}
