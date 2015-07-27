package com.loopbug.customwidgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Spinner;

public class StateSpinnerView extends Spinner {

    private OnSpinnerEventsListener mListener;
    private boolean mOpenInitiated = false;

    public StateSpinnerView(Context context) {
        super(context);
    }

    public StateSpinnerView(Context context, int mode) {
        super(context, mode);
    }

    public StateSpinnerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StateSpinnerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public StateSpinnerView(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
    }

    @Override
    public boolean performClick() {
        // register that the Spinner was opened so we have a status
        // indicator for the activity(which may lose focus for some other
        // reasons)
        mOpenInitiated = true;
        if (mListener != null) {
            mListener.onSpinnerOpened();
        }
        return super.performClick();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

    }

    public void setSpinnerEventsListener(
            OnSpinnerEventsListener onSpinnerEventsListener) {
        mListener = onSpinnerEventsListener;
    }

    /**
     * Propagate the closed Spinner event to the listener from outside.
     */
    public void performClosedEvent() {
        mOpenInitiated = false;
        if (mListener != null) {
            mListener.onSpinnerClosed();
        }
        this.onDetachedFromWindow();
    }

    /**
     * A boolean flag indicating that the Spinner triggered an open event.
     *
     * @return true for opened Spinner
     */
    public boolean hasBeenOpened() {
        return mOpenInitiated;
    }

    public interface OnSpinnerEventsListener {
        void onSpinnerOpened();
        void onSpinnerClosed();
    }
}
