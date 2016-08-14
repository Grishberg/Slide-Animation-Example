package com.grishberg.testanimation.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.grishberg.testanimation.R;

/**
 * Created by grishberg on 14.08.16.
 */
public class CustomView extends LinearLayout {
    private static final String TAG = CustomView.class.getSimpleName();

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(getContext(), R.layout.view_custom_layout, this);
    }

    public void add(View parent){
        if(parent instanceof FrameLayout){
            ((FrameLayout) parent).addView(this);
        }
    }
}
