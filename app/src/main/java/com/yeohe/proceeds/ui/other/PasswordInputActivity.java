package com.yeohe.proceeds.ui.other;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.ccj.base.base.BaseActivity;
import com.flyco.roundview.RoundTextView;
import com.yeohe.proceeds.R;
import org.xutils.common.util.LogUtil;
import butterknife.BindView;
import butterknife.OnClick;
import qiu.niorgai.StatusBarCompat;

/**
 * Created by Administrator on 2017/10/19.
 */

public class PasswordInputActivity extends BaseActivity {

    @BindView(R.id.complete_rtv)
    RoundTextView complete_rtv;

    private  PasswordView pwdView;

    @Override
    public void beforeInitView() {
        pwdView = new PasswordView(this);
        setContentView(pwdView);
        //add alpha to color
        StatusBarCompat.setStatusBarColor(this, Color.argb(255,00,00,00));

        //添加密码输入完成的响应
        pwdView.setOnFinishInput(new OnPasswordInputFinish() {
            @Override
            public void inputFinish() {
                //输入完成后我们简单显示一下输入的密码
                Toast.makeText(PasswordInputActivity.this, pwdView.getStrPassword(), Toast.LENGTH_SHORT).show();
//                map.put("passwordpin",pwdView.getStrPassword());//输入的密码
            }
        });

        /**
         *  可以用自定义控件中暴露出来的cancelImageView方法，重新提供相应
         *  如果写了，会覆盖我们在自定义控件中提供的响应
         *  可以看到这里toast显示 "Biu Biu Biu"而不是"Cancel"*/
        pwdView.getCancelImageView().setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(PasswordInputActivity.this, "取消交易！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.complete_rtv})
    public void click(View view){
        switch (view.getId()){
            case R.id.complete_rtv:
                if(pwdView.getStrPassword().trim().length()<6){
                    Toast.makeText(PasswordInputActivity.this, "请输入6位完整密码", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(PasswordInputActivity.this, pwdView.getStrPassword(), Toast.LENGTH_LONG).show();
                }
                break;
        }
    }


//    /**
//     * 返回键点击事件
//     * */
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if(keyCode==KeyEvent.KEYCODE_BACK&&event.getRepeatCount()==0){
//
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }

}
