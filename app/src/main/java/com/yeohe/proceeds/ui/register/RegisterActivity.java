package com.yeohe.proceeds.ui.register;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ccj.base.base.BaseActivity;
import com.ccj.base.utils.router.RouterConstants;
import com.ccj.base.utils.router.RouterUtils;
import com.flyco.roundview.RoundTextView;
import com.yeohe.proceeds.R;

import butterknife.BindView;
import butterknife.OnClick;
import qiu.niorgai.StatusBarCompat;

/**
 * 注册
 * Created by Administrator on 2017/10/23.
 */
@Route(path = RouterConstants.REGISTER_MODULE_ACTIVITY)
public class RegisterActivity extends BaseActivity<RegisterContract.Presenter> implements RegisterContract.View{

    @BindView(R.id.title_tv1)
    TextView title_tv1;

    @BindView(R.id.register_next_rtv)
    RoundTextView register_next_rtv;

    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_register);
        //add alpha to color
        StatusBarCompat.setStatusBarColor(this, Color.argb(255,00,00,00));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }


    @Override
    public void initViews(){
        title_tv1.setText("新用户注册");
    }

    /*
    * 点击事件
    * */
    @OnClick({R.id.register_next_rtv})
    public void click(View view){
        if(view.getId()==R.id.register_next_rtv){
            RouterUtils.navigation(RouterConstants.REGISTER_SETPSW_ACTIVITY);
        }
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
