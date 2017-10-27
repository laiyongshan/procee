package com.yeohe.proceeds.ui.register;

import android.os.Bundle;

import com.ccj.base.base.BaseActivity;
import com.yeohe.proceeds.R;

/**
 * Created by Administrator on 2017/10/24.
 */

public class RegisterSucessActivtiy extends BaseActivity {
    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_register_sucess);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

    //初始化控件
    public void initViews(){

    }
}
