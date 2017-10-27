package com.yeohe.proceeds.ui.bankcard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yeohe.proceeds.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/10/27.
 */

public class CardFragment1 extends Fragment {

    private static final String ARG_POSITION = "position";


    private int position;

    public static CardFragment1 newInstance() {
        CardFragment1 f = new CardFragment1();
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
        View rootView = inflater.inflate(R.layout.fragment_card1,container,false);
        ButterKnife.bind(this, rootView);
        ViewCompat.setElevation(rootView, 50);
        return rootView;
    }

}
