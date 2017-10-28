package com.yeohe.proceeds.ui.other;

import android.os.Bundle;
import android.widget.TextView;

import com.ccj.base.base.BaseActivity;
import com.yeohe.proceeds.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/10/28.
 */

public class VerifyCodeActivity extends BaseActivity {

    @BindView(R.id.title_tv1)
    TextView title_tv1;

    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_verify_code);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void initView(){
        title_tv1.setText("验证码校验");
    }

}
