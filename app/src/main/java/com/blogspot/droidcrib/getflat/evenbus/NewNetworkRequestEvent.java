package com.blogspot.droidcrib.getflat.evenbus;

import android.support.v4.util.ArrayMap;

/**
 * Created by BulanovA on 24.08.2017.
 */

public class NewNetworkRequestEvent {
    private final String addr;
    private final ArrayMap<String, String> params;
    private final int page;

    public NewNetworkRequestEvent(String addr, ArrayMap<String, String> params, int page) {
        this.addr = addr;
        this.params = params;
        this.page = page;
    }

    public String getAddr() {
        return addr;
    }

    public ArrayMap<String, String> getParams() {
        return params;
    }

    public int getPage() {
        return page;
    }
}

