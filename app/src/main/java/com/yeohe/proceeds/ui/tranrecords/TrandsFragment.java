package com.yeohe.proceeds.ui.tranrecords;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ccj.base.base.BaseFragment;
import com.yeohe.proceeds.R;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/11/3.
 */

public class TrandsFragment extends BaseFragment {
    private static final String ARG_POSITION = "position";
    private RecyclerView mRecyclerView;

    private View notDataView;
    private View errorView;

    private int position;

    public static TrandsFragment newInstance() {
        TrandsFragment f = new TrandsFragment();
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
    public void initView() {

        notDataView = getActivity().getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) mRecyclerView.getParent(), false);
        notDataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
            }
        });

        errorView = getActivity().getLayoutInflater().inflate(R.layout.error_view, (ViewGroup) mRecyclerView.getParent(), false);
        errorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRefresh();
            }
        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_trands,container,false);
        ButterKnife.bind(this, rootView);
        ViewCompat.setElevation(rootView, 50);
        return rootView;
    }


    private void initAdapter() {


    }



    private boolean mError = true;
    private boolean mNoData = true;

    private void onRefresh() {
    }


}
