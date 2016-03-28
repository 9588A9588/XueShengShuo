package com.se7entina.xueshengshuo.view.dialog;

import android.view.animation.Interpolator;

/**
 * Class: HesitateInterpolator
 * Created by se7enTina on 2015/12/9.
 * Description: 计算插值器
 */
@SuppressWarnings("ALL")
public class HesitateInterpolator implements Interpolator {

    private static double POW = 1.0/2.0;
    @Override
    public float getInterpolation(float input) {
        return input < 0.5
                ? (float) Math.pow(input * 2, POW) * 0.5f
                : (float) Math.pow((1 - input) * 2, POW) * -0.5f + 1;
    }
}