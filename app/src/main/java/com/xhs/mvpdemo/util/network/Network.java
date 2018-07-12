// (c)2016 Flipboard Inc, All Rights Reserved.

package com.xhs.mvpdemo.util.network;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.ArrayMap;


import com.orhanobut.logger.Logger;
import com.xhs.mvpdemo.constant.Constant;


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class Network {

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJava2CallAdapterFactory.create();
    private static ApiService apiService;

    public  static ApiService getApiService() {
        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }
    /**
     * 登录
     * @param arrayMap
     * @param callBack
     */
    public static void postLoginData(ArrayMap<String, String> arrayMap, IRequestResultCallBack callBack){
        Observable<?extends Object> observable = getApiService().postLogin(arrayMap);
        request_network(observable,callBack);
    }


    /**
     * 发起网络请求
     * @param observable
     * @param callBack
     */
    public static void request_network(Observable<?extends Object> observable, final IRequestResultCallBack callBack) {

        observable .compose(Network.applySchedulers())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object entiry) throws Exception {
                        callBack.onSuccess(entiry);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callBack.onFail();
                    }
                });
    }




    private final static ObservableTransformer schedulersTransformer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(Observable upstream) {
            return ((Observable) upstream).subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());
        }


    };

    private static <T> ObservableTransformer<T, T> applySchedulers() {
        return (ObservableTransformer<T, T>) schedulersTransformer;
    }


}
