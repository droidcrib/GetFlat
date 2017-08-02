package com.blogspot.droidcrib.getflat.networking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by abulanov on 12/29/2016.
 */

public class GsonSingleton {

    private GsonSingleton(){
    }

    public static Gson getInstance(){
        return GsonSingletonHolder.instance;
    }

    private static class GsonSingletonHolder{
        private final static Gson instance = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }
}
