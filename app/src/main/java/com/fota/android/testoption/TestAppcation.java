package com.fota.android.testoption;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.support.annotation.NonNull;

import com.fota.android.commonlib.utils.SharedPreferencesUtil;
import com.fota.android.commonlib.utils.ToastUitl;
import com.fota.option.OptionConfig;
import com.fota.option.OptionManager;
import com.fota.option.OptionSdkActivity;
import com.fota.option.websocket.data.AccountInfo;
import com.fota.option.websocket.data.OptionTransfer;

public class TestAppcation extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferencesUtil.init(this);
        OptionConfig config = getOptionConfig();

//        OptionManager.userId = "2508713162866033664";
//        OptionManager.token = "me5a1nvy6m";
//        OptionManager.getConfig().setDevelopment(true);


        //预发 BW
        config.setLogEnable(true);
        config.setDevelopment(true);
        OptionManager.userId = "2509475866067207168";
        OptionManager.token = "wn6avpsjft";
        OptionManager.init("8", config, this);

    }

    @NonNull
    private OptionConfig getOptionConfig() {
        OptionConfig config = new OptionConfig();
        config.setAllOrderPageChangeListener(new OptionConfig.AllOrderPageChangeListener() {
            @Override
            public void gotoAllOrderPage(Activity activity, AccountInfo accountInfo, boolean b) {
                Intent intent = new Intent(activity, AllOrderPageActivity.class);
                startActivity(intent);
            }
        });

        config.setLoginPageChangeListener(new OptionConfig.LoginPageChangeListener() {
            @Override
            public void gotoLoginPage(Activity activity) {
                Intent intent = new Intent(activity, LoginPageActivity.class);
                startActivity(intent);
            }
        });

        config.setDepositPageChangeListener(new OptionConfig.DepositPageChangeListener() {
            @Override
            public void gotoDepositPage(Activity activity, AccountInfo accountInfo, boolean b) {
                Intent intent = new Intent(activity, DepositPageActivity.class);
                startActivity(intent);
            }
        });

        config.setOrderListener(new OptionConfig.OrderListener() {
            /**
             * 下单回调
             * order
             * @param activity
             * @param orderEntity 下单返回实体，包括String asset 标的物;int direction 方向;String investmentAmount 投资数量;String totalProfit 收益;
             * @param accountCurrency 下注的账户币种 accountCurrency;
             * @param errorMessage 错误信息，无错误为null
             */
            @Override
            public void orderCallback(Activity activity, OptionTransfer orderEntity, String accountCurrency, String errorMessage) {

            }
        });

        config.setSettleListener(new OptionConfig.SettleListener() {
            /**
             * 结算回调
             * Settle
             * @param activity
             * @param profit 收益
             * @param assetCode 标的物：1 BTC，2 ETH
             * @param accountCurrency 账户类型：2 BTC，3 ETH，4 FOTA，999 模拟金账户
             */
            @Override
            public void settleCallback(Activity activity, String profit, int assetCode, int accountCurrency) {

            }
        });
        //日志开关 调试的时候查看
        config.setLogEnable(false);
        //侧边栏风格 默认开启
        config.setSidebarStyle(true);
        config.setDevelopment(true);
        //默认是铃声一般不用修改
        config.setStreamType(AudioManager.STREAM_RING);
        return config;
    }

}

