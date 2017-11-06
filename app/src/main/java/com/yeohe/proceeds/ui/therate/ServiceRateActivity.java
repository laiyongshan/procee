package com.yeohe.proceeds.ui.therate;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ccj.base.base.BaseActivity;
import com.ccj.base.utils.router.RouterConstants;
import com.yeohe.proceeds.R;
import com.yeohe.proceeds.adapter.RateAdapter;
import com.yeohe.proceeds.bean.Rate;
import com.yeohe.proceeds.utils.MyDividerItemDecoration;
import com.yeohe.proceeds.utils.RecycleViewDivider;

import java.util.ArrayList;

import qiu.niorgai.StatusBarCompat;

/**
 * Created by Administrator on 2017/11/6.
 */

@Route(path= RouterConstants.SERVICE_RATE_ACTIVITY)
public class ServiceRateActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Rate> beans=new ArrayList<Rate>();

    @Override
    public void beforeInitView() {
        setContentView(R.layout.activity_service_rate);
        //add alpha to color
        StatusBarCompat.setStatusBarColor(this, Color.argb(255,00,00,00));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initData();
    }


    public void initView(){
        mRecyclerView= (RecyclerView) findViewById(R.id.rate_rv);
        mAdapter=new RateAdapter(getData());
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new RecycleViewDivider(
                mContext, LinearLayoutManager.VERTICAL, 40, Color.argb(255,180,180,180)));
//        mRecyclerView.addItemDecoration(new MyDividerItemDecoration(this,LinearLayoutManager.VERTICAL,50));
    }

    private void initData(){
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    private ArrayList<Rate> getData(){

        Rate bean;

        for(int i=0;i<3;i++){
            bean=new Rate();
            bean.setName("T0提現");
            bean.setCardStyle("結算卡");
            bean.setRate("0.3%");
            bean.setTime("不限");
            beans.add(bean);
        }

        return beans;
    }
}
