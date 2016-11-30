package com.anwesome.uiview.rippleloader;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anweshmishra on 30/11/16.
 */
public class RippleLoader{
    private AppCompatActivity appCompatActivity;
    private RippleLoaderView rippleLoaderView;
    public RippleLoader(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }
    public void startLoading() {
        rippleLoaderView = new RippleLoaderView(appCompatActivity.getApplicationContext());
        this.appCompatActivity.addContentView(rippleLoaderView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }
    public void stop() {
        rippleLoaderView.setVisibility(View.INVISIBLE);
    }
}
