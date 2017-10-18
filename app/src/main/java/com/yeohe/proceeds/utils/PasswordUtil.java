package com.yeohe.proceeds.utils;

import android.content.Context;

import com.ccj.base.Constants;
import com.leo.gesturelibray.util.ConfigUtil;

/**
 * Created by leo on 16/4/5.
 */
public class PasswordUtil {

    /**
     * 获取设置过的密码
     */
    public static String getPin(Context context) {
        String password = ConfigUtil.getInstance(context).getString(Constants.PASS_KEY);
        return password;
    }
}
