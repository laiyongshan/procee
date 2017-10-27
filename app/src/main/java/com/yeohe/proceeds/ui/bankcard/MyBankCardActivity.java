package com.yeohe.proceeds.ui.bankcard;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.ccj.base.base.BaseActivity;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.ScrollIndicatorView;
import com.shizhefei.view.indicator.slidebar.DrawableBar;
import com.shizhefei.view.indicator.slidebar.ScrollBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;
import com.yeohe.proceeds.R;

import qiu.niorgai.StatusBarCompat;

/**
 * Created by Administrator on 2017/10/27.
 */

public class MyBankCardActivity extends BaseActivity {

    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflate;
    private String[] names = {"信用卡", "结算卡"};
    private final Fragment[] FRAGMENTS={CardFragment1.newInstance(),CardFragment2.newInstance()};
    private ScrollIndicatorView scrollIndicatorView;
    private int unSelectTextColor;

    private TextView title_tv1;

    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_mybankcard);
        //add alpha to color
        StatusBarCompat.setStatusBarColor(this, Color.argb(255,00,00,00));
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        title_tv1= (TextView) findViewById(R.id.title_tv1);
        title_tv1.setText("我的银行卡");

        ViewPager viewPager = (ViewPager) findViewById(R.id.moretab_viewPager);
        scrollIndicatorView = (ScrollIndicatorView) findViewById(R.id.moretab_indicator);
        scrollIndicatorView.setBackgroundColor(Color.WHITE);
        scrollIndicatorView.setScrollBar(new DrawableBar(this, R.drawable.round_border_white_selector, ScrollBar.Gravity.BOTTOM) {
            @Override
            public int getHeight(int tabHeight) {
                return dipToPix(1);
            }

            @Override
            public int getWidth(int tabWidth) {
                return tabWidth - dipToPix(12);
            }
        });

        unSelectTextColor = Color.BLACK;
        // 设置滚动监听
        scrollIndicatorView.setOnTransitionListener(new OnTransitionTextListener().setColor(Color.argb(255,62,172,255), unSelectTextColor));

        viewPager.setOffscreenPageLimit(2);
        indicatorViewPager = new IndicatorViewPager(scrollIndicatorView, viewPager);
        inflate = LayoutInflater.from(getApplicationContext());
        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

        // 设置是否自动布局
        scrollIndicatorView.setSplitAuto(true);
    }


    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflate.inflate(R.layout.tab_top, container, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(names[position % names.length]);
            textView.setTextSize(18);
            int padding = dipToPix(10);
            textView.setPadding(padding, 0, padding, 0);
            return convertView;
        }

        @Override
        public Fragment getFragmentForPage(int position) {
            return FRAGMENTS[position];
        }

        @Override
        public int getItemPosition(Object object) {
            //这是ViewPager适配器的特点,有两个值 POSITION_NONE，POSITION_UNCHANGED，默认就是POSITION_UNCHANGED,
            // 表示数据没变化不用更新.notifyDataChange的时候重新调用getViewForPage
            return PagerAdapter.POSITION_NONE;
        }

    }

    ;

    /**
     * 根据dip值转化成px值
     *
     * @param dip
     * @return
     */
    private int dipToPix(float dip) {
        int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, getResources().getDisplayMetrics());
        return size;
    }


}
