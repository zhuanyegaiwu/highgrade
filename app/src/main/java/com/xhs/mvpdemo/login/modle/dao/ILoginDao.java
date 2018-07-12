package com.xhs.mvpdemo.login.modle.dao;

/**
 * Created by 布鲁斯.李 on 2018/7/9.
 * Email:zp18595658325@163.com
 */

public interface ILoginDao {
    void login(String name,String paswad,CallBack callBack);
     interface CallBack{
         void onSuccess(Object object);
         void onFail();
    }
}
