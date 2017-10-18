package com.yeohe.proceeds;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

import com.ccj.base.base.BaseActivity;
import com.ccj.base.utils.router.RouterConstants;
import com.ccj.base.utils.router.RouterUtils;
import com.yeohe.proceeds.ui.guide.GuideActivity;

import qiu.niorgai.StatusBarCompat;

/**
 * Created by Administrator on 2017/9/30.
 */

public class AppStartActivity extends BaseActivity {

    public static final String PREF_KEY_FIRST_START = "com.yeohe.proceeds.PREF_KEY_FIRST_START";
    private  boolean isFirstStart;

    private final Handler waitHandler = new Handler();
    private final Runnable waitCallback = new Runnable() {
        @Override
        public void run() {
            if(true) {
                Intent intent = new Intent(AppStartActivity.this, GuideActivity.class);
                startActivity(intent);
                finish();
            }else{
                RouterUtils.navigation(RouterConstants.MAIN_MOUDLE_ACTIVITY);
                finish();
            }
        }
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Fake wait 2s to simulate some initialization on cold start (never do this in production!)

        isFirstStart= PreferenceManager.getDefaultSharedPreferences(AppStartActivity.this)
                .getBoolean(PREF_KEY_FIRST_START, true);

        waitHandler.postDelayed(waitCallback, 3000);

    }

    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_appstart);
    }

    @Override
    protected void onDestroy() {
        waitHandler.removeCallbacks(waitCallback);
        super.onDestroy();
    }

}
