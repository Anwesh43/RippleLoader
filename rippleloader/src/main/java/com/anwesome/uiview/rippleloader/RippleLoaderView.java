package com.anwesome.uiview.rippleloader;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by anweshmishra on 30/11/16.
 */
public class RippleLoaderView extends View{
    private int time = 0;
    private Ripple ripple;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public RippleLoaderView(Context context) {
        super(context);
    }
    public void onDraw(Canvas canvas) {
        if(time == 0) {
            init(canvas.getWidth(),canvas.getHeight());
        }
        canvas.drawColor(LibConstants.BACK_COLOR);
        ripple.draw(canvas,paint);
        ripple.move();
        time++;
        try {
            Thread.sleep(LibConstants.VIEW_DELAY);
            invalidate();
        }
        catch (Exception ex) {

        }
    }
    public void init(int w,int h) {
        ripple = new Ripple(w/2,h/2,w/3);
    }
    private class Ripple  {
        private float x,y,radius=0,max_radius,deg=0;
        public Ripple(float x,float y,float radius) {
            this.x = x;
            this.y = y;
            this.max_radius = radius;
        }
        public void draw(Canvas canvas, Paint paint) {
            paint.setColor(Color.parseColor(LibConstants.RIPPLE_COLOR));
            paint.setStyle(Paint.Style.FILL);
            canvas.save();
            canvas.translate(x,y);
            canvas.rotate(deg);
            float RECT_DIM = max_radius/(LibConstants.MID_RECT_SCALE);
            canvas.drawRoundRect(new RectF(-RECT_DIM,-RECT_DIM,RECT_DIM,RECT_DIM),RECT_DIM/3,RECT_DIM/3,paint);
            canvas.restore();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(LibConstants.RIPPLE_STROKE_WIDTH);
            canvas.drawCircle(x,y,radius,paint);
        }
        public void move() {
            radius+=max_radius/(LibConstants.RIPPLE_SPEED);
            deg+=LibConstants.ROT_SPEED;
            if(radius >= max_radius) {
                radius = 0;
                deg  = 0;
            }
        }
    }

}
