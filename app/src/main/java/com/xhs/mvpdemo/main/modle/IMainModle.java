package com.xhs.mvpdemo.main.modle;

import com.xhs.mvpdemo.base.BaseActivity;

/**
 * Created by 布鲁斯.李 on 2018/7/10.
 * Email:zp18595658325@163.com
 */

public interface IMainModle {

    void accessibility(BaseActivity activity,CallBack callBack);
    void photograph(BaseActivity activity);

     interface CallBack{
        void granted();
        void denied();
        void denied_one();
    }
}
