package com.yeohe.proceeds.ui.login;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ccj.base.base.BaseActivity;
import com.ccj.base.utils.router.RouterConstants;
import com.ccj.base.utils.router.RouterUtils;
import com.yeohe.proceeds.R;

import butterknife.BindView;
import butterknife.OnClick;
import qiu.niorgai.StatusBarCompat;


@Route(path = RouterConstants.LOGIN_MOUDLE_ACTIVITY)
public class LoginActivity extends BaseActivity{

    @BindView(R.id.navigat_regist_tv)
    TextView navigat_regist_tv;//注册

    @BindView(R.id.forget_password_tv)
    TextView forget_password_tv;//忘记密码

    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_login);
        StatusBarCompat.setStatusBarColor(this, Color.argb(255,00,00,00));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @OnClick({R.id.navigat_regist_tv,R.id.forget_password_tv})
    public void click(View view){
        switch (view.getId()){
            case R.id.forget_password_tv:
                RouterUtils.navigation(RouterConstants.FORGET_PASSWORD_ACTIVITY);
                break;

            case R.id.navigat_regist_tv:
                RouterUtils.navigation(RouterConstants.REGISTER_MODULE_ACTIVITY);
                break;
        }
    }

}