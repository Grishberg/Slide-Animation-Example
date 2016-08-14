package com.grishberg.testanimation.framework;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import android.view.View;

/**
 * Created by grishberg on 14.08.16.
 */
public class AnimationHelper {
    private static final String TAG = AnimationHelper.class.getSimpleName();

    public static void slide(Context context, final View view) {
        Log.d(TAG, "slide: ");
        int viewHeight = view.getHeight();
        if (viewHeight == 0) {
            Log.e(TAG, "slide: h==0");
            view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
            viewHeight = view.getMeasuredHeight();
        }
        final int delta = viewHeight;
        ValueAnimator animation = ValueAnimator.ofInt(delta, 0);
        view.setTranslationY(delta);
        animation.setDuration(500);
        view.setVisibility(View.VISIBLE);


        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int offset = (int) animation.getAnimatedValue();
                view.setTranslationY(offset);
            }
        });
        animation.start();
    }
}
