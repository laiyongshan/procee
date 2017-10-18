package com.yeohe.proceeds.ui.fragments.minefragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ccj.base.base.BaseFragment;
import com.yeohe.proceeds.R;
import com.yeohe.proceeds.adapter.MineAdapter;
import com.yeohe.proceeds.ui.gesture.GestureActivity;
import com.yeohe.proceeds.ui.gesture.SecondActivity;
import com.yeohe.proceeds.ui.login.LoginActivity;
import com.yeohe.proceeds.widgets.ParallaxScollListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/16.
 */

public class MineFragment extends BaseFragment {

    private View view;

    @BindView(R.id.layout_listview)
    ParallaxScollListView mListView;

    ImageView layout_header_image;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mine, null);
        ButterKnife.bind(this,view);

        initView();

        return view;
    }

    @Override
    public void initView() {
        View header = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_mine_header, null);
        layout_header_image = (ImageView) header.findViewById(R.id.layout_header_image);

        mListView.setZoomRatio(ParallaxScollListView.ZOOM_X2);
        mListView.setParallaxImageView(layout_header_image);
        mListView.addHeaderView(header);


        String[] titls = new String[]{
                        "资料补充",
                        "交易记录",
                        "我的银行卡",
                        "帮助中心",
                        "设置"
                };

        final Class[] classes=new Class[]{
                GestureActivity.class,
                GestureActivity.class,
                LoginActivity.class,
                LoginActivity.class,
                GestureActivity.class
        };

        mListView.setAdapter(new MineAdapter(getActivity(),titls,classes));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position>=1)
                        startActivity(new Intent(getActivity(),classes[position-1]));
            }
        });

    }

}
