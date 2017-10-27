package com.yeohe.proceeds.ui.changepassword;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ccj.base.base.BaseActivity;
import com.ccj.base.utils.router.RouterConstants;
import com.yeohe.proceeds.R;

/**
 * Created by Administrator on 2017/10/24.
 */
@Route(path = RouterConstants.FORGET_PASSWORD_ACTIVITY)
public class ChangePasswordActivity extends BaseActivity {
    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_change_password);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
