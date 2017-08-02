
package com.blogspot.droidcrib.getflat.model.card;

import com.blogspot.droidcrib.getflat.model.GaBaseAttributes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SourceLink {

    @SerializedName("labelSiteName")
    @Expose
    private String labelSiteName;
    @SerializedName("labelMore")
    @Expose
    private String labelMore;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("gaBaseAttributes")
    @Expose
    private GaBaseAttributes gaBaseAttributes;

    public String getLabelSiteName() {
        return labelSiteName;
    }

    public void setLabelSiteName(String labelSiteName) {
        this.labelSiteName = labelSiteName;
    }

    public String getLabelMore() {
        return labelMore;
    }

    public void setLabelMore(String labelMore) {
        this.labelMore = labelMore;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public GaBaseAttributes getGaBaseAttributes() {
        return gaBaseAttributes;
    }

    public void setGaBaseAttributes(GaBaseAttributes gaBaseAttributes) {
        this.gaBaseAttributes = gaBaseAttributes;
    }

}
