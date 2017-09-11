package com.blogspot.droidcrib.getflat.evenbus;

/**
 * Created by BulanovA on 24.08.2017.
 */

public class CardRemovedEvent {


    private int position;
    private int pageId;

    public CardRemovedEvent(int position, int pageId) {
        this.position = position;
        this.pageId = pageId;
    }


    public int getPosition() {
        return position;
    }

    public int getPageId() {
        return pageId;
    }
}

