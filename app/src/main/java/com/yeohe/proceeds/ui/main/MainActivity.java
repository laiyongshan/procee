package com.yeohe.proceeds.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ccj.base.base.BaseActivity;
import com.ccj.base.utils.router.RouterConstants;
import com.yeohe.proceeds.R;
import com.yeohe.proceeds.ui.custom.MyViewPagerAdapter;
import com.yeohe.proceeds.ui.custom.SpecialTab;
import com.yeohe.proceeds.ui.fragments.mainfragment.MainFragment;
import com.yeohe.proceeds.ui.fragments.minefragment.MineFragment;
import com.yeohe.proceeds.ui.fragments.sharefragment.ShareFragment;
import com.yeohe.proceeds.utils.ToastUtil;

import java.util.ArrayList;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import qiu.niorgai.StatusBarCompat;

@Route(path = RouterConstants.MAIN_MOUDLE_ACTIVITY)
public class MainActivity extends BaseActivity implements MainContract.View{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PageNavigationView tab = (PageNavigationView) findViewById(R.id.tab);

        NavigationController navigationController = tab.custom()
                .addItem(newItem(R.drawable.ic_restore_gray_24dp,R.drawable.ic_restore_teal_24dp,"首页"))
                .addItem(newItem(R.drawable.ic_favorite_gray_24dp,R.drawable.ic_favorite_teal_24dp,"分享"))
                .addItem(newItem(R.drawable.ic_nearby_gray_24dp,R.drawable.ic_nearby_teal_24dp,"我的"))
                .build();


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyViewPagerAdapter(getFragments(),getSupportFragmentManager(),navigationController.getItemCount()));

        //自动适配ViewPager页面切换
        navigationController.setupWithViewPager(viewPager);

        //设置消息数
        navigationController.setMessageNumber(1,8);

        //设置显示小圆点
        navigationController.setHasMessage(0,true);
    }

    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_main);
        //add alpha to color
        StatusBarCompat.setStatusBarColor(this, Color.argb(255,00,00,00));
    }


    private ArrayList<Fragment> fragments=new ArrayList<Fragment>();
    private ArrayList<Fragment> getFragments(){
        fragments.add(new MainFragment());
        fragments.add(new ShareFragment());
        fragments.add(new MineFragment());
        return  fragments;
    }


    /**
     * 正常tab
     */
    private BaseTabItem newItem(int drawable, int checkedDrawable, String text){
        SpecialTab mainTab = new SpecialTab(this);
        mainTab.initialize(drawable,checkedDrawable,text);
        mainTab.setTextDefaultColor(0xFF888888);
        mainTab.setTextCheckedColor(0xFF009688);
        return mainTab;
    }


    //退出时的时间
    private long mExitTime;
    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            ToastUtil.getShortToastByString(MainActivity.this, "再按一次退出应用");
            mExitTime = System.currentTimeMillis();
        } else {
//            MyConfig.clearSharePre(this, "users");
            finish();
            System.exit(0);
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showExitDialog() {

    }
}