package com.fota.android.testoption;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.fota.android.commonlib.utils.SharedPreferencesUtil;
import com.fota.android.commonlib.utils.ToastUitl;
import com.fota.option.OptionConfig;
import com.fota.option.OptionManager;
import com.fota.option.OptionSdkActivity;
import com.fota.option.websocket.data.AccountInfo;

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

//        config.setHttpHost("https://api-test.fota.com/mapi/");
//        config.setSocketHost("wss://api-test.fota.com/mapi/websocket");

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
        return config;
    }

}
