package com.yeohe.proceeds.ui.fragments.sharefragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.bumptech.glide.Glide;
import com.ccj.base.base.BaseFragment;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.yeohe.proceeds.R;
import com.yeohe.proceeds.ui.gesture.GestureActivity;
import com.yeohe.proceeds.ui.login.LoginActivity;
import com.yeohe.proceeds.ui.other.NumKeyBortActivity;
import com.yeohe.proceeds.ui.other.PasswordInputActivity;
import com.yeohe.proceeds.ui.register.RegisterActivity;
import com.yeohe.proceeds.utils.ToastUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jiguang.share.android.api.JShareInterface;
import cn.jiguang.share.android.api.PlatActionListener;
import cn.jiguang.share.android.api.Platform;
import cn.jiguang.share.android.api.ShareParams;
import cn.jiguang.share.qqmodel.QQ;
import cn.jiguang.share.wechat.Wechat;
import cn.jiguang.share.wechat.WechatMoments;
import io.reactivex.disposables.Disposable;
import io.reactivex.Observer;

/**
 * Created by Administrator on 2017/10/17.
 */

public class ShareFragment extends BaseFragment {
    private View view;

//    @BindView(R.id.btn1)
//    Button btn1;
//
//    @BindView(R.id.btn2)
//    Button btn2;
//
//    @BindView(R.id.btn3)
//    Button btn3;
//
//    @BindView(R.id.btn4)
//    Button btn4;
//
//    @BindView(R.id.btn5)
//    Button btn5;

    @BindView(R.id.qr_iv)
    ImageView qr_iv;

    @BindView(R.id.back_ibtn)
    ImageButton back_ibtn;

    @BindView(R.id.title_tv2)
    TextView title_tv2;

    @BindView(R.id.item_title2_layout)
    RelativeLayout item_title2_layout;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String toastMsg = (String) msg.obj;
            Toast.makeText(getActivity(),toastMsg,Toast.LENGTH_SHORT).show();
            if(progressDialog!=null&&progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }
    };


    private PlatActionListener mPlatActionListener = new PlatActionListener() {
        @Override
        public void onComplete(Platform platform, int action, HashMap<String, Object> data) {
            if(handler != null) {
                Message message = handler.obtainMessage();
                message.obj = "分享成功";
                handler.sendMessage(message);
            }
        }

        @Override
        public void onError(Platform platform, int action, int errorCode, Throwable error) {
            if(handler != null) {
                Message message = handler.obtainMessage();
                message.obj = "分享失败:" + (error != null ? error.getMessage() : "")+errorCode+JShareInterface.isClientValid(QQ.Name);
                Toast.makeText(getActivity(),JShareInterface.getPlatformList().size()+"",Toast.LENGTH_LONG).show();
                handler.sendMessage(message);
            }
        }

        @Override
        public void onCancel(Platform platform, int action) {
            if(handler != null) {
                Message message = handler.obtainMessage();
                message.obj = "分享取消";
                handler.sendMessage(message);
            }
        }
    };


    @BindView(R.id.sharetoqq_tv)
    TextView sharetoqq_tv;//分享到QQ

    @BindView(R.id.sharetowechat_tv)
    TextView sharetowechat_tv;//分享到微信

    @BindView(R.id.sharetomoment_tv)
    TextView sharetomoment_tv;//分享到朋友圈


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_share, null);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void initView() {
        Glide.with(this)
                .load("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3617794757,1003488120&fm=27&gp=0.jpg")
                .centerCrop()
                .into(qr_iv);

        item_title2_layout.setBackgroundColor(getActivity().getResources().getColor(R.color.colorPrimary));
        back_ibtn.setVisibility(View.GONE);
        title_tv2.setText("分享");
        title_tv2.setTextColor(getActivity().getResources().getColor(R.color.white));


        //qq分享
        sharetoqq_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareParams shareParams = new ShareParams();
                shareParams.setShareType(Platform.SHARE_WEBPAGE);
                shareParams.setTitle("test");
                shareParams.setText("这是一个分享测试");
                shareParams.setUrl("http://www.baidu.com/");
                shareParams.setImageUrl("http://inews.gtimg.com/newsapp_bt/0/876781763/1000");
                JShareInterface.share(QQ.Name, shareParams, mPlatActionListener);
//                progressDialog.show();
            }
        });


        //微信分享
        sharetowechat_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareParams shareParams = new ShareParams();
                shareParams.setShareType(Platform.SHARE_WEBPAGE);
                shareParams.setTitle("test");
                shareParams.setText("这是一个分享测试");
                shareParams.setUrl("http://www.baidu.com/");
                shareParams.setImageUrl("http://inews.gtimg.com/newsapp_bt/0/876781763/1000");
                JShareInterface.share(Wechat.Name, shareParams, mPlatActionListener);
            }
        });

        //朋友圈分享
        sharetomoment_tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ShareParams shareParams = new ShareParams();
                shareParams.setTitle("test");
                shareParams.setText("这是一个分享测试");
                shareParams.setShareType(Platform.SHARE_WEBPAGE);
                shareParams.setUrl("http://www.baidu.com/");//必须
                shareParams.setImageUrl("http://inews.gtimg.com/newsapp_bt/0/876781763/1000");
                JShareInterface.share(WechatMoments.Name, shareParams, mPlatActionListener);
            }
        });

    }

    private static final int REQUEST_CODE_CHOOSE = 23;

//    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5})
//    public void OnClick(View view) {
//        switch (view.getId()) {
//            case R.id.btn1:
//                startActivity(new Intent(getActivity(), GestureActivity.class));
//                break;
//
//            case R.id.btn2:
//                startActivity(new Intent(getActivity(), PasswordInputActivity.class));
//                break;
//
//            case R.id.btn3:
//                //时间选择器
//                TimePickerView pvTime = new TimePickerView.Builder(getActivity(), new TimePickerView.OnTimeSelectListener() {
//                    @Override
//                    public void onTimeSelect(Date date, View v) {//选中事件回调
//                        ToastUtil.showMessage(getContext(), getTime(date));
//                    }
//                }).setType(new boolean[]{true, true, true, false, false, false})
//                        .build();
//                pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
//                pvTime.show();
//                break;
//
//            case R.id.btn4:
//
//                startActivity(new Intent(getActivity(), NumKeyBortActivity.class));
//
//                break;
//
//            case R.id.btn5:
//
//                startActivity(new Intent(getActivity(), LoginActivity.class));
//
//                break;
//        }
//    }


    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}
