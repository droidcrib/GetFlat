
package com.blogspot.droidcrib.getflat.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Card {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("pageId")
    @Expose
    private Integer pageId;
    @SerializedName("totalAdvertisementsCount")
    @Expose
    private Integer totalAdvertisementsCount;
    @SerializedName("isFavourite")
    @Expose
    private Object isFavourite;
    @SerializedName("isVisited")
    @Expose
    private Object isVisited;
    @SerializedName("geo")
    @Expose
    private Geo geo;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("priceSqm")
    @Expose
    private String priceSqm;
    @SerializedName("doShowPriceSqm")
    @Expose
    private Boolean doShowPriceSqm;
    @SerializedName("time")
    @Expose
    private Time time;
    @SerializedName("photo")
    @Expose
    private Photo photo;
    @SerializedName("imagesCount")
    @Expose
    private Integer imagesCount;
    @SerializedName("sourceLink")
    @Expose
    private SourceLink sourceLink;
    @SerializedName("singleRealtyPageLink")
    @Expose
    private SingleRealtyPageLink singleRealtyPageLink;
    @SerializedName("advertisementFeatures")
    @Expose
    private AdvertisementFeatures advertisementFeatures;
    @SerializedName("realtyFeatures")
    @Expose
    private List<RealtyFeature> realtyFeatures = null;
    @SerializedName("houseFeatures")
    @Expose
    private List<HouseFeature> houseFeatures = null;
    @SerializedName("description")
    @Expose
    private Description description;
    @SerializedName("actionElementsLabels")
    @Expose
    private ActionElementsLabels actionElementsLabels;
    @SerializedName("actionOtherContactsUrl")
    @Expose
    private String actionOtherContactsUrl;

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

    public void setIsFavourite(Object isFavourite) {
        this.isFavourite = isFavourite;
    }

    public Object getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(Object isVisited) {
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
                ",\n  pageId=" + pageId +
                ",\n  totalAdvertisementsCount=" + totalAdvertisementsCount +
                ",\n  isFavourite=" + isFavourite +
                ",\n  isVisited=" + isVisited +
                ",\n  geo=" + geo +
                ",\n  price='" + price + '\'' +
                ",\n  priceSqm='" + priceSqm + '\'' +
                ",\n  doShowPriceSqm=" + doShowPriceSqm +
                ",\n  time=" + time +
                ",\n  photo=" + photo +
                ",\n  imagesCount=" + imagesCount +
                ",\n  sourceLink=" + sourceLink +
                ",\n  singleRealtyPageLink=" + singleRealtyPageLink +
                ",\n  advertisementFeatures=" + advertisementFeatures +
                ",\n  realtyFeatures=" + realtyFeatures +
                ",\n  houseFeatures=" + houseFeatures +
                ",\n  description=" + description +
                ",\n  actionElementsLabels=" + actionElementsLabels +
                ",\n  actionOtherContactsUrl='" + actionOtherContactsUrl + '\'' +
                '}';
    }
}
