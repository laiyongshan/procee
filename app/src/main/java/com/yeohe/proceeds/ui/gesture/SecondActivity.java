package com.yeohe.proceeds.ui.gesture;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.ccj.base.Constants;
import com.ccj.base.base.BaseActivity;
import com.leo.gesturelibray.enums.LockMode;
import com.leo.gesturelibray.view.CustomLockView;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrListener;
import com.yeohe.proceeds.R;
import com.yeohe.proceeds.utils.PasswordUtil;
import com.yeohe.proceeds.utils.SlidrUtil;

import butterknife.BindView;
import qiu.niorgai.StatusBarCompat;

import static com.leo.gesturelibray.enums.LockMode.CLEAR_PASSWORD;
import static com.leo.gesturelibray.enums.LockMode.SETTING_PASSWORD;

/**
 * Created by Administrator on 2017/10/17.
 */

public class SecondActivity extends BaseActivity implements SlidrListener, RippleView.OnRippleCompleteListener {

    @BindView(R.id.rv_back)
    TextView rvBack;
    @BindView(R.id.tv_text)
    TextView tvText;
    @BindView(R.id.lv_lock)
    CustomLockView lvLock;
    @BindView(R.id.tv_hint)
    TextView tvHint;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
        initData();
        Slidr.attach(this, SlidrUtil.getConfig(this, this));
    }

    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_second);
    }

    /**
     * 初始化View
     */
    @Override
    public void initView() {
        //显示绘制方向
        lvLock.setShow(true);
        //允许最大输入次数
        lvLock.setErrorNumber(3);
        //密码最少位数
        lvLock.setPasswordMinLength(4);
        //编辑密码或设置密码时，是否将密码保存到本地，配合setSaveLockKey使用
        lvLock.setSavePin(true);
        //保存密码Key
        lvLock.setSaveLockKey(com.ccj.base.Constants.PASS_KEY);
    }

    /**
     * 设置监听回调
     */
    public void initListener() {
        lvLock.setOnCompleteListener(onCompleteListener);
        rvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    /**
     * 初始化数据
     */
    public void initData() {
        //设置模式
        LockMode lockMode = (LockMode) getIntent().getSerializableExtra(Constants.INTENT_SECONDACTIVITY_KEY);
        setLockMode(lockMode);
    }


    /**
     * 密码输入模式
     */
    private void setLockMode(LockMode mode, String password, String msg) {
        lvLock.setMode(mode);
        lvLock.setErrorNumber(4);
//        lvLock.setClearPasssword(false);
        if (mode != SETTING_PASSWORD){
            tvHint.setText("请输入已经设置过的密码");
            lvLock.setOldPassword(password);
        } else {
            tvHint.setText("请输入要设置的密码");
        }
        tvText.setText(msg);
    }


    /**
     * 密码输入监听
     */
    CustomLockView.OnCompleteListener onCompleteListener = new CustomLockView.OnCompleteListener() {
        @Override
        public void onComplete(String password, int[] indexs) {
            tvHint.setText(getPassWordHint());
            finish();
        }

        @Override
        public void onError(String errorTimes) {
            tvHint.setText("密码错误，还可以输入" + errorTimes + "次");
        }

        @Override
        public void onPasswordIsShort(int passwordMinLength) {
            tvHint.setText("密码不能少于" + passwordMinLength + "个点");
        }

        @Override
        public void onAginInputPassword(LockMode mode, String password, int[] indexs) {
            tvHint.setText("请再次输入密码");
        }


        @Override
        public void onInputNewPassword() {
            tvHint.setText("请输入新密码");
        }

        @Override
        public void onEnteredPasswordsDiffer() {
            tvHint.setText("两次输入的密码不一致");
        }

        @Override
        public void onErrorNumberMany() {
            tvHint.setText("密码错误次数超过限制，不能再输入");
        }

    };


    /**
     * 密码相关操作完成回调提示
     */
    private String getPassWordHint() {
        String str = null;
        switch (lvLock.getMode()) {
            case SETTING_PASSWORD:
                str = "密码设置成功";
                break;
            case EDIT_PASSWORD:
                str = "密码修改成功";
                break;
            case VERIFY_PASSWORD:
                str = "密码正确";
                break;
            case CLEAR_PASSWORD:
                str = "密码已经清除";
                break;
        }
        return str;
    }

    /**
     * 设置解锁模式
     */
    private void setLockMode(LockMode mode) {
        String str = "";
        switch (mode) {
            case CLEAR_PASSWORD:
                str = "清除密码";
                setLockMode(CLEAR_PASSWORD, PasswordUtil.getPin(this), str);
                break;
            case EDIT_PASSWORD:
                str = "修改密码";
                setLockMode(LockMode.EDIT_PASSWORD, PasswordUtil.getPin(this), str);
                break;
            case SETTING_PASSWORD:
                str = "设置密码";
                setLockMode(SETTING_PASSWORD, null, str);
                break;
            case VERIFY_PASSWORD:
                str = "验证密码";
                setLockMode(LockMode.VERIFY_PASSWORD, PasswordUtil.getPin(this), str);
                break;
        }
        tvText.setText(str);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onComplete(RippleView rippleView) {
        onBackPressed();
    }

    @Override
    public void onSlideStateChanged(int state) {

    }

    @Override
    public void onSlideChange(float percent) {

    }

    @Override
    public void onSlideOpened() {

    }

    @Override
    public void onSlideClosed() {

    }
}
