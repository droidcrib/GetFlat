
package com.blogspot.droidcrib.getflat.model.card;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.activeandroid.util.SQLiteUtils;
import com.blogspot.droidcrib.getflat.model.ActionElementsLabels;
import com.blogspot.droidcrib.getflat.model.AdvertisementFeatures;
import com.blogspot.droidcrib.getflat.model.SingleRealtyPageLink;
import com.blogspot.droidcrib.getflat.model.userdata.Deleted;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.facebook.stetho.inspector.network.ResponseHandlingInputStream.TAG;

@Table(name = "Cards", id = "_id")
public class Card extends Model {

    private static final String TAG = "Card";

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
    @Column(name = "geo")
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
    @Column(name = "time")
    @SerializedName("time")
    @Expose
    public Time time;
    @Column(name = "photo")
    @SerializedName("photo")
    @Expose
    public Photo photo;
    @Column(name = "imagesCount")
    @SerializedName("imagesCount")
    @Expose
    public Integer imagesCount;
    @Column(name = "sourceLink")
    @SerializedName("sourceLink")
    @Expose
    public SourceLink sourceLink;
    @Column(name = "singleRealtyPageLink")
    @SerializedName("singleRealtyPageLink")
    @Expose
    public SingleRealtyPageLink singleRealtyPageLink;
    @Column(name = "advertisementFeatures")
    @SerializedName("advertisementFeatures")
    @Expose
    public AdvertisementFeatures advertisementFeatures;
    @Column(name = "realtyFeatures")
    @SerializedName("realtyFeatures")
    @Expose
    public List<RealtyFeature> realtyFeatures = null;
    @Column(name = "houseFeatures")
    @SerializedName("houseFeatures")
    @Expose
    public List<HouseFeature> houseFeatures = null;
    @Column(name = "description")
    @SerializedName("description")
    @Expose
    public Description description;
    @Column(name = "actionElementsLabels")
    @SerializedName("actionElementsLabels")
    @Expose
    public ActionElementsLabels actionElementsLabels;
    @Column(name = "actionOtherContactsUrl")
    @SerializedName("actionOtherContactsUrl")
    @Expose
    public String actionOtherContactsUrl;

    @Column(name = "isDeleted")
    public Boolean isDeleted;

    public void insert() {
        this.isDeleted = false;
        this.save();
    }

    public static List<Card> queryAll() {
        List<Card> cardList = new Select()
                .from(Card.class)
                .where("isDeleted = ?", false)
                .execute();

        for (Card card : cardList) {
            card.geo = card.getMany(Geo.class, "card").get(0);
            Log.d(TAG, "queryAll: -- not in deleted");
            try {
                card.geo.address = card.geo.getAddresses().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", "address: ");
            }
            try {
                card.geo.district = card.geo.getDistricts().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", "district: ");
            }
            try {
                card.geo.microdistrict = card.geo.getMicrodistricts().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", "microdistrict: ");
            }
            try {
                card.geo.building = card.geo.getBuildings().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", "building: ");
            }
            try {
                card.photo = card.getPhotos().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", "photo: ");
            }

            try {
                card.description = card.getDescriptions().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", ": ");
            }
            try {
                card.sourceLink = card.getSourceLinks().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", ": ");
            }
            try {
                card.time = card.getTimes().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", ": ");
            }
            card.houseFeatures = card.getHouseFeatures();
            card.realtyFeatures = card.getRealtyFeatures();

        }
        return cardList;
    }

    public static List<Card> queryAllNotFavourites() {
        List<Card> cardList = new Select()
                .from(Card.class)
                .where("isDeleted = ? AND (isFavourite = ? OR isFavourite is null)", false, false)
                .execute();

        for (Card card : cardList) {
            card.geo = card.getMany(Geo.class, "card").get(0);
            Log.d(TAG, "queryAll: -- not in deleted");
            try {
                card.geo.address = card.geo.getAddresses().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", "address: ");
            }
            try {
                card.geo.district = card.geo.getDistricts().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", "district: ");
            }
            try {
                card.geo.microdistrict = card.geo.getMicrodistricts().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", "microdistrict: ");
            }
            try {
                card.geo.building = card.geo.getBuildings().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", "building: ");
            }
            try {
                card.photo = card.getPhotos().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", "photo: ");
            }

            try {
                card.description = card.getDescriptions().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", ": ");
            }
            try {
                card.sourceLink = card.getSourceLinks().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", ": ");
            }
            try {
                card.time = card.getTimes().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", ": ");
            }
            card.houseFeatures = card.getHouseFeatures();
            card.realtyFeatures = card.getRealtyFeatures();

        }
        return cardList;
    }

