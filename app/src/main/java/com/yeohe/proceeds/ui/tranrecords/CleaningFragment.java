package com.yeohe.proceeds.ui.tranrecords;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccj.base.base.BaseFragment;
import com.yeohe.proceeds.R;
import com.yeohe.proceeds.ui.bankcard.CardFragment1;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/3.
 */

public class CleaningFragment extends BaseFragment {

    private static final String ARG_POSITION = "position";


    private int position;

    public static CleaningFragment newInstance() {
        CleaningFragment f = new CleaningFragment();
        Bundle b = new Bundle();
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cleaning,container,false);
        ButterKnife.bind(this, rootView);
        ViewCompat.setElevation(rootView, 50);
        return rootView;
    }

    @Override
    public void initView() {

    }
}
