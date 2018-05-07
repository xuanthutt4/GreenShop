package com.greenshop.greenshop.DataController;

import android.content.Context;
import android.widget.LinearLayout;

public class CustomLinearCategory extends LinearLayout {
    private boolean isScrollEnabled = false;
    public CustomLinearCategory(Context context) {
        super(context);
    }

    public void setScrollEnabled(boolean scrollEnabled) {
        isScrollEnabled = scrollEnabled;
    }

    @Override
    public boolean canScrollVertically(int direction) {
        return isScrollEnabled && super.canScrollVertically(direction);
    }
}
