package com.blogspot.droidcrib.getflat.evenbus;

import android.support.v4.util.ArrayMap;

/**
 * Created by BulanovA on 24.08.2017.
 */

public class NewNetworkResponseEvent {
    private final String response;

    public NewNetworkResponseEvent(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

}

