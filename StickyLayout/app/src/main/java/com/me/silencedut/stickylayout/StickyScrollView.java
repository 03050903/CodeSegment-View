package com.me.silencedut.stickylayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by SilenceDut on 16/2/17.
 */
public class StickyScrollView extends ScrollView {

    private OnScrollListener mOnScrollListener;

    public interface OnScrollListener {
        void onScroll(int scrollY);
    }

    public void setScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener=onScrollListener;
    }

    public StickyScrollView(Context context) {
        super(context);
    }

    public StickyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StickyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public StickyScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(mOnScrollListener!=null){
            mOnScrollListener.onScroll(t);
        }
    }

}
