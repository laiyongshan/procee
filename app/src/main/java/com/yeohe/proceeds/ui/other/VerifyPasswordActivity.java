package com.yeohe.proceeds.ui.other;

import android.graphics.Color;
import android.os.Bundle;

import com.ccj.base.base.BaseActivity;
import com.yeohe.proceeds.R;

import qiu.niorgai.StatusBarCompat;

/**
 * Created by Administrator on 2017/10/27.
 */

public class VerifyPasswordActivity extends BaseActivity {
    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_verify_password);
        //add alpha to color
        StatusBarCompat.setStatusBarColor(this, Color.argb(255,00,00,00));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public void initView(){

    }

}
