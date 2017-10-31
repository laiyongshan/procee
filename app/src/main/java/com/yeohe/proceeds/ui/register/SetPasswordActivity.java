package com.yeohe.proceeds.ui.register;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ccj.base.base.BaseActivity;
import com.ccj.base.utils.router.RouterConstants;
import com.yeohe.proceeds.R;

import butterknife.BindView;
import qiu.niorgai.StatusBarCompat;

/**
 * Created by Administrator on 2017/10/31.
 */
@Route(path = RouterConstants.REGISTER_SETPSW_ACTIVITY)
public class SetPasswordActivity extends BaseActivity {

    @BindView(R.id.title_tv1)
    TextView title_tv1;


    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_setpassword);
        //add alpha to color
        StatusBarCompat.setStatusBarColor(this, Color.argb(255,00,00,00));
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    public void initView(){
        title_tv1.setText("设置登录密码");
    }

}
