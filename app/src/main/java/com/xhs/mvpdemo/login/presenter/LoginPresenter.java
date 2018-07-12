package com.xhs.mvpdemo.login.presenter;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;

import com.xhs.mvpdemo.login.modle.dao.ILoginDao;
import com.xhs.mvpdemo.login.modle.dao.LoginDao;
import com.xhs.mvpdemo.login.modle.entity.LoginSuccessEntity;
import com.xhs.mvpdemo.login.ui.activity.ILoginView;

/**
 * Created by 布鲁斯.李 on 2018/7/9.
 * Email:zp18595658325@163.com
 */
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class LoginPresenter implements ILoginPresenter {

    private  LoginDao loginDao;
    private  ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView=loginView;
        this.loginDao = new LoginDao();
    }

    /**
     * 登录
     */

    @Override
    public void login() {
        String userName = loginView.getUserName();
        String paswd = loginView.getPaswd();
        if (TextUtils.isEmpty(userName)||TextUtils.isEmpty(paswd)){
            loginView.loginParameterEmpty();
            return;
        }
        loginView.showLoading();
        loginDao.login(userName,paswd, new ILoginDao.CallBack() {
            @Override
            public void onSuccess( Object object) {
                LoginSuccessEntity entity= (LoginSuccessEntity) object;
                loginView.hideLoading();
                if (entity!=null&&entity.isSuccess()){
                    loginView.loginSuccess();
                }else {
                    loginView.loginParameterError();
                }
            }
            @Override
            public void onFail() {
                loginView.hideLoading();
                loginView.loginFail();
            }
        });
    }
}
