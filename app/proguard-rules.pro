# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in E:\development tool\studioSDK\platforms/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
-dontskipnonpubliclibraryclasses # 不忽略非公共的库类
-optimizationpasses 5            # 指定代码的压缩级别
-dontusemixedcaseclassnames      # 是否使用大小写混合
-dontpreverify                   # 混淆时是否做预校验
-verbose                         # 混淆时是否记录日志
-keepattributes *Annotation*     # 保持注解
-ignorewarning                   # 忽略警告
-dontoptimize                    # 优化不优化输入的类文件
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*  # 混淆时所采用的算法

-keepnames class * implements java.io.Serializable #不混淆Serializable

-keep class **.R$* {
 *;
}


-keepclassmembers enum * {                                # 枚举类不能去混淆
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {              # aidl文件不能去混淆.
  public static final android.os.Parcelable$Creator *;
}

-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }

# Only required if you use AsyncExecutor
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(Java.lang.Throwable);
}

#-libraryjars **.jar  #（声明lib文件）
#-dontwarn com.xx.bbb.**  #（不提示警告）
#-keep class com.xx.bbb.** { *;}  #（不进行混淆）

#-libraryjars libs/libjoinpay-release.aar        #混淆第三方jar包，其中xxx为jar包名
#-libraryjars libs/P84SDK_20161107_0950.jar
#-libraryjars libs/P84SDK_20161102_1250_YH.jar
#-libraryjars libs/locSDK_6.12.jar
#-libraryjars libs/mobAPI-1.0.6.jar
#-libraryjars libs/core.jar
#-libraryjars libs/MobCommons-2016.0727.1113.jar
#-libraryjars libs/volley.jar
#-libraryjars MobTools-2016.0727.1113.jar
#}
# To enable ProGuard in your project, edit project.properties
# to define the proguard.config property as described in that file.
#
# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in ${sdk.dir}/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the ProGuard
# include property in project.properties.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
-keepclassmembers class fqcn.of.javascript.interface.for.webview {
   public *;
}
# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in E:\development tool\studioSDK\platforms/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
# To enable ProGuard in your project, edit project.properties
# to define the proguard.config property as described in that file.
#
# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in ${sdk.dir}/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the ProGuard
# include property in project.properties.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-keep class com.baidu.** {*;}
-keep class vi.com.** {*;}
-dontwarn com.baidu.**

# removes such information by default, so configure it to keep all of it.
-keepattributes Signature
# Gson specific classes
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }
-keep class com.google.gson.** { *;}
#-keep class com.joinpay.sdk.ui** {*;}



-dontwarn org.mozilla.javascript.**
-keep class org.mozilla.javascript.** {*;}
-keep interface org.mozilla.javascript.** {*;}


-keep class org.greenrobot.eventbus.EventBus{*;}
-keep class org.greenrobot.eventbus.Subscribe{*;}



##-dontwarn class com.qsposcom.**
#-dontwarn class vpos.apipackage.**
#-dontwarn class vpos.emvkernel.**
#-dontwarn class vpos.util.**


-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# 保持 native 方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}


# 代码混淆压缩比，在0~7之间，默认为5,一般不下需要修改
-optimizationpasses 5

# 混淆时不使用大小写混合，混淆后的类名为小写
-dontusemixedcaseclassnames

# 指定不去忽略非公共的库的类
# 默认跳过，有些情况下编写的代码与类库中的类在同一个包下，并且持有包中内容的引用，此时就需要加入此条声明
-dontskipnonpubliclibraryclasses

# 指定不去忽略非公共的库的类的成员
-dontskipnonpubliclibraryclassmembers

# 不做预检验，preverify是proguard的四个步骤之一
# Android不需要preverify，去掉这一步可以加快混淆速度
-dontpreverify

# 有了verbose这句话，混淆后就会生成映射文件
# 包含有类名->混淆后类名的映射关系
# 然后使用printmapping指定映射文件的名称
-verbose
-printmapping priguardMapping.txt

