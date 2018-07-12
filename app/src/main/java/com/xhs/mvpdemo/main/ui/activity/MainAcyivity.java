package com.xhs.mvpdemo.main.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.xhs.mvpdemo.R;
import com.xhs.mvpdemo.base.BaseActivity;
import com.xhs.mvpdemo.main.presenter.MianPresenter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

/**
 * Created by 布鲁斯.李 on 2018/7/9.
 * Email:zp18595658325@163.com
 */

public class MainAcyivity extends BaseActivity implements IMainView{

    @InjectView(R.id.button2)
    Button button2;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @OnClick(R.id.button2)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.button2:
                MianPresenter presenter=new MianPresenter(this);
                presenter.take_photo();
                break;
        }
    }

    /**
     * 开启拍照
     */
    @Override
    public void start_take_photo() {
        Toast.makeText(this,"开启拍照",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void take_phone_denied() {
        Toast.makeText(this,"相机权限已被拒绝,请手动设置",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void take_phone_denied_one() {
        Toast.makeText(this,"本次请求相机权限已被拒绝",Toast.LENGTH_SHORT).show();
    }
}
