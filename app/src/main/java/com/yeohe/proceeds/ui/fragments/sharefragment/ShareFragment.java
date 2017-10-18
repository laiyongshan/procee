package com.yeohe.proceeds.ui.fragments.sharefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccj.base.base.BaseFragment;
import com.yeohe.proceeds.R;

/**
 * Created by Administrator on 2017/10/17.
 */

public class ShareFragment extends BaseFragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_share,null);


        return view;
    }

    @Override
    public void initView() {

    }
}
