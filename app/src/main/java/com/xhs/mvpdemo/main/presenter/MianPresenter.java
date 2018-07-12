package com.xhs.mvpdemo.main.presenter;

import com.xhs.mvpdemo.base.BaseActivity;
import com.xhs.mvpdemo.main.modle.IMainModle;
import com.xhs.mvpdemo.main.modle.MainModle;
import com.xhs.mvpdemo.main.ui.activity.IMainView;

/**
 * Created by 布鲁斯.李 on 2018/7/10.
 * Email:zp18595658325@163.com
 */

public class MianPresenter implements IMainPresenter {

    private MainModle mainModle;
    private BaseActivity activity;
    private IMainView iMainView;

    public MianPresenter(BaseActivity activity) {
        this.iMainView= (IMainView) activity;
        this.activity = activity;
        mainModle = new MainModle();
    }

    @Override
    public void take_photo() {
        mainModle.accessibility(activity, new IMainModle.CallBack() {
            @Override
            public void granted() {
                iMainView.start_take_photo();
                mainModle.photograph(activity);
            }

            @Override
            public void denied() {
                iMainView.take_phone_denied();
            }

            @Override
            public void denied_one() {
                iMainView.take_phone_denied_one();
            }
        });
    }
}
