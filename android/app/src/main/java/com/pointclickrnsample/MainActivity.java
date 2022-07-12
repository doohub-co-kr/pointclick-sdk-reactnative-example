package com.pointclickrnsample;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactRootView;

import kr.co.pointclick.sdk.offerwall.core.PointClickAd;
import kr.co.pointclick.sdk.offerwall.core.events.PackageReceiver;
import kr.co.pointclick.sdk.offerwall.core.models.UserInfo;

public class MainActivity extends ReactActivity {

  private String placementUid = "d00e7d4e-29d5-4884-a409-c1e12b3ffbf7";
  private String pickerUid = "tester01";
  private PackageReceiver packageReceiver;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    /**
     * Register PacakgeReceiver(Required)
     */
    try {
      if(packageReceiver == null){
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_PACKAGE_ADDED);
        intentFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        intentFilter.addDataScheme("package");
        packageReceiver = new PackageReceiver();
        getApplicationContext().registerReceiver(packageReceiver, intentFilter);
        //TODO must call stopReceiver() when the application stops.
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    /**
     * Initialize PointClickAd(Required)
     */
    PointClickAd.init(placementUid, pickerUid);

    /**
     * Create UserInfo Object(Optional)
     */
    UserInfo userInfo = new UserInfo
            .UserInfoBuilder("testUser")
            .setAge("31")
            .setGender(0)
            .setPhoneNumber("01011112222")
            .build();
    /**
     * Set UserInfo(Optional)
     */
    PointClickAd.setUserInfo(userInfo);
  }

  @Override
  protected void onDestroy() {
    if(packageReceiver != null){
      // Unregister Installation Event
      getApplicationContext().unregisterReceiver(packageReceiver);
    }

    super.onDestroy();
  }

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "PointClickRNSample";
  }

  /**
   * Returns the instance of the {@link ReactActivityDelegate}. There the RootView is created and
   * you can specify the renderer you wish to use - the new renderer (Fabric) or the old renderer
   * (Paper).
   */
  @Override
  protected ReactActivityDelegate createReactActivityDelegate() {
    return new MainActivityDelegate(this, getMainComponentName());
  }

  public static class MainActivityDelegate extends ReactActivityDelegate {
    public MainActivityDelegate(ReactActivity activity, String mainComponentName) {
      super(activity, mainComponentName);
    }

    @Override
    protected ReactRootView createRootView() {
      ReactRootView reactRootView = new ReactRootView(getContext());
      // If you opted-in for the New Architecture, we enable the Fabric Renderer.
      reactRootView.setIsFabric(BuildConfig.IS_NEW_ARCHITECTURE_ENABLED);
      return reactRootView;
    }

    @Override
    protected boolean isConcurrentRootEnabled() {
      // If you opted-in for the New Architecture, we enable Concurrent Root (i.e. React 18).
      // More on this on https://reactjs.org/blog/2022/03/29/react-v18.html
      return BuildConfig.IS_NEW_ARCHITECTURE_ENABLED;
    }
  }
}
