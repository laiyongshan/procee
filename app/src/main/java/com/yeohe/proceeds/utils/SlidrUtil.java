package com.yeohe.proceeds.utils;

import android.content.Context;
import android.graphics.Color;

import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrListener;
import com.r0adkll.slidr.model.SlidrPosition;
import com.yeohe.proceeds.R;

/**
 * Created by leo on 16/4/6.
 */
public class SlidrUtil {

    /**
     * 获取手势返回上一页库配置
     */
    public static SlidrConfig getConfig(Context context, SlidrListener slidrListener) {
        SlidrConfig config = new SlidrConfig.Builder()
                .primaryColor(Color.argb(220,70,196,147))
                .secondaryColor(Color.argb(220,48,63,159))
                .position(SlidrPosition.LEFT)
                .sensitivity(1f)
                .scrimColor(Color.BLACK)
                .scrimStartAlpha(0.8f)
                .scrimEndAlpha(0f)
                .velocityThreshold(2400)
                .distanceThreshold(0.25f)
                .listener(slidrListener)
                .edge(true)
                .edgeSize(0.18f)
                .build();
        return config;
    }
}
