package com.greenshop.greenshop.ViewControllers;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import com.greenshop.greenshop.AdapterCustom.SlideAdapter;
import com.greenshop.greenshop.R;


public class SplashActivity extends AppCompatActivity {

    ViewPager pager;
    LinearLayout layout;
    ArrayList<ImageView> mDots;
    Button mNext, mBack;
    int currentPage;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mDots = new ArrayList<>();

        pager = findViewById(R.id.slideViewPager);
        layout = findViewById(R.id.layout_indicator);
        mBack = findViewById(R.id.slide_back);
        mNext = findViewById(R.id.slide_next);

        SlideAdapter adapter = new SlideAdapter(this);
        pager.setAdapter(adapter);
        setUpIndicator(adapter.getCount());
        setUpViewPager();

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(currentPage - 1);
            }
        });

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPage == 2)
                    startActivity(new Intent(SplashActivity.this, MainActivity.class).addFlags
                            (Intent.FLAG_ACTIVITY_CLEAR_TASK));
                else
                    pager.setCurrentItem(currentPage + 1);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("ResourceAsColor")
    void setUpIndicator(int size) {
        for (int i = 0; i < size; i++) {
            ImageView img = new ImageView(this);
            img.setBackgroundResource(R.drawable.ic_circle);
            img.setPadding(20, 20, 20, 20);
            if (i == 0)
                img.setBackgroundTintList(ColorStateList.valueOf(R.color.colorText));
            else
                img.setBackgroundTintList(ColorStateList.valueOf(R.color.colorTransparentWhite));
            layout.addView(img);
            mDots.add(img);
        }
    }

    void setUpViewPager() {
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {

            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @SuppressLint({"ResourceAsColor", "SetTextI18n"})
            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    mNext.setEnabled(true);
                    mBack.setVisibility(View.INVISIBLE);
                    mBack.setEnabled(false);
                    mNext.setText("Next");
                } else if (position == pager.getChildCount()) {
                    mNext.setEnabled(true);
                    mBack.setVisibility(View.VISIBLE);
                    mBack.setEnabled(true);
                    mNext.setText("Finish");
                    mBack.setText("Back");
                } else {
                    mNext.setEnabled(true);
                    mBack.setVisibility(View.VISIBLE);
                    mBack.setEnabled(true);
                    mNext.setText("Next");
                    mBack.setText("Back");
                }

                for (ImageView img : mDots) {
                    img.setBackgroundTintList(ColorStateList.valueOf(R.color
                            .colorTransparentWhite));
                }

                currentPage = position;
                mDots.get(position).getRootView().setBackgroundTintList(ColorStateList.valueOf(R.color
                        .colorAccent));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
