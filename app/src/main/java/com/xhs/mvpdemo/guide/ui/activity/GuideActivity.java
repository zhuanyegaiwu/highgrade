package com.xhs.mvpdemo.guide.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.xhs.mvpdemo.R;
import com.xhs.mvpdemo.base.BaseActivity;
import com.xhs.mvpdemo.customview.ScrollLayout;
import com.xhs.mvpdemo.login.ui.activity.LoginActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by 布鲁斯.李 on 2018/7/9.
 * Email:zp18595658325@163.com
 */

public class GuideActivity extends BaseActivity implements ScrollLayout.OnViewChangeListener {
    @InjectView(R.id.scrollLayout)
    ScrollLayout scrollLayout;
    @InjectView(R.id.startBtn)
    Button startBtn;
    @InjectView(R.id.ll_dots)
    LinearLayout llDots;
    private List<ImageView> dots;


    @Override
    protected int getLayoutID() {
        return R.layout.activity_guide;
    }

    @Override
    public void initView() {
        scrollLayout.SetOnViewChangeListener(this);
        addPoints();
    }


    @Override
    public void OnViewChange(int position) {
        for (int i = 0; i < dots.size(); i++) {
            if (i == position) {
                dots.get(i).setImageResource(R.mipmap.start_circle);
            } else {
                dots.get(i).setImageResource(R.mipmap.start_circle_sel);
            }
        }
    }

    private void addPoints() {
        dots = new ArrayList<>();
        llDots.removeAllViews();
        dots.clear();
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(this);
            if (i == 0) {
                imageView.setImageResource(R.mipmap.start_circle);
            } else {
                imageView.setImageResource(R.mipmap.start_circle_sel);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 15;//px
            llDots.addView(imageView, params);
            dots.add(imageView);
        }
    }


    @OnClick(R.id.startBtn)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.startBtn:
                nextAtivity(LoginActivity.class);
                 break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        llDots.removeAllViews();
        dots.clear();
        dots=null;
    }
}
