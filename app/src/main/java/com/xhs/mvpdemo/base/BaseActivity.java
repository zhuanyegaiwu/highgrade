package com.xhs.mvpdemo.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.xhs.mvpdemo.R;

import butterknife.ButterKnife;

/**
 * Created by 布鲁斯.李 on 2018/7/9.
 * Email:zp18595658325@163.com
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        ButterKnife.inject(this);
        initView();
    }

    /**
     * 初始化布局
     * @return
     */
    protected abstract int getLayoutID();

    /**
     * 初始化view
     */
    public abstract void initView();




    /**
     * 跳转页面
     */
    public void nextAtivity(Class clazz){
        startActivity(new Intent(this,clazz));
        finish();
    }
}
