package com.yeohe.proceeds.ui.register;

import android.content.Context;

/**
 * Created by Administrator on 2017/10/23.
 */

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View registerView;
    private Context context;

    public RegisterPresenter (Context context,RegisterContract.View registerView){
        this.context=context;
        this.registerView=registerView;
    }

    @Override
    public void start() {

    }

    @Override
    public void onDestroy() {

    }
}
