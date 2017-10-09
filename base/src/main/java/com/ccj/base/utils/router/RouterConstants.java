package com.ccj.base.utils.router;
/**
 * Created by chenchangjun on 17/8/9.
 */


public final class RouterConstants {

    /**
     * main 主页面
     */
    public static final String MAIN_MODULE_NAME ="/main/";
    public static final String MAIN_MOUDLE_ACTIVITY = MAIN_MODULE_NAME +"MainActivity";


    /**
     * login 登录界面
     * */
    public static final String LOGIN_MODULE_NAME="/login/";
    public static final String LOGIN_MOUDLE_ACTIVITY=LOGIN_MODULE_NAME+"LoginActivity";


    /**
     * addcar 添加车辆信息界面
     * */
    public static final String ADDCAR_MODULE_NAME="/addcar/";
    public static final String ADDCAR_MOUDLE_ACTIVITY=ADDCAR_MODULE_NAME+"AddCarActivity";


    /**
     * annual 年检界面
     * */
    public static final String ANNUAL_MODULE_NAME="/annual/";
    public static final String ANNUAL_MOUDLE_ACTIVITY=ANNUAL_MODULE_NAME+"AnnualActivity";

    /*
    * order 订单界面
    * */
    public static final String ORDER_MODULE_NAME="/order/";
    public static final String ORDERLIST_MOUDLE_ACTIVITY=ORDER_MODULE_NAME+"OrderListActivity";
    public static final String ORDERDETAIL_MOUDEL_ACTIVITY=ORDER_MODULE_NAME+"OrderDetailActivity";
    public static final String ORDER_STYLE_MOUDEL_ACTIVITY=ORDER_MODULE_NAME+"OrderStyleActivity";


    /*
    * pay 支付界面
    * */
    public static final String PAY_MODULE_NAME="/pay/";
    public static final String PAY_MOUDLE_ACTIVITY=PAY_MODULE_NAME+"PayActivity";
    public static final String PAY_FAIL_ACTIVITY=PAY_MODULE_NAME+"PayFailActivity";
    public static final String PAY_SUCESS_ACTIVITY=PAY_MODULE_NAME+"PaySucessActivity";

    /**
     * query 违章查询界面
     * */
    public static final String QUERY_MODULE_NAME="/query/";
    public static final String QUERY_MOUDLE_ACTIVITY=QUERY_MODULE_NAME+"QueryActivity";
    public static final String QUERY_MOUDLE_DETAIL_ACIVITY=QUERY_MODULE_NAME+"IllegalDetailActivity";

    /*
    * 启动页和引导页
    * */
    public static final String APP_START_MODULE="/appstart/";
    public static final String APP_START_ACTIVITY=APP_START_MODULE+"AppAtartActivity";
    public static final String APP_GUIDE_ACTIVITY=APP_START_MODULE+"AppGuideActivity";

}
