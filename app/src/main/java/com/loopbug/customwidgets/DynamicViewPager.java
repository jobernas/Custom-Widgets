package com.loopbug.customwidgets;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by joaoluis on 05/05/15.
 */
public class DynamicViewPager extends ViewPager {

    private boolean isLock;

    public DynamicViewPager(Context context) {
        super(context);
        this.isLock = false;
    }

    public DynamicViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.isLock = false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.isLock) return false;
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.isLock) return false;
        return super.onInterceptTouchEvent(event);
    }

    public void setLock(boolean isLock) {
        this.isLock = isLock;
    }
}
