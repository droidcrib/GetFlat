package com.blogspot.droidcrib.getflat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.blogspot.droidcrib.getflat.networking.JsonDecoder;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

import static com.blogspot.droidcrib.getflat.utils.Parser.getPureJSON;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RestTest";
    private String mResp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.request);

        // Adding an Network Interceptor for Debugging purpose
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        AndroidNetworking.initialize(getApplicationContext(), okHttpClient);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Button Pressed");
                request();

            }
        });


    }

    //district=1&roomCount=1&areaTotalMin=25&priceMax=4000&currency=2

    private void request() {
        AndroidNetworking.get("https://www.lun.ua/{addr}")
                .addPathParameter("addr", "аренда-квартир-киев")
                .addQueryParameter("district", "1")
                .addQueryParameter("roomCount", "1")
                .addQueryParameter("areaTotalMin", "25")
                //.addQueryParameter("priceMax", "4000")
                .addQueryParameter("currency", "2")
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String response) {
                        mResp = response;
                        JsonDecoder.getCards(getPureJSON(mResp));
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(TAG, "onError: " + anError.toString());
                    }
                })
        ;
    }
}
