package com.yeohe.proceeds.ui.main;

import com.ccj.base.base.BasePresenter;
import com.ccj.base.base.BaseView;

/**
 * Created by Administrator on 2017/8/30.
 */

public interface MainContract {

    interface View extends BaseView {
        void showProgress();
        void hideProgress();
        void showError(String error);

        void showExitDialog();
    }

    interface Presenter extends BasePresenter {
        void onDestroy();
    }

    interface Model{

    }


}
