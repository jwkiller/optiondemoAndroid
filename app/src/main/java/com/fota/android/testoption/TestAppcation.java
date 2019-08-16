package com.fota.android.testoption;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.media.AudioManager;
import android.support.annotation.NonNull;

import com.fota.android.commonlib.base.AppConfigs;
import com.fota.android.commonlib.utils.SharedPreferencesUtil;
import com.fota.option.OptionConfig;
import com.fota.option.OptionManager;
import com.fota.option.websocket.data.AccountInfo;
import com.fota.option.websocket.data.OptionTransfer;

import java.util.ArrayList;
import java.util.List;

public class TestAppcation extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferencesUtil.init(this);
        OptionConfig config = getOptionConfig();
        //预发 BW
        config.setLogEnable(BuildConfig.DEBUG);
        config.setDevelopment(true);
        OptionManager.userId = "2509811795991987200";
        OptionManager.token = "kbcsp9lsra";
        OptionManager.setBrokerId("2");


        OptionManager.init("2", config, this);

    }

    @NonNull
    private OptionConfig getOptionConfig() {
        OptionConfig config = new OptionConfig();
        config.setAllOrderPageChangeListener(new OptionConfig.AllOrderPageChangeListener() {
            @Override
            public void gotoAllOrderPage(Activity activity, AccountInfo accountInfo, boolean b) {
                //跳转全部订单
                Intent intent = new Intent(activity, AllOrderPageActivity.class);
                startActivity(intent);
            }
        });

        config.setLoginPageChangeListener(new OptionConfig.LoginPageChangeListener() {
            @Override
            public void gotoLoginPage(Activity activity) {
                //跳转登录
                Intent intent = new Intent(activity, LoginPageActivity.class);
                startActivity(intent);
            }
        });

        config.setDepositPageChangeListener(new OptionConfig.DepositPageChangeListener() {
            @Override
            public void gotoDepositPage(Activity activity, AccountInfo accountInfo, boolean b) {
                //跳转充值
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
             *  activity
             *  改为json String 回调，可能包含的key有
             *  profit          收益
             *  assetCode       标的物：1 BTC，2 ETH
             *  currency 账户类型：2 BTC，3 ETH，4 FOTA，999 模拟金账户
             *  profitRate 本轮投资收益率
             */
            @Override
            public void settleCallback(Activity activity, String s) {

            }

        });
        //去除排行版 设置setOptionMenuItems 注释掉对应菜单Items即可
//        List<OptionMenuItem> optionMenuItems = new ArrayList<>();
//        optionMenuItems.add(new OptionMenuItem(OptionMenuKey.MENU_BACK, com.fota.option.R.mipmap.icon_back, com.fota.option.R.mipmap.icon_back));
//        optionMenuItems.add(new OptionMenuItem(OptionMenuKey.MENU_TRADE_HISTORY, com.fota.option.R.mipmap.left_menu_history_on, com.fota.option.R.mipmap.left_menu_history_off));
//        optionMenuItems.add(new OptionMenuItem(OptionMenuKey.MENU_SPOT_INDEX, com.fota.option.R.mipmap.left_menu_index_on, com.fota.option.R.mipmap.left_menu_index_off));
//        optionMenuItems.add(new OptionMenuItem(OptionMenuKey.MENU_RANKING_LIST, com.fota.option.R.mipmap.left_munu_rank_on, com.fota.option.R.mipmap.left_munu_rank_off));
//        optionMenuItems.add(new OptionMenuItem(OptionMenuKey.MENU_VIDEO_LIST, com.fota.option.R.mipmap.left_menu_video_on, com.fota.option.R.mipmap.left_menu_video_off));
//        config.setOptionMenuItems(optionMenuItems);
        //日志开关 调试的时候查看
        config.setLogEnable(false);
        //侧边栏风格 默认开启
        config.setSidebarStyle(true);
        config.setDevelopment(true);
        AppConfigs.setLanguege(AppConfigs.LANGAUGE_KOREAN);
        //默认是铃声一般不用修改
        config.setStreamType(AudioManager.STREAM_RING);
        return config;
    }

}

