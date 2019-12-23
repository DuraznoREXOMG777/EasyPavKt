package com.highflyers.commonresources.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;

import androidx.constraintlayout.widget.ConstraintLayout;

public class SlidingConstraintLayout extends ConstraintLayout {

    private float xFraction = 0;

    public SlidingConstraintLayout(Context context) {
        super(context);
    }

    public SlidingConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SlidingConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private ViewTreeObserver.OnPreDrawListener preDrawListener = null;

    public void setXFraction(float fraction) {

        this.xFraction = fraction;

        if (getWidth() == 0) {
            if (preDrawListener == null) {
                preDrawListener = new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        getViewTreeObserver().removeOnPreDrawListener(preDrawListener);
                        setXFraction(xFraction);
                        return true;
                    }
                };
                getViewTreeObserver().addOnPreDrawListener(preDrawListener);
            }
            return;
        }

        float translationX = getWidth() * fraction;
        setTranslationX(translationX);
    }

    public float getXFraction() {
        return this.xFraction;
    }
}
