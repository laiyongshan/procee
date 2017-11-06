package com.yeohe.sdklibrary;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ccj.base.base.BaseActivity;
import com.ccj.base.utils.router.RouterConstants;
import com.ccj.base.utils.router.RouterUtils;

import butterknife.BindView;
import butterknife.BindViews;

/**
 * Created by Administrator on 2017/10/20.
 */

@Route(path = RouterConstants.NUMKEYBOART_ACTIVITY)
public class NumKeyBortActivity extends BaseActivity {

    private StringBuffer mInputString = new StringBuffer("");

        @BindViews({R2.id.button1,R2.id.button2,R2.id.button3,R2.id.button_back,
                R2.id.button4,R2.id.button5,R2.id.button6,R2.id.button_clear,
                R2.id.button7,R2.id.button8,R2.id.button9,R2.id.btnSure,
                R2.id.button0,R2.id.button_dot,R2.id.button00})
        Button[] btns;

        @BindView(R2.id.tvInputView)
        TextView tvInputView;




        @Override
        public void beforeInitView() {
                setContentView(R.layout.activity_numkeyboard);
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
                        NumKeyBortActivity.this.onNumberClicked(b.getText().toString(),b.getId());
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
        }else if(viewId==R.id.button_clear){//清除所有
            mInputString.delete(0, mInputString.length());
            tvInputView.setText("");
        }else if(viewId==R.id.btnSure){//确认
//            RouterUtils.navigation("MyTestActivity");
            startActivity(new Intent(NumKeyBortActivity.this,MyTestActivity.class));
        }else {
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
