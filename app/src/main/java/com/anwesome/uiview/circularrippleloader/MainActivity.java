package com.anwesome.uiview.circularrippleloader;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anwesome.uiview.rippleloader.RippleLoader;

public class MainActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    private RippleLoader rippleLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rippleLoader = new RippleLoader(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(i<10) {
                    try{
                        Thread.sleep(1000);
                        i++;
                    }
                    catch (Exception ex) {

                    }
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rippleLoader.stop();
                    }
                });
            }
        }).start();
        rippleLoader.startLoading();
    }

}
