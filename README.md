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
    api('com.fota.android:option:x.x.x@aar') { transitive = true; }
    //x.x.x表示你所需要使用版本号 一般是最新版本
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
Intent intent = new Intent(getContext(), OptionSdkActivity.class);
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
    //设置开发环境
    config.setDevelopment(true);
    //切换语言
    config.setShowLanguageChangedMenu(true);
    config.setLanguageChangeListener(new OptionConfig.OnLanguageChangeListener() {
        @Override
        public void changeLanguage(int i) {

        }
    });
    //是否开启PK活动
    config.setShowPk(false);
    //进去设置默认语言
    AppConfigs.setLanguege(AppConfigs.LANGAUGE_ENGLISH);
        return config;
    }

}

```

### 3.2 设置语言

```java
//   设置为中文
AppConfigs.setLanguege(AppConfigs.LANGAUGE_SIMPLE_CHINESE);
//   设置为英文
AppConfigs.setLanguege(AppConfigs.LANGAUGE_ENGLISH);
//   设置为韩文
AppConfigs.setLanguege(AppConfigs.LANGAUGE_KOREAN);
//   设置为越南语
AppConfigs.setLanguege(AppConfigs.LANGAUGE_SIMPLE_VIETNAMESE);
//   进去为俄罗斯语言
AppConfigs.setLanguege(AppConfigs.LANGAUGE_SIMPLE_VIETNAMESE);

```

如果在在SDK内部替换语言功能，需要打开setShowLanguageChangedMenu
```java
//设置为true切换语言按钮开启，但是该语言切换只在SDK内部生效
config.setShowLanguageChangedMenu(true);
```

可以设置回调，来获取到SDK切换语言到事件
```java
config.setLanguageChangeListener(new OptionConfig.OnLanguageChangeListener() {
    @Override
    public void changeLanguage(int i) {
        swicth(i){
            case AppConfigs.LANGAUGE_SIMPLE_CHINESE:
                break;
                ....
        }
    }
});
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

### 去除对应菜单Item方法
```java
//去除对应菜单 设置setOptionMenuItems 注释掉对应菜单Items即可
List<OptionMenuItem> optionMenuItems = new ArrayList<>();
optionMenuItems.add(new OptionMenuItem(OptionMenuKey.MENU_BACK, com.fota.option.R.mipmap.icon_back, com.fota.option.R.mipmap.icon_back));
optionMenuItems.add(new OptionMenuItem(OptionMenuKey.MENU_TRADE_HISTORY, com.fota.option.R.mipmap.left_menu_history_on, com.fota.option.R.mipmap.left_menu_history_off));
optionMenuItems.add(new OptionMenuItem(OptionMenuKey.MENU_SPOT_INDEX, com.fota.option.R.mipmap.left_menu_index_on, com.fota.option.R.mipmap.left_menu_index_off));
optionMenuItems.add(new OptionMenuItem(OptionMenuKey.MENU_RANKING_LIST, com.fota.option.R.mipmap.left_munu_rank_on, com.fota.option.R.mipmap.left_munu_rank_off));
optionMenuItems.add(new OptionMenuItem(OptionMenuKey.MENU_VIDEO_LIST, com.fota.option.R.mipmap.left_menu_video_on, com.fota.option.R.mipmap.left_menu_video_off));
config.setOptionMenuItems(optionMenuItems);
```

### 0.5.2增加分享功能

```java
//隐藏历史记录分享功能
config.setShowShareMenu(boolean false);

//设置logo
config.setShareLogo(int drawableID);

//设置下载链接
config.setShareLoadUrl(String "your app download url");

//设置平台list   以数组的使用传递 ShareMenuItem menuIcon+menuString是必须的
config.setShareMenuList(List<ShareMenuItem> your app share platform);

//设置点击item监听 i返回list对于下标 根据下表获取对应ShareMenuItem分享
config.setShareMenuListener(new OptionConfig.OnClickShareMenuListener() {
    @Override
    public void onClickShareMenu(Activity activity, int i, Bitmap bitmap) {
            
    }
});

```

之外需要设置根目录build.gradle
```
repositories {
        google()
        jcenter()
        maven { url "https://www.jitpack.io" }
        maven { url 'https://dl.bintray.com/fota/release' }
}

```

App目录的build.gradle
```
implementation 'com.android.support:appcompat-v7:27.1.1'
implementation 'com.android.support:design:27.1.1'

```



### OptionMenuKey 含义
MENU_BACK ==>返回

MENU_TRADE_HISTORY ==>历史记录

MENU_SPOT_INDEX ==>指数

MENU_RANKING_LIST ==>排行版

MENU_VIDEO_LIST ==>视频教学


## 五、更新记录

[更新记录](https://github.com/jwkiller/optiondemoAndroid/blob/master/HISTORY.md)


## 六、功能截图

以下是SDK部分功能截图

![图片说明1](https://github.com/jwkiller/optiondemoAndroid/blob/master/screenshot/1.jpg)

![图片说明2](https://github.com/jwkiller/optiondemoAndroid/blob/master/screenshot/2.jpg)

![图片说明3](https://github.com/jwkiller/optiondemoAndroid/blob/master/screenshot/3.jpg)
