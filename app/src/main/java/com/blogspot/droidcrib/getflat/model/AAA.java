
package com.blogspot.droidcrib.getflat.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AAA {

    @SerializedName("cards")
    @Expose
    private List<Card> cards = null;
    @SerializedName("baikonurUpperBlockConfig")
    @Expose
    private BaikonurUpperBlockConfig baikonurUpperBlockConfig;
    @SerializedName("complaintBoxConfig")
    @Expose
    private ComplaintBoxConfig complaintBoxConfig;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("microdistrictReview")
    @Expose
    private Object microdistrictReview;
    @SerializedName("additionalRealtyDescription")
    @Expose
    private AdditionalRealtyDescription additionalRealtyDescription;
    @SerializedName("houseInformation")
    @Expose
    private Object houseInformation;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public BaikonurUpperBlockConfig getBaikonurUpperBlockConfig() {
        return baikonurUpperBlockConfig;
    }

    public void setBaikonurUpperBlockConfig(BaikonurUpperBlockConfig baikonurUpperBlockConfig) {
        this.baikonurUpperBlockConfig = baikonurUpperBlockConfig;
    }

    public ComplaintBoxConfig getComplaintBoxConfig() {
        return complaintBoxConfig;
    }

    public void setComplaintBoxConfig(ComplaintBoxConfig complaintBoxConfig) {
        this.complaintBoxConfig = complaintBoxConfig;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Object getMicrodistrictReview() {
        return microdistrictReview;
    }

    public void setMicrodistrictReview(Object microdistrictReview) {
        this.microdistrictReview = microdistrictReview;
    }

    public AdditionalRealtyDescription getAdditionalRealtyDescription() {
        return additionalRealtyDescription;
    }

    public void setAdditionalRealtyDescription(AdditionalRealtyDescription additionalRealtyDescription) {
        this.additionalRealtyDescription = additionalRealtyDescription;
    }

    public Object getHouseInformation() {
        return houseInformation;
    }

    public void setHouseInformation(Object houseInformation) {
        this.houseInformation = houseInformation;
    }

}
