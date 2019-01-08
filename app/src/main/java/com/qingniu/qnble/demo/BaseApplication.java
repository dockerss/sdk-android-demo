package com.qingniu.qnble.demo;

import android.app.Application;
import android.util.Log;

import com.qingniu.qnble.utils.QNLogUtils;
import com.yolanda.health.qnblesdk.listener.QNResultCallback;
import com.yolanda.health.qnblesdk.out.QNBleApi;

/**
 * @author: hekang
 * @description:
 * @date: 2018/03/21 20:20
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        String encryptPath = "file:///android_asset/123456789.qn";
        QNLogUtils.setLogEnable(BuildConfig.DEBUG);//Set log print switch, off by default
//        QNLogUtils.setWriteEnable(true);//Set the log write file switch, which is off by default.
        QNBleApi mQNBleApi = QNBleApi.getInstance(this);
        mQNBleApi.initSdk("123456789", encryptPath, new QNResultCallback() {
            @Override
            public void onResult(int code, String msg) {
                Log.d("BaseApplication", "Initialization file" + msg);
            }
        });
    }
}
