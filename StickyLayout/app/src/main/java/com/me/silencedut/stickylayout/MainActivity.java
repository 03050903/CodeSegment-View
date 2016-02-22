package com.me.silencedut.stickylayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;

public class MainActivity extends AppCompatActivity implements StickyScrollView.OnScrollListener{

    private View mStickyTop;
    private View mStickyNormal;
    private View mContentLayout;
    private StickyScrollView mStickyScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContentLayout =findViewById(R.id.content);
        mStickyScrollView=(StickyScrollView)findViewById(R.id.stickyScrollView);
        mStickyTop=findViewById(R.id.stickyTopTv);
        mStickyNormal=findViewById(R.id.stickyNormalTv);

        mStickyScrollView.setScrollListener(this);

        mContentLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                onScroll(mStickyScrollView.getScrollY());
            }
        });

    }
    @Override
    public void onScroll(int scrollY) {
        int stickyY = Math.max(scrollY,mStickyNormal.getTop());
        mStickyTop.layout(0, stickyY, mStickyTop.getWidth(), stickyY + mStickyTop.getHeight());
    }
}
