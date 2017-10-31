package com.yeohe.proceeds.ui.qrcollection;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.ccj.base.base.BaseActivity;
import com.ccj.base.utils.router.RouterConstants;
import com.ccj.base.utils.router.RouterUtils;
import com.yeohe.proceeds.R;

import butterknife.BindView;
import qiu.niorgai.StatusBarCompat;

/**
 * Created by Administrator on 2017/10/28.
 * 扫码收款
 */

@Route(path = RouterConstants.QRCODE_MODULE_ACTIVITY)
public class QRPayActivity extends BaseActivity {

    @BindView(R.id.item_title2_layout)
    RelativeLayout item_title2_layout;

    @BindView(R.id.main_body_layout)
    LinearLayout main_body_layout;

    @BindView(R.id.title_tv2)
    TextView title_tv2;

    @BindView(R.id.pay_qr_code_img)
    ImageView pay_qr_code_img;


    @Autowired
    int qrStyle=0;

    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_qr_pay);

        RouterUtils.inject(this);
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        initView();
        showQrCode();
    }

    public void initView(){
        if(qrStyle==1) {
            item_title2_layout.setBackgroundColor(Color.argb(255, 38, 155, 38));
            main_body_layout.setBackgroundColor(Color.argb(255, 38, 155, 38));
            //add alpha to color
            StatusBarCompat.setStatusBarColor(this, Color.argb(255, 38, 155, 38));
            title_tv2.setText("微信扫码");
        }else if(qrStyle==2){
            item_title2_layout.setBackgroundColor(Color.argb(255, 37, 171, 238));
            main_body_layout.setBackgroundColor(Color.argb(255,37,171,238));
            //add alpha to color
            StatusBarCompat.setStatusBarColor(this, Color.argb(255,37,171,238));
            title_tv2.setText("支付宝扫码");
        }
    }


    //显示二维码
    public void showQrCode() {
        Glide.with(this)
                .load("http://upload-images.jianshu.io/upload_images/2972448-78cb561ab24f41c4.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240")
                .centerCrop()
                .into(pay_qr_code_img);
    }
}
