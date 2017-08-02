
package com.blogspot.droidcrib.getflat.model.card;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Table(name = "Cards", id = "_id")
public class Card extends Model{

    @Column(name = "type")
    @SerializedName("type")
    @Expose
    public String type;
    @Column(name = "pageId")
    @SerializedName("pageId")
    @Expose
    public Integer pageId;
    @Column(name = "totalAdvertisementsCount")
    @SerializedName("totalAdvertisementsCount")
    @Expose
    public Integer totalAdvertisementsCount;
    @Column(name = "isFavourite")
    @SerializedName("isFavourite")
    @Expose
    public Boolean isFavourite;
    @Column(name = "isVisited")
    @SerializedName("isVisited")
    @Expose
    public Boolean isVisited;

    @SerializedName("geo")
    @Expose
    public Geo geo;
    @Column(name = "price")
    @SerializedName("price")
    @Expose
    public String price;
    @Column(name = "priceSqm")
    @SerializedName("priceSqm")
    @Expose
    public String priceSqm;
    @Column(name = "doShowPriceSqm")
    @SerializedName("doShowPriceSqm")
    @Expose
    public Boolean doShowPriceSqm;

    @SerializedName("time")
    @Expose
    public Time time;

    @SerializedName("photo")
    @Expose
    public Photo photo;
    @Column(name = "imagesCount")
    @SerializedName("imagesCount")
    @Expose
    public Integer imagesCount;

    @SerializedName("sourceLink")
    @Expose
    public SourceLink sourceLink;

    @SerializedName("singleRealtyPageLink")
    @Expose
    public SingleRealtyPageLink singleRealtyPageLink;

    @SerializedName("advertisementFeatures")
    @Expose
    public AdvertisementFeatures advertisementFeatures;

    @SerializedName("realtyFeatures")
    @Expose
    public List<RealtyFeature> realtyFeatures = null;
    @Column(name = "houseFeatures")
    @SerializedName("houseFeatures")
    @Expose
    public List<HouseFeature> houseFeatures = null;

    @SerializedName("description")
    @Expose
    public Description description;

    @SerializedName("actionElementsLabels")
    @Expose
    public ActionElementsLabels actionElementsLabels;
    @Column(name = "actionOtherContactsUrl")
    @SerializedName("actionOtherContactsUrl")
    @Expose
    public String actionOtherContactsUrl;


    // ActiveAndroid methods

    public long insert(){
        save();
        return getId();
    }







    // POJO Methods
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public Integer getTotalAdvertisementsCount() {
        return totalAdvertisementsCount;
    }

    public void setTotalAdvertisementsCount(Integer totalAdvertisementsCount) {
        this.totalAdvertisementsCount = totalAdvertisementsCount;
    }

    public Object getIsFavourite() {
        return isFavourite;
    }

    public void setIsFavourite(Boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    public Object getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(Boolean isVisited) {
        this.isVisited = isVisited;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceSqm() {
        return priceSqm;
    }

    public void setPriceSqm(String priceSqm) {
        this.priceSqm = priceSqm;
    }

    public Boolean getDoShowPriceSqm() {
        return doShowPriceSqm;
    }

    public void setDoShowPriceSqm(Boolean doShowPriceSqm) {
        this.doShowPriceSqm = doShowPriceSqm;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Integer getImagesCount() {
        return imagesCount;
    }

    public void setImagesCount(Integer imagesCount) {
        this.imagesCount = imagesCount;
    }

    public SourceLink getSourceLink() {
        return sourceLink;
    }

    public void setSourceLink(SourceLink sourceLink) {
        this.sourceLink = sourceLink;
    }

    public SingleRealtyPageLink getSingleRealtyPageLink() {
        return singleRealtyPageLink;
    }

    public void setSingleRealtyPageLink(SingleRealtyPageLink singleRealtyPageLink) {
        this.singleRealtyPageLink = singleRealtyPageLink;
    }

    public AdvertisementFeatures getAdvertisementFeatures() {
        return advertisementFeatures;
    }

    public void setAdvertisementFeatures(AdvertisementFeatures advertisementFeatures) {
        this.advertisementFeatures = advertisementFeatures;
    }

    public List<RealtyFeature> getRealtyFeatures() {
        return realtyFeatures;
    }

    public void setRealtyFeatures(List<RealtyFeature> realtyFeatures) {
        this.realtyFeatures = realtyFeatures;
    }

    public List<HouseFeature> getHouseFeatures() {
        return houseFeatures;
    }

    public void setHouseFeatures(List<HouseFeature> houseFeatures) {
        this.houseFeatures = houseFeatures;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public ActionElementsLabels getActionElementsLabels() {
        return actionElementsLabels;
    }

    public void setActionElementsLabels(ActionElementsLabels actionElementsLabels) {
        this.actionElementsLabels = actionElementsLabels;
    }

    public String getActionOtherContactsUrl() {
        return actionOtherContactsUrl;
    }

    public void setActionOtherContactsUrl(String actionOtherContactsUrl) {
        this.actionOtherContactsUrl = actionOtherContactsUrl;
    }

    @Override
    public String toString() {
        return "Card{" +
                "type='" + type + '\'' +
                ", \n pageId=" + pageId +
                ", \n totalAdvertisementsCount=" + totalAdvertisementsCount +
                ", \n isFavourite=" + isFavourite +
                ", \n isVisited=" + isVisited +
                ", \n geo=" + geo +
                ", \n price='" + price + '\'' +
                ", \n priceSqm='" + priceSqm + '\'' +
                ", \n doShowPriceSqm=" + doShowPriceSqm +
                ", \n time=" + time +
                ", \n photo=" + photo +
                ", \n imagesCount=" + imagesCount +
                ", \n sourceLink=" + sourceLink +
                ", \n singleRealtyPageLink=" + singleRealtyPageLink +
                ", \n advertisementFeatures=" + advertisementFeatures +
                ", \n realtyFeatures=" + realtyFeatures +
                ", \n houseFeatures=" + houseFeatures +
                ", \n description=" + description +
                ", \n actionElementsLabels=" + actionElementsLabels +
                ", \n actionOtherContactsUrl='" + actionOtherContactsUrl + '\'' +
                '}';
    }
}
