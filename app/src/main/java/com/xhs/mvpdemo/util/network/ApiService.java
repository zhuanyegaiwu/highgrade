package com.xhs.mvpdemo.util.network;

import android.util.ArrayMap;


import com.xhs.mvpdemo.constant.Constant;
import com.xhs.mvpdemo.login.modle.entity.LoginSuccessEntity;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 作者: 布鲁斯.李 on 2018/6/14 10 23
 * 邮箱: lzp_lizhanpeng@163.com
 */

public interface ApiService {

    //用户登录
    @FormUrlEncoded
    @POST(Constant.LOGIN_URL)
    Observable<LoginSuccessEntity> postLogin(@FieldMap ArrayMap<String, String> params);



}
