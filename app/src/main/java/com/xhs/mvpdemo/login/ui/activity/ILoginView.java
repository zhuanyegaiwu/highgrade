package com.xhs.mvpdemo.login.ui.activity;

/**
 * Created by 布鲁斯.李 on 2018/7/9.
 * Email:zp18595658325@163.com
 */

public interface ILoginView {


     String  getUserName();
     String  getPaswd();
     void  showLoading();
     void  hideLoading();
     void  loginSuccess();
     void  loginFail();
     void  loginParameterError();
     void  loginParameterEmpty();
}