    public static List<Card> queryFavorites() {
        List<Card> cardList = new Select()
                .from(Card.class)
                .where("isFavourite = ? AND  isDeleted = ?", true, false)
                .execute();

        for (Card card : cardList) {
            card.geo = card.getMany(Geo.class, "card").get(0);

//            if (card.geo.address != null) {
            try {
                card.geo.address = card.geo.getAddresses().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", "address: ");
            }
            try {
                card.geo.district = card.geo.getDistricts().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", "district: ");
            }
            try {
                card.geo.microdistrict = card.geo.getMicrodistricts().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", "microdistrict: ");
            }
            try {
                card.geo.building = card.geo.getBuildings().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", "building: ");
            }
            try {
                card.photo = card.getPhotos().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", "photo: ");
            }

            try {
                card.description = card.getDescriptions().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", ": ");
            }
            try {
                card.sourceLink = card.getSourceLinks().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", ": ");
            }
            try {
                card.time = card.getTimes().get(0);
            } catch (IndexOutOfBoundsException e) {
                Log.e("err", ": ");
            }
            card.houseFeatures = card.getHouseFeatures();
            card.realtyFeatures = card.getRealtyFeatures();
        }
        return cardList;
    }


    public static void deleteAllNotFavorites() {
       // SQLiteUtils.execSql("DELETE FROM Cards WHERE isFavourite is null or isFavourite = 0");
        SQLiteUtils.execSql("DELETE FROM Cards\n" +
                "WHERE isFavourite IS NULL \n" +
                "OR isFavourite = 0 AND \n" +
                "Cards._id NOT IN (SELECT card FROM UserNotes)");
    }

    public static void deleteOnConditionChange(){
        SQLiteUtils.execSql("DELETE FROM Cards WHERE isFavourite is null or isFavourite = 0");
    }


    public List<Photo> getPhotos() {
        return getMany(Photo.class, "card");
    }

    public List<Description> getDescriptions() {
        return getMany(Description.class, "card");
    }

    public List<SourceLink> getSourceLinks() {
        return getMany(SourceLink.class, "card");
    }

    public List<Time> getTimes() {
        return getMany(Time.class, "card");
    }


    public static List<Integer> getPageIds() {
        List<Integer> ids = new ArrayList<>();
        List<Card> cardList = new Select()
                .from(Card.class)
                .execute();
        for (Card card : cardList) {
            ids.add(card.pageId);
        }
        return ids;
    }

    public static Card queryById(long id) {
        return new Select()
                .from(Card.class)
                .where("_id = ?", id)
                .executeSingle();
    }

    public static Card queryByPageid(int pageId) {
        return new Select()
                .from(Card.class)
                .where("pageId = ?", pageId)
                .executeSingle();
    }

//    public static List<Geo> getGeos() {
//        return getMany(Geo.class, "card");
//    }


    public static void setFavourite(long id, Boolean isFavourite) {
        Card card = Card.queryById(id);
        card.isFavourite = isFavourite;
        card.description = null;
        card.geo = null;
        card.photo = null;
        card.sourceLink = null;
        card.time = null;
        card.save();
    }

    public static void setDeleted(int pageId, boolean isDeleted) {
        Card card = Card.queryByPageid(pageId);
        card.isDeleted = isDeleted;
        card.description = null;
        card.geo = null;
        card.photo = null;
        card.sourceLink = null;
        card.time = null;
        card.save();
    }





    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }


    public List<RealtyFeature> getRealtyFeatures() {
        return getMany(RealtyFeature.class, "card");
    }


    public List<HouseFeature> getHouseFeatures() {
        return getMany(HouseFeature.class, "card");
    }

}
