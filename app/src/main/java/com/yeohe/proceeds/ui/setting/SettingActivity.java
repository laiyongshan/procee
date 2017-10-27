package com.yeohe.proceeds.ui.setting;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.ccj.base.base.BaseActivity;
import com.yeohe.proceeds.R;
import com.yeohe.proceeds.adapter.ItemAdapter;
import com.yeohe.proceeds.ui.changepassword.ChangePasswordActivity;
import com.yeohe.proceeds.ui.changephone.ChangePhoneActivity;
import com.yeohe.proceeds.ui.other.PasswordInputActivity;

import butterknife.BindView;
import qiu.niorgai.StatusBarCompat;

/**
 * Created by Administrator on 2017/10/27.
 */

public class SettingActivity extends BaseActivity {

    @BindView(R.id.back_ibtn)
    ImageButton back_ibtn;

    @BindView(R.id.title_tv1)
    TextView title_tv1;

    @BindView(R.id.setting_lv)
    ListView setting_lv;


    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_setting);
        //add alpha to color
        StatusBarCompat.setStatusBarColor(this, Color.argb(255, 00, 00, 00));
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }


    //初始化控件
    public void initView() {

        title_tv1.setText("设置");

        String[] titls = new String[]{
                "修改登录密码",
                "修改登录手机号",
                "修改支付密码",
                "设置支付密码",
        };

        final Class[] classes = new Class[]{
                ChangePasswordActivity.class,
                ChangePhoneActivity.class,
                PasswordInputActivity.class,
                PasswordInputActivity.class,
        };

        setting_lv.setAdapter(new ItemAdapter(SettingActivity.this, titls, classes));
        setting_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(SettingActivity.this, classes[position]));
            }
        });
    }
}
