package com.yeohe.proceeds.ui.other;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ccj.base.base.BaseActivity;
import com.yeohe.proceeds.R;

import butterknife.BindView;
import butterknife.BindViews;
import qiu.niorgai.StatusBarCompat;

/**
 * Created by Administrator on 2017/10/28.
 */

public class NumKeyBortActivity2 extends BaseActivity {

    private StringBuffer mInputString = new StringBuffer("");

    @BindViews({R.id.button1,R.id.button2,R.id.button3,R.id.button_back,
            R.id.button4,R.id.button5,R.id.button6,
            R.id.button7,R.id.button8,R.id.button9,
            R.id.button0,R.id.button_dot,})
    Button[] btns;

    @BindView(R.id.tvInputView)
    TextView tvInputView;

    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_numkeyboard2);
        //add alpha to color
        StatusBarCompat.setStatusBarColor(this, Color.argb(255,00,00,00));
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();
    }

    /*
          * 初始化控件
          * */
    private void initViews(){

        View.OnClickListener btnNumOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Button b = (Button)v;
                    NumKeyBortActivity2.this.onNumberClicked(b.getText().toString(),b.getId());
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        };


        for (Button btn:btns){
            btn.setOnClickListener(btnNumOnClickListener);
        }
    }


    private void onNumberClicked(String str,int viewId)
    {
        if(viewId==R.id.button_back){//回退一位
            int len = mInputString.length();
            if (len > 0)
            {
                mInputString.delete(mInputString.length() - 1, mInputString.length());
                tvInputView.setText(mInputString.toString());
            }
        }else if(viewId==R.id.aliPay_btn){//支付宝支付

        }else if(viewId==R.id.wechatPay_btn){//微信支付

        } else {
            int index = mInputString.indexOf(".");
            if (index < 0) {
                if (mInputString.length() < 10) {
                    mInputString.append(str);
                }
                tvInputView.setText(mInputString);
            } else {
                if (index + 1 == mInputString.length() || mInputString.length() == index + 2) {
                    if (!str.equalsIgnoreCase(".")){
                        mInputString.append(str);
                        tvInputView.setText(mInputString);
                    }
                }
            }
        }
    }

}
