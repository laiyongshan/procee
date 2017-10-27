package com.yeohe.proceeds.ui.register;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ccj.base.base.BaseActivity;
import com.ccj.base.utils.router.RouterConstants;
import com.yeohe.proceeds.R;

/**
 * 注册
 * Created by Administrator on 2017/10/23.
 */
@Route(path = RouterConstants.REGISTER_MODULE_ACTIVITY)
public class RegisterActivity extends BaseActivity<RegisterContract.Presenter> implements RegisterContract.View{
    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_register);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void initViews(){

    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String error) {

    }

}
