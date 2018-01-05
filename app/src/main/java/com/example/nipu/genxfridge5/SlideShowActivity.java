package com.example.nipu.genxfridge5;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class SlideShowActivity extends Activity {

    private ViewFlipper myViewFlipper;
    private float initialXPoint;
    int[] image = { R.drawable.moi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_show);
        myViewFlipper = (ViewFlipper) findViewById(R.id.myflipper);

        for (int i = 0; i < image.length; i++) {
            ImageView imageView = new ImageView(SlideShowActivity.this);
            imageView.setImageResource(image[i]);
            myViewFlipper.addView(imageView);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initialXPoint = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                float finalx = event.getX();
                if (initialXPoint > finalx) {
                    if (myViewFlipper.getDisplayedChild() == image.length)
                        break;
                    myViewFlipper.showNext();
                } else {
                    if (myViewFlipper.getDisplayedChild() == 0)
                        break;
                    myViewFlipper.showPrevious();
                }
                break;
        }
        return false;
    }
}