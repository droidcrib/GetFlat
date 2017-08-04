
package com.blogspot.droidcrib.getflat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Building {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("searchUrl")
    @Expose
    private String searchUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    @Override
    public String toString() {
        return "Building{" +
                "\n name='" + name + '\'' +
                ",\n searchUrl='" + searchUrl + '\'' +
                '}';
    }
}
