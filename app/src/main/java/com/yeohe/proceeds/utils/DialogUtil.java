package com.yeohe.proceeds.utils;

import android.app.Activity;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Administrator on 2017/9/21.
 */

public class DialogUtil {


    public static void showErrDialog(final Activity activity,String title,String err){
        new SweetAlertDialog(activity, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(""+title)
                .setContentText(""+err)
                .setConfirmText("确定")
                .show();
    }

}
