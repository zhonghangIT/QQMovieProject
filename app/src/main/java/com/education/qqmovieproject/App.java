package com.education.qqmovieproject;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by zhonghang on 16/8/3.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //监听内存泄漏
        LeakCanary.install(this);
    }
}
