
package com.blogspot.droidcrib.getflat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OptionAdditionalIfIsOwner {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("isEmailRequired")
    @Expose
    private Boolean isEmailRequired;
    @SerializedName("isCommentRequired")
    @Expose
    private Boolean isCommentRequired;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getIsEmailRequired() {
        return isEmailRequired;
    }

    public void setIsEmailRequired(Boolean isEmailRequired) {
        this.isEmailRequired = isEmailRequired;
    }

    public Boolean getIsCommentRequired() {
        return isCommentRequired;
    }

    public void setIsCommentRequired(Boolean isCommentRequired) {
        this.isCommentRequired = isCommentRequired;
    }

}
