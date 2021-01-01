package com.example.sattimcom;

import android.app.Application;

import com.huawei.hms.ads.HwAds;

public class AdSampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HwAds.init(this);
    }

}