# 指定混淆时采用的算法，后面的参数是一个过滤器
# 这个过滤器是谷歌推荐的算法，一般不改变
-optimizations !code/simplification/artithmetic,!field/*,!class/merging/*

# 保护代码中的Annotation不被混淆
# 这在JSON实体映射时非常重要，比如fastJson
-keepattributes *Annotation*

# 避免混淆泛型
# 这在JSON实体映射时非常重要，比如fastJson
-keepattributes Signature

# 抛出异常时保留代码行号
-keepattributes SourceFile,LineNumberTable


-keep class com.yeohe.kiosk.utils.Gsonutil
-keep public class com.yeohe.kiosk.bean.**{*;}



# 信鸽
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep class com.tencent.android.tpush.**  {* ;}
-keep class com.tencent.mid.**  {* ;}
-keepattributes *Annotation*
# OkHttp3
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp.** { *;}
-keep interface com.squareup.okhttp.** { *;}
-keep class com.squareup.okhttp3.** { *;}
-dontwarn okio.**


# Router
-keep class com.chenenyu.router.** {*;}
-keep class * implements com.chenenyu.router.ParamInjector {*;}

# OkHttp3
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}
-dontwarn okio.**



# Gson
#-keepattributes Signature-keepattributes *Annotation*
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
# 使用Gson时需要配置Gson的解析对象及变量都不混淆。不然Gson会找不到变量。
# 将下面替换成自己的实体类
-keep class com.efly.flyhelper.bean.** { *; }

#recoo
-keep class com.dodola.** {*;}
-keep class com.lody.legend.** {*;}

#-dontwarn com.dodola.rocoo.** { *; }
#-keep class com.dodola.rocoo.** { *; }

# ButterKnife
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

-keepattributes *Annotation*
-keep class android.support.v4.** { *; }
-keep interface android.support.v4.app.** { *; }
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v13.**
-keep class android.support.v13.** { *; }
-keep class android.support.v7.** { *; }



-dontwarn javax.annotation.**
-keep class javax.annotation.** { *;}


-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}
-keep class android.support.**{*;}

-dontwarn javax.servlet.**
-dontwarn org.joda.time.**
-dontwarn org.w3c.dom.**

# Router
-keep class com.alibaba.android.arouter.facade.annotation.** {*;}
-keep class * implements com.alibaba.android.arouter.facade.annotation.Interceptor {*;}
-keep class * implements com.alibaba.android.arouter.facade.** {*;}
 -keep public class com.alibaba.android.arouter.routes.**{*;}



-keep class cn.pedant.SweetAlert.Rotate3dAnimation {
    public <init>(...);
 }

 # Gson
 #-keepattributes Signature-keepattributes *Annotation*
 -keep class sun.misc.Unsafe { *; }
 -keep class com.google.gson.stream.** { *; }
 # 使用Gson时需要配置Gson的解析对象及变量都不混淆。不然Gson会找不到变量。
 # 将下面替换成自己的实体类
 -keep class com.efly.flyhelper.bean.** { *; }


#EventBus
-keepclassmembers class ** {
    public void onEvent*(**);
}
-keep class org.greenrobot.eventbus.EventBus{*;}
-keep class org.greenrobot.eventbus.Subscribe{*;}
-keep class com.yeohe.kiosk.utils.GsonImpl
-keep class * implements java.io.Serializable {*;}
-keepclassmembers class * implements java.io.Serializable {*;}
-keep class com.yeohe.kiosk.utils.Json
# OkHttp3
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp.** { *;}
-keep interface com.squareup.okhttp.** { *;}
-keep class com.squareup.okhttp3.** { *;}
-dontwarn okio.**

-keep class com.android.volley.** {*;}
-dontwarn com.android.volley.**
-keep interface com.android.volley.** {*;}

 -keep public class * implements com.bumptech.glide.module.GlideModule
 -keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
      **[] $VALUES;public *;}

## ----------------------------------
##      Okio 相关
## ----------------------------------
-keep class sun.misc.Unsafe { *; }
-dontwarn java.nio.file.*
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontwarn okio.**

## ----------------------------------
##      Retrofit 2.X 相关
## ----------------------------------
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions

-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

## ----------------------------------
##      RxJava 1.X 相关
## ----------------------------------
-dontwarn sun.misc.**

-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
   long producerIndex;
   long consumerIndex;
}

-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}

-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

## ----------------------------------
##      Glide 相关
## ----------------------------------
-keep class com.bumptech.glide.Glide { *; }
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-dontwarn com.bumptech.glide.**

## ----------------------------------
##      Fresco 相关
## ----------------------------------
-keep,allowobfuscation @interface com.facebook.common.internal.DoNotStrip

# Do not strip any method/class that is annotated with @DoNotStrip
-keep @com.facebook.common.internal.DoNotStrip class *
-keepclassmembers class * {
    @com.facebook.common.internal.DoNotStrip *;
}

# Keep native methods
-keepclassmembers class * {
    native <methods>;
}

-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn com.android.volley.toolbox.**

## ----------------------------------
##      DataBinding 相关
## ----------------------------------
-keepclasseswithmembers class * extends android.databinding.ViewDataBinding{
    <methods>;
}

