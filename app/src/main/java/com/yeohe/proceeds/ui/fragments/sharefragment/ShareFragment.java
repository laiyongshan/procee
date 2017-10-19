package com.yeohe.proceeds.ui.fragments.sharefragment;

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
import com.yeohe.proceeds.ui.other.PasswordInputActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/17.
 */

public class ShareFragment extends BaseFragment {
    private View view;

    @BindView(R.id.btn1)
    Button btn1;

    @BindView(R.id.btn2)
    Button btn2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_share,null);
        ButterKnife.bind(this,view);

        return view;
    }

    @Override
    public void initView() {

    }


    @OnClick({R.id.btn1,R.id.btn2})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.btn1:
                startActivity(new Intent(getActivity(), GestureActivity.class));
                break;

            case R.id.btn2:
                startActivity(new Intent(getActivity(), PasswordInputActivity.class));
                break;
        }
    }
}
