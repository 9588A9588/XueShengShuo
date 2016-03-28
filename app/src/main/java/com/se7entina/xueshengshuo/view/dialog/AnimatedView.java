package com.se7entina.xueshengshuo.view.dialog;

import android.content.Context;
import android.view.View;

/**
 * Class: AnimatedView
 * Created by se7enTina on 2015/12/9.
 * Description: 动画视图属性
 */
@SuppressWarnings("ALL")
public class AnimatedView extends View {

    private int target;

    public AnimatedView(Context context) {
        super(context);
    }

    public float getXFactor() {
        return getX() / target;
    }

    public void setXFactor(float xFactor) {
        setX(target * xFactor);
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getTarget() {
        return target;
    }
}