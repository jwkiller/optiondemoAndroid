# optionSDK-Android

[![CI Status](https://img.shields.io/travis/扁鹊/optionSDK-iOS.svg?style=flat)](https://travis-ci.org/扁鹊/optionSDK-iOS)
[![Version](https://img.shields.io/cocoapods/v/optionSDK-iOS.svg?style=flat)](https://cocoapods.org/pods/optionSDK-iOS)
[![License](https://img.shields.io/cocoapods/l/optionSDK-iOS.svg?style=flat)](https://cocoapods.org/pods/optionSDK-iOS)
[![Platform](https://img.shields.io/cocoapods/p/optionSDK-iOS.svg?style=flat)](https://cocoapods.org/pods/optionSDK-iOS)

## Example

To run the example project, clone the repo, and run `pod install` from the Example directory first.


## 目录
- [一、集成SDK](#一集成SDK)
- [二、快速使用SDK](#二快速使用SDK)
- [三、接口说明](#三接口说明)
- [四、常见问题](#四常见问题)
- [五、更新记录](#五更新记录)
- [六、功能截图](#六功能截图)




# 一、集成SDK

### 文件介绍

| Demo中的文件  | 说明                      |
| --------- | ----------------------- |
| optionSDK  | optionSDK.a主功能静态库    |

### 兼容性

| 类别     | 兼容范围                      |
| -------- | ----------------------------- |
| compileSdkVersion     | 建议使用27       |
| 架构     | armv7、arm64、i386、x86_64    |
| 开发环境 | 建议使用最新版本Android studio进行开发 |


### 导入optionSDK到工程

#### 1.1 手动导入aar


把Demo中4个aar库拷贝到你的工程的Lib文件夹下

| 类别     | 兼容范围                      |
| -------- | ----------------------------- |
| commonlib-release.aar     | option base库         |
| fotaoptionlib-release.aar     | option core库      |
| mpchartlib-release.aar | chart依赖库 |
| option-release.aar | option UI库 |

#### 1.2 添加必要权限

在app/src/main/AndroidManifest.xml 中加入：

```java
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.INTERNET" />
```


# 二、快速使用SDK


### 2.1 在Application中配置如下信息

```java
    OptionManager.init("your AppID", "your appSecret", getOptionConfig(), this);
    @NonNull
    private OptionConfig getOptionConfig() {
        OptionConfig config = new OptionConfig();
        config.setPageChangeListener(new OptionConfig.PageChangeListener() {
            @Override
            public void gotoRechargePage(Context context) {
                  ...
            }

            @Override
            public void gotoLoginPage(Context context) {
                  ...
            }

            @Override
            public void gotoAllHistoryPage(Context context) {
                  ...
            }
        });
        ...
        return config;
    }

```

-

### 2.2 进入期权界面

```java
          Intent intent = new Intent(getContext(), OptionActivity.class);
          startActivity(intent);
```



# 三、接口说明

### 3.1 回调事件


```java
  config.setPageChangeListener(new OptionConfig.PageChangeListener() {
            @Override
            public void gotoRechargePage(Context context) {
                  ...
            }

            @Override
            public void gotoLoginPage(Context context) {
                  ...
            }

            @Override
            public void gotoAllHistoryPage(Context context) {
                  ...
            }
        });
@end
```

### 3.2 设置语言

### 3.3 设置开发模式

### 3.4 设置登录token



# 四、常见问题

### 横竖屏
请检查info.plist已设置支持横屏，如果其他页面不支持，可在UIViewControler基类或其Category中添加已下代码
```java
```

# 五、更新记录

以下是SDK更新记录



# 六、功能截图

以下是SDK部分功能截图