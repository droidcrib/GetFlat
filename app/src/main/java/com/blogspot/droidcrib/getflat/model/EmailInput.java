
package com.blogspot.droidcrib.getflat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmailInput {

    @SerializedName("placeholder")
    @Expose
    private String placeholder;
    @SerializedName("validationErrorMessage")
    @Expose
    private String validationErrorMessage;

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getValidationErrorMessage() {
        return validationErrorMessage;
    }

    public void setValidationErrorMessage(String validationErrorMessage) {
        this.validationErrorMessage = validationErrorMessage;
    }

}
