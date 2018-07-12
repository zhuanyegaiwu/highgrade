package com.xhs.mvpdemo.login.modle.dao;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.ArrayMap;

import com.orhanobut.logger.Logger;
import com.xhs.mvpdemo.util.network.IRequestResultCallBack;
import com.xhs.mvpdemo.util.network.Network;

/**
 * Created by 布鲁斯.李 on 2018/7/9.
 * Email:zp18595658325@163.com
 */
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class LoginDao implements ILoginDao {

    @Override
    public void login(String name, String paswad, final CallBack callBack) {
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        arrayMap.put("phoneNumber", name);
        arrayMap.put("password", paswad);
        Network.postLoginData(arrayMap, new IRequestResultCallBack() {
            @Override
            public void onSuccess(Object entity) {
                callBack.onSuccess(entity);
            }

            @Override
            public void onFail() {
                callBack.onFail();
            }
        });
    }


}
