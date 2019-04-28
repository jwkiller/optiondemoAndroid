# optionDemoAndroid
## 目录
- [一、集成SDK](#一集成sdk)
- [二、快速使用SDK](#二快速使用sdk)
- [三、接口说明](#三接口说明)
- [四、常见问题](#四常见问题)
- [五、更新记录](#五更新记录)
- [六、功能截图](#六功能截图)



## 一、集成SDK


### 兼容性

| 类别     | 兼容范围                      |
| -------- | ----------------------------- |
| 兼容性     | android 4.0以上系统       |
| SDK版本     | 建议使用27       |
| 架构     | armv7、arm64、i386、x86_64    |
| 开发环境 | 建议使用最新版本Android studio进行开发 |


### 导入optionSDK到工程

#### 1.1 引入依赖包


添加仓库引用
```
allprojects {
    repositories {
        maven { url 'https://dl.bintray.com/fota/release' }
    }
}
```

添加依赖
```
dependencies {
    api('com.fota.android:option:0.3.3@aar') { transitive = true; }
}
```

#### 1.2 添加必要权限

在app/src/main/AndroidManifest.xml 中加入：

```java
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.INTERNET" />
```


## 二、快速使用SDK


### 2.1 在Application中配置如下信息

```java
OptionManager.init("your brokerId", getOptionConfig(), this);

```


### 2.2 进入期权界面

```java
Intent intent = new Intent(getContext(), OptionActivity.class);
startActivity(intent);
```



## 三、接口说明

### 3.1 配置说明

```java

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
        void settleCallback(Activity activity, String jsonSettle);

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

```

### 3.2 设置语言

```java
//   设置为中文
AppConfigs.setLanguege(AppConfigs.LANGAUGE_SIMPLE_CHINESE);
//   设置为英文
AppConfigs.setLanguege(AppConfigs.LANGAUGE_ENGLISH);

```


### 3.3 设置开发模式

```java


/**
* is development environment
* 是否是开发环境
*/
boolean isDevelopment;

/**
* set the socketHost ,only valid when development environment
* 配置socketHost 该配置只在开发模式下有效
*/
String socketHost;


/**
* set the httpHost ,only valid when development environment
* 配置httpHost 该配置只在开发模式下有效
*/
String httpHost;


```


### 3.4 设置登录token

```java

//登录成功后设置UserID和Token
OptionManager.setUserIdAndToken("your userId","your login token");

```

### 3.5 设置开发环境

```java
//true为开发环境  false为线上环境 默认为false
config.setDevelopment(boolean development);
```


### 3.5 设置混淆
[参考混淆文件](https://github.com/jwkiller/optiondemoAndroid/blob/master/app/proguard-rules.pro)

## 四、常见问题



### 如何拿到设置的Config
```java
OptionManager.getConfig()
```

### 为什么我设置了token和userId，依然显示未登录
```java
//对应的开发环境的token和userId是不一样 这个需要设置成对应的地址
config.setDevelopment(boolean development);
```

###
```java
//对应的开发环境的token和userId是不一样 这个需要设置成对应的地址
config.setDevelopment(boolean development);
```




## 五、更新记录

[更新记录](https://github.com/jwkiller/optiondemoAndroid/blob/master/HISTORY.md)


## 六、功能截图

以下是SDK部分功能截图

![图片说明1](https://github.com/jwkiller/optiondemoAndroid/blob/master/screenshot/1.jpg)

![图片说明2](https://github.com/jwkiller/optiondemoAndroid/blob/master/screenshot/2.jpg)

![图片说明3](https://github.com/jwkiller/optiondemoAndroid/blob/master/screenshot/3.jpg)
