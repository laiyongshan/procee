package com.yeohe.proceeds.ui.guide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.ccj.base.utils.router.RouterConstants;
import com.ccj.base.utils.router.RouterUtils;
import com.yeohe.proceeds.R;
import com.yeohe.proceeds.ui.main.MainActivity;

import java.util.List;

import static com.yeohe.proceeds.AppStartActivity.PREF_KEY_FIRST_START;


public class GuidePagerAdapter extends PagerAdapter {

    // 界面列表
    private final List<View> views;
    private final Activity activity;
    private boolean isGo = true;//是否已经点击了立即体验

    private static final String SHAREDPREFERENCES_NAME = "first_pref";

    public GuidePagerAdapter(List<View> views, Activity activity) {
        this.views = views;
        this.activity = activity;
    }

    // 销毁arg1位置的界面
    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView(views.get(arg1));
    }

    @Override
    public void finishUpdate(View arg0) {
    }

    // 获得当前界面数
    @Override
    public int getCount() {
        if (views != null) {
            return views.size();
        }
        return 0;
    }

    // 初始化arg1位置的界面
    @Override
    public Object instantiateItem(View arg0, int arg1) {
        ((ViewPager) arg0).addView(views.get(arg1), 0);
        if (arg1 == views.size() - 1) {
            Button mStartImageButton = (Button) arg0.findViewById(R.id.btn_guide_enter);
            mStartImageButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 设置已经引导
                    if (isGo) {
                        isGo = false;
                        setGuided();
                        goHome();
                    }
                }
            });
        }
        return views.get(arg1);
    }

    private void goHome() {
        // 跳转
        RouterUtils.navigation(RouterConstants.MAIN_MOUDLE_ACTIVITY);
        activity.finish();
    }

    /**
     * method desc：设置已经引导过了，下次启动不用再次引导
     */
    private void setGuided() {
        PreferenceManager.getDefaultSharedPreferences(activity).edit()
                .putBoolean(PREF_KEY_FIRST_START, false)
                .apply();
    }

    // 判断是否由对象生成界面
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return (arg0 == arg1);
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void startUpdate(View arg0) {
    }

}
