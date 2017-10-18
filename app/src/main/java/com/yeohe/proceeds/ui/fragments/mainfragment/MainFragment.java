package com.yeohe.proceeds.ui.fragments.mainfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ccj.base.base.BaseFragment;
import com.yeohe.proceeds.R;
import com.yeohe.proceeds.ui.gesture.GestureActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/16.
 */

public class MainFragment extends BaseFragment {
    private View view;

    @BindView(R.id.btn1)
    Button btn1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_main,null);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick({R.id.btn1})
    public void click(View v){
        switch (v.getId()){
            case R.id.btn1:
                startActivity(new Intent(getActivity(), GestureActivity.class));
                break;
        }
    }

    @Override
    public void initView() {

    }
}
