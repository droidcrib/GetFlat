package com.blogspot.droidcrib.getflat.evenbus;

/**
 * Created by BulanovA on 24.08.2017.
 */

public class FavoriteRemovedEvent {

    private int pageId;

    public FavoriteRemovedEvent(int pageId) {
        this.pageId = pageId;
    }

    public int getPageId() {
        return pageId;
    }
}

