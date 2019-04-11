-keep class com.fota.** {*; }
# Retrofit
-dontnote retrofit2.Platform
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
-dontwarn retrofit2.Platform$Java8
-keepattributes Signature
-keepattributes Exceptions
# Gson
-keep class com.google.gson.stream.** { *; }
-keepattributes EnclosingMethod
-keep class org.xz_sale.entity.**{*;}
-keep class com.google.gson.** {*;}
-keep class com.google.**{*;}
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
#okhttp
-dontwarn okhttp3.**
-keep class okhttp3.**{*;}
-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**
#okio
-dontwarn okio.**
-keep class okio.**{*;}
