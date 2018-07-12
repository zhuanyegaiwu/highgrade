package com.xhs.mvpdemo.login.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.xhs.mvpdemo.R;
import com.xhs.mvpdemo.base.BaseActivity;
import com.xhs.mvpdemo.login.presenter.LoginPresenter;
import com.xhs.mvpdemo.main.ui.activity.MainAcyivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by 布鲁斯.李 on 2018/7/9.
 * Email:zp18595658325@163.com
 */
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class LoginActivity extends BaseActivity implements ILoginView {
    @InjectView(R.id.editText1)
    EditText mEditText1;
    @InjectView(R.id.editText2)
    EditText mEditText2;
    @InjectView(R.id.button)
    Button mButton;
    @InjectView(R.id.progressBar)
    ProgressBar mProgressBar;

    /**
     * 初始化布局
     *
     * @return
     */
    @Override
    protected int getLayoutID() {
        return R.layout.activity_login;
    }

    /**
     * 初始化view
     */
    @Override
    public void initView() {


    }


    @Override
    public String getUserName() {
        return mEditText1.getText().toString().trim();
    }

    @Override
    public String getPaswd() {
        return mEditText2.getText().toString().trim();
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void loginSuccess() {
        nextAtivity(MainAcyivity.class);
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "连接失败,请检查网络", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginParameterError() {
        Toast.makeText(this, "参数错误,请重新输入", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginParameterEmpty() {
        Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
    }





    @OnClick({ R.id.button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                LoginPresenter presenter = new LoginPresenter(LoginActivity.this);
                presenter.login();
                break;
        }
    }
}
