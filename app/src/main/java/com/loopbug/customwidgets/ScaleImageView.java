package com.loopbug.customwidgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by joaoluis on 08/04/15.
 *
 * Option FIT_XY Scales the image but Keeps the Aspec Ratio
 */
public class ScaleImageView extends ImageView {

    public ScaleImageView(Context context) {
        super(context);
    }

    public ScaleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScaleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if(getScaleType() == ScaleType.FIT_XY){
            final Drawable image = getDrawable();
            if (image == null) {
                setMeasuredDimension(0, 0);
            }else {
                int width = MeasureSpec.getSize(widthMeasureSpec);
                int height = width * image.getIntrinsicHeight() / image.getIntrinsicWidth();
                setMeasuredDimension(width, height);
            }
        }else{
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
