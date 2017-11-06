package com.yeohe.sdklibrary;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ccj.base.base.BaseActivity;

import com.ccj.base.utils.router.RouterConstants;
import com.ccj.base.utils.router.RouterUtils;
import com.yeohe.sdklibrary.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/11/3.
 */
@Route(path = "/MyTestActivity/")
public class MyTestActivity extends BaseActivity {

    @Override
    public void beforeInitView() {
        setContentView(R2.layout.activity_mytest);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
