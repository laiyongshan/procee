package com.ccj.base.base;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ccj.base.AppManager;
import com.ccj.base.R;
import com.ccj.base.utils.DialogCreator;
import com.ccj.base.utils.NetUtils;
import com.ccj.base.utils.router.RouterConstants;
import org.greenrobot.eventbus.EventBus;
import java.util.List;
import cn.pedant.SweetAlert.SweetAlertDialog;


/**
 * base 来进行 toolbar dialog 初始化,activity栈的添加,删除等
 * Created by ccj on 2016/7/5.
 */
public class BaseActivity<T extends BasePresenter>
        extends AppCompatActivity implements BaseView {

    private static final String TAG = "BaseActivity";
    public T mPresenter;
    protected Dialog progressDialog;

    protected Toolbar toolbar;
    protected Context mContext;
    private int fragmentIndex = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        mContext = this;
        initDialog();

        if(!NetUtils.isConnected(mContext)){
            new SweetAlertDialog(mContext,SweetAlertDialog.ERROR_TYPE)
                    .setConfirmText("我知道了")
                    .setTitleText("网络连接失败")
                    .setContentText("请检查网络设置")
                    .show();

        };
    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.tool_bar_white));
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    /**
     * 资源释放
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }

    private void initDialog() {
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage(getResources().getString(R.string.show_loading_msg));
        progressDialog= DialogCreator.createLoadingDialog(this,"Loading.....");
        progressDialog.setCanceledOnTouchOutside(true);
    }


    public void showLoading() {
        progressDialog.show();
    }

    public void dismissLoading() {
        progressDialog.dismiss();
    }


    @Override
    public void initView() {

    }


    /**
     * 解决fragment onActivityResult不调用
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        FragmentManager fm = getSupportFragmentManager();
        //if (index != 0) {
        if (fm.getFragments() == null) {
            Log.w(TAG, "Activity result fragment fragmentIndex out of range: 0x"
                    + Integer.toHexString(requestCode));
            return;
        }
        for (int i = 0; i <fm.getFragments().size() ; i++) {
            Fragment frag = fm.getFragments().get(i);
            if (frag == null) {
                Log.w(TAG, "Activity result no fragment exists for fragmentIndex: 0x"
                        + Integer.toHexString(requestCode));
            } else {
                handleResult(frag, requestCode, resultCode, data);
            }
        }
        return;
    }

    /**
     * 递归调用，对所有子Fragement生效
     *
     * @param frag
     * @param requestCode
     * @param resultCode
     * @param data
     */
    private void handleResult(Fragment frag, int requestCode, int resultCode,
                              Intent data) {
        frag.onActivityResult(requestCode, resultCode, data);
        List<Fragment> frags = frag.getChildFragmentManager().getFragments();
        if (frags != null) {
            for (Fragment f : frags) {
                if (f != null)
                    handleResult(f, requestCode, resultCode, data);
            }
        }
    }
}
