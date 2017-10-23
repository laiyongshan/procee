package com.yeohe.proceeds.ui.register;

import com.ccj.base.base.BaseModel;
import com.ccj.base.base.BasePresenter;
import com.ccj.base.base.BaseView;

/**
 * Created by Administrator on 2017/10/23.
 */

public interface RegisterContract {

    interface View extends BaseView {
        void showProgress();
        void hideProgress();
        void showError(String error);
        void initViews();
    }


    interface Presenter extends BasePresenter{

    }


    interface Model extends BaseModel{

    }

}
