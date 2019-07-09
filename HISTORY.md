# 更新记录

##v0.5.0

1.添加Gamma支持

##v0.4.1

1.添加教学视频功能

##v0.4.0

1.添加连续缩放功能

##v0.3.7

1.添加灵活上币功能

##v0.3.6

1.修复部分问题

##v0.3.5

1.文案修改

##v0.3.4

1.新增本轮收益率

##v0.3.3

1.新增排行版功能

2.新增昵称设置

3.增加下单回调

```java
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
```

4.增加退出登录回调
```java
OptionManager.logOut();
```

##v0.3.2

1.修改混淆

##v0.3.1

1.声音提示跟随铃声提示

2.侧边栏风格变成可配置

3.其他问题修复


##v0.3.0

1.config添加是否开启日志调试功能
```java
/**
 * 调试开关
 * @param logEnable 是否开启
 */
public void setLogEnable(boolean logEnable) {
    this.logEnable = logEnable;
}
```
2.修改了页面跳转方式 详见 3.1 回调事件

3.修改历史记录和指数界面为侧边栏显示

4.添加下单、结算声音响应提示

5.下单失败时显示提示

6.修改所有历史记录显示逻辑，在无回调时不展示该按钮

7.添加侧边栏UI修改


