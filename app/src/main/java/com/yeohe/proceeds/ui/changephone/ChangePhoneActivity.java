package com.yeohe.proceeds.ui.changephone;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ccj.base.base.BaseActivity;
import com.yeohe.proceeds.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/10/24.
 */

public class ChangePhoneActivity extends BaseActivity {

    @BindView(R.id.title_tv1)
    TextView title_tv1;

    @BindView(R.id.back_ibtn)
    ImageButton back_ibtn;

    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_changephone);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    public void initView(){
        title_tv1.setText("修改登录手机");
    }


}
