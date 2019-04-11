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
    api('com.fota.android:option:0.1.0@aar') { transitive = true; }
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

### 3.1 回调事件

```java
//设置页面跳转的回调
config.setPageChangeListener(new OptionConfig.PageChangeListener() {
    @Override
    public void gotoDepositPage(Context context) {
        //跳转充值界面的回调
        ...
    }

    @Override
    public void gotoLoginPage(Context context) {
        //跳转登录界面的回调
        ...
    }

    @Override
    public void gotoAllOrderPage(Context context) {
        //跳转全部订单界面的回调
        ...
    }
    });


//0.3.0 之后请用如下方式设置
config.setDepositPageChangeListener(new OptionConfig.DepositPageChangeListener() {
    @Override
    public void gotoDepositPage(Activity activity, AccountInfo currentAccountInfo, boolean loginSuccess) {
        //跳转充值界面的回调
        //currentAccountInfo 当前账户信息
        //loginSuccess 是否成功登录期权 主要设计token过期和环境设置不对 导致内外不一致
        Intent intent = new Intent(activity, DepositPageActivity.class);
        activity.startActivity(intent);
    }
});

config.setLoginPageChangeListener(new OptionConfig.LoginPageChangeListener() {
    @Override
    public void gotoLoginPage(Activity activity) {
        //跳转登录界面的回调
        Intent intent = new Intent(activity, LoginPageActivity.class);
        activity.startActivity(intent);
    }
});

config.setAllOrderPageChangeListener(new OptionConfig.AllOrderPageChangeListener() {
    @Override
    public void gotoAllOrderPage(Activity activity, AccountInfo currentAccountInfo, boolean loginSuccess) {
        //跳转全部订单界面的回调
        Intent intent = new Intent(activity, AllOrderPageActivity.class);
        activity.startActivity(intent);
    }
});

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




## 五、更新记录

===sdk v0.3.3版本更新功能===

1.新增排行版功能

2.新增昵称设置


===sdk v0.3.2版本更新功能===

1.修改混淆

===sdk v0.3.1版本更新功能===

1.声音提示跟随铃声提示

2.侧边栏风格变成可配置

3.其他问题修复


===sdk v0.3.0版本更新功能===

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

## 六、功能截图

以下是SDK部分功能截图

![图片说明1](https://github.com/jwkiller/optiondemoAndroid/blob/master/screenshot/1.jpg)

![图片说明2](https://github.com/jwkiller/optiondemoAndroid/blob/master/screenshot/2.jpg)

![图片说明3](https://github.com/jwkiller/optiondemoAndroid/blob/master/screenshot/3.jpg)
