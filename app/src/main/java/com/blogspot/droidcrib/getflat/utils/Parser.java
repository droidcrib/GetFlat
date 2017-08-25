package com.blogspot.droidcrib.getflat.utils;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by BulanovA on 01.08.2017.
 */

public class Parser {
    private static final String TAG = "RestTest";
    String json = "";
    private Parser() {
        super();
    }

    public static String getPureJSON(final String httpResponse) {

                Pattern p = Pattern.compile("(__APP_INITIAL_STATE__\\s+=\\s+)(.+)(;)");
                Matcher m = p.matcher(httpResponse);
                if (m.find()) {
                    Log.d(TAG, "MATCH");
//                    Log.d(TAG, "getPureJSON: " + m.group(2));
//                    saveHtmlFile(m.group(2));
                } else {
                    Log.d(TAG, "NO MATCH");
                }


        return m.group(2);
    }

//    public static void saveHtmlFile(String html) {
//
//        String path = Environment.getExternalStorageDirectory().getPath();
//        String fileName = "testfile";//DateFormat.format("dd_MM_yyyy_hh_mm_ss", System.currentTimeMillis()).toString();
//        fileName = fileName + ".html";
//        File file = new File(path, fileName);
//        //String html = "<html><head><title>Title</title></head><body>This is random text.</body></html>";
//
//        try {
//            FileOutputStream out = new FileOutputStream(file);
//            byte[] data = html.getBytes();
//            out.write(data);
//            out.close();
//            Log.e(TAG, "File Save : " + file.getPath());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
