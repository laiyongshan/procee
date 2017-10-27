package com.yeohe.proceeds.ui.fragments.minefragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.ccj.base.base.BaseFragment;
import com.yeohe.proceeds.R;
import com.yeohe.proceeds.adapter.ItemAdapter;
import com.yeohe.proceeds.ui.bankcard.MyBankCardActivity;
import com.yeohe.proceeds.ui.setting.SettingActivity;
import com.yeohe.proceeds.ui.gesture.GestureActivity;
import com.yeohe.proceeds.ui.login.LoginActivity;
import com.yeohe.proceeds.ui.other.HelpActivity;
import com.yeohe.proceeds.ui.register.RegisterActivity;
import com.yeohe.proceeds.widgets.ParallaxScollListView;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        ButterKnife.bind(this, view);

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

        final Class[] classes = new Class[]{
                RegisterActivity.class,
                GestureActivity.class,
                MyBankCardActivity.class,
                HelpActivity.class,
                SettingActivity.class
        };

        mListView.setAdapter(new ItemAdapter(getActivity(), titls, classes));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 1)
                    startActivity(new Intent(getActivity(), classes[position - 1]));
            }
        });

    }

}
