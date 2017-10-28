package com.yeohe.proceeds.ui.other;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.ccj.base.base.BaseActivity;
import com.yeohe.proceeds.R;

import butterknife.BindView;
import qiu.niorgai.StatusBarCompat;

/**
 * Created by Administrator on 2017/10/24.
 */

public class HelpActivity extends BaseActivity {

    @BindView(R.id.title_tv1)
    TextView title_tv1;

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
}
