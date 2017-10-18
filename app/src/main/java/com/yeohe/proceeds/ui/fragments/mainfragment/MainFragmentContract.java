package com.yeohe.proceeds.ui.fragments.mainfragment;

import com.ccj.base.base.BaseModel;
import com.ccj.base.base.BasePresenter;
import com.ccj.base.base.BaseView;

/**
 * Created by Administrator on 2017/10/18.
 */

public interface MainFragmentContract {

    interface View extends BaseView{
        void showProgress();
        void hideProgress();
        void showError(String error);

    }

    interface Prasenter extends BasePresenter{

    }

    interface Model extends BaseModel{

    }

}
