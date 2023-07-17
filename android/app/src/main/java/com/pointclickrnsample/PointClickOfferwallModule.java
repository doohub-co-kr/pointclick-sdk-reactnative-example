package com.pointclickrnsample;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import kr.co.pointclick.sdk.offerwall.core.PointClickAd;

public class PointClickOfferwallModule extends ReactContextBaseJavaModule {

    public PointClickOfferwallModule(ReactApplicationContext context) {
        super(context);
    }

    @NonNull
    @Override
    public String getName() {
        return "PointClickOfferwallModule";
    }

    @ReactMethod
    public void showOfferwall(String title, int buttonTemplateIdx) {
        PointClickAd.showOfferwall(getReactApplicationContext().getCurrentActivity(), title, buttonTemplateIdx);
    }
}
