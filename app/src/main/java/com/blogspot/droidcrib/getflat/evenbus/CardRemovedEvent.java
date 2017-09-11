package com.blogspot.droidcrib.getflat.evenbus;

/**
 * Created by BulanovA on 24.08.2017.
 */

public class CardRemovedEvent {

    private int pageId;

    public CardRemovedEvent(int pageId) {
        this.pageId = pageId;
    }



    public int getPageId() {
        return pageId;
    }
}

