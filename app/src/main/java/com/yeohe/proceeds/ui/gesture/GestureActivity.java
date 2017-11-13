package com.yeohe.proceeds.ui.gesture;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ccj.base.base.BaseActivity;
import com.ccj.base.Constants;
import com.leo.gesturelibray.enums.LockMode;
import com.leo.gesturelibray.util.StringUtils;
import com.yeohe.proceeds.R;
import com.yeohe.proceeds.utils.PasswordUtil;
import com.yeohe.proceeds.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;
import qiu.niorgai.StatusBarCompat;

/**
 * Created by Administrator on 2017/10/17.
 */

//
public class GestureActivity extends BaseActivity{

    @BindView(R.id.rv_setting)
    Button rv_setting;

    @BindView(R.id.rv_clear)
    Button rv_clear;

    @BindView(R.id.rv_edit)
    Button rv_edit;

    @BindView(R.id.rv_verify)
    Button rv_verify;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_gesture);
    }

    @OnClick({R.id.rv_verify,R.id.rv_edit,R.id.rv_clear,R.id.rv_setting})
    public void click(View view){
        switch (view.getId()){
            case R.id.rv_clear:
                actionSecondActivity(LockMode.CLEAR_PASSWORD);
                break;

            case R.id.rv_edit:
                actionSecondActivity(LockMode.EDIT_PASSWORD);
                break;

            case R.id.rv_setting:
                actionSecondActivity(LockMode.SETTING_PASSWORD);
                break;

            case R.id.rv_verify:
                actionSecondActivity(LockMode.VERIFY_PASSWORD);
                break;
        }
    }


    /**
     * 跳转到密码处理界面
     */
    private void actionSecondActivity(LockMode mode) {
        if (mode != LockMode.SETTING_PASSWORD) {
            ToastUtil.showMessage(this,PasswordUtil.getPin(this));
            if (StringUtils.isEmpty(PasswordUtil.getPin(this))) {
                Toast.makeText(getBaseContext(), "请先设置密码", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(Constants.INTENT_SECONDACTIVITY_KEY, mode);
        startActivity(intent);
    }

}
