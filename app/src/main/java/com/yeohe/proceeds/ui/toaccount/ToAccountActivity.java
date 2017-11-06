package com.yeohe.proceeds.ui.toaccount;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ccj.base.base.BaseActivity;
import com.yeohe.proceeds.R;
import com.yeohe.proceeds.utils.StringUtils;

import butterknife.BindView;
import qiu.niorgai.StatusBarCompat;

/**
 * Created by Administrator on 2017/11/4.
 */

public class ToAccountActivity extends BaseActivity {

    @BindView(R.id.title_tv2)
    TextView title_tv2;

    @BindView(R.id.back_ibtn)
    ImageButton back_ibtn;

    @BindView(R.id.bancard_num_tv)
    TextView bancard_num_tv;

    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_toaccount);
        //add alpha to color
        StatusBarCompat.setStatusBarColor(this, Color.argb(255,00,00,00));
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        setBackBtn(back_ibtn);
    }


    @Override
    public void initView() {
        super.initView();

        title_tv2.setText("到账详情");

        bancard_num_tv.setText(StringUtils.showBankCardNum("6225680323111261396"));

    }
}
