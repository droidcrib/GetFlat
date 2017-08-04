
package com.blogspot.droidcrib.getflat.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Table(name = "Times", id = "_id")
public class Time extends Model{

    @Column(name = "updateTime")
    @SerializedName("updateTime")
    @Expose
    private String updateTime;
    @Column(name = "addTime")
    @SerializedName("addTime")
    @Expose
    private String addTime;
    @Column(name = "addTimeLabel")
    @SerializedName("addTimeLabel")
    @Expose
    private String addTimeLabel;
    @Column(name = "updateTimeLabel")
    @SerializedName("updateTimeLabel")
    @Expose
    private String updateTimeLabel;

    @Column(name = "card", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public Card card;

    public void insert(Card card){
        this.card = card;
        this.save();
    }



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
