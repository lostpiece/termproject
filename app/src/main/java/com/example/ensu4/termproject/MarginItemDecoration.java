package com.example.ensu4.termproject;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class MarginItemDecoration extends RecyclerView.ItemDecoration {


    private final int mVerticalSpaceHeight;


    public MarginItemDecoration(int mMarginSize) {
        this.mVerticalSpaceHeight = mMarginSize;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.bottom = mVerticalSpaceHeight;
        outRect.right = mVerticalSpaceHeight;
        outRect.left = mVerticalSpaceHeight;
        outRect.top = mVerticalSpaceHeight;
    }
}