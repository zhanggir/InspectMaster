package com.wislight.inspect.main;

import android.app.Application;

import java.util.Map;

import cn.smssdk.SMSSDK;

/**
 * Created time : 2017/4/26 14:18.
 *
 * @author wislight
 */

public class MyApplication extends Application {
    // 用于存放倒计时时间
    public static Map<String, Long> map;

    @Override
    public void onCreate() {
        super.onCreate();
        SMSSDK.initSDK(this, "1dc474dd59148", "3d15b98023b5df8db34c208050a90e47");
    }
}
