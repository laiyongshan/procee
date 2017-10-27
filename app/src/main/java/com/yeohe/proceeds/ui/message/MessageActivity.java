package com.yeohe.proceeds.ui.message;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ccj.base.base.BaseActivity;
import com.ccj.base.utils.router.RouterConstants;
import com.weavey.loading.lib.LoadingLayout;
import com.yeohe.proceeds.R;

import butterknife.BindView;
import qiu.niorgai.StatusBarCompat;

/**
 * Created by Administrator on 2017/10/24.
 */

@Route(path = RouterConstants.MESSAGE_ACTIVITY)
public class MessageActivity extends BaseActivity {

    @BindView(R.id.loading)
    LoadingLayout loading;

    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_message);
        StatusBarCompat.setStatusBarColor(this, Color.argb(255,00,00,00));
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loading.setEmptyText("没有数据");
        loading.setStatus(LoadingLayout.Error);
        loading.setLoadingPage(R.layout.define_loading_page).setOnReloadListener(new LoadingLayout.OnReloadListener(){
            @Override
            public void onReload(View v) {
                Toast.makeText(MessageActivity.this, "重试", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
