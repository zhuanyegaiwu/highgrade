package com.xhs.mvpdemo.base;

import android.app.Application;

import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by 布鲁斯.李 on 2018/7/9.
 * Email:zp18595658325@163.com
 */

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init("TAG");
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
