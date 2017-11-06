package com.yeohe.proceeds.ui.other;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ccj.base.base.BaseActivity;
import com.ccj.base.utils.router.RouterConstants;
import com.ccj.base.utils.router.RouterUtils;
import com.yeohe.proceeds.R;

import butterknife.BindView;
import butterknife.OnClick;
import qiu.niorgai.StatusBarCompat;

/**
 * Created by Administrator on 2017/10/24.
 */

public class HelpActivity extends BaseActivity {

    @BindView(R.id.title_tv1)
    TextView title_tv1;

    @BindView(R.id.trand_layout)
    RelativeLayout trand_layout;

    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_help);
        //add alpha to color
        StatusBarCompat.setStatusBarColor(this, Color.argb(255,00,00,00));
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

    }

    public void initView(){
        title_tv1.setText("帮助中心");
    }


    /*
    * 点击事件
    * */
    @OnClick({R.id.trand_layout})
    public void click(View view){
        switch (view.getId()){
            case R.id.trand_layout:
                RouterUtils.navigation(RouterConstants.SERVICE_RATE_ACTIVITY);
                break;
        }
    }
}
