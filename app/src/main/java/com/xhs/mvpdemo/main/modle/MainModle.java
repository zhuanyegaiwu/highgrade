package com.xhs.mvpdemo.main.modle;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;

import com.orhanobut.logger.Logger;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.xhs.mvpdemo.base.BaseActivity;
import com.xhs.mvpdemo.constant.Constant;

import java.io.File;

import io.reactivex.functions.Consumer;

/**
 * Created by 布鲁斯.李 on 2018/7/10.
 * Email:zp18595658325@163.com
 */

public class MainModle implements IMainModle{
    @Override
    public void accessibility(final BaseActivity activity, final CallBack callBack) {
        new RxPermissions(activity)
                .requestEach(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA)
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted) {
                            // 用户已经同意该权限
                            Logger.e(permission.name + " is granted.");
                            callBack.granted();
                            photograph(activity);
                        } else if (permission.shouldShowRequestPermissionRationale) {
                            // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                            Logger.e( permission.name + " is denied. More info should be provided.");
                            callBack.denied_one();
                        } else {
                            // 用户拒绝了该权限，并且选中『不再询问』
                            Logger.e( permission.name + " is denied.");
                            callBack.denied();
                        }
                    }
                });
    }

    @Override
    public void photograph(BaseActivity activity) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                + "/test/" + System.currentTimeMillis() + ".jpg");
        file.getParentFile().mkdirs();

        //改变Uri  com.xykj.customview.fileprovider注意和xml中的一致
        Uri uri = FileProvider.getUriForFile(activity, "com.xhs.mvpdemo.fileprovider", file);
        //添加权限
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        activity.startActivityForResult(intent, Constant.REQUEST_CAMERA_CODE);
    }
}
