# SimpleNews.io
[![Build Status](https://travis-ci.org/whiskeyfei/SimpleNews.io.svg?branch=master)](https://travis-ci.org/whiskeyfei/SimpleNews.io)[![](https://jitpack.io/v/whiskeyfei/SimpleNews.io.svg)](https://jitpack.io/#whiskeyfei/SimpleNews.io)

基于 Material Design 和 MVP 的新闻客户端,在原来的基础修改使用 RxJava+MVP,由于改动较大，所以单独拉出来进行更新，最新代码库请查看[SimpleNews.io](https://github.com/whiskeyfei/SimpleNews.io)

### 2017.8.8

此次调整改动较大，基本上之前的都改掉了，包括 UI 和逻辑，UI 已经不再完全是 Material Design 风格了，不过一些地方我还是遵守了 Material Design 规范。

修改如下：

* 添加底部 Tab，根据市面上的 App 交互方式，这种方式更易接受和使用。
* 暂时清除了主题修改，之后可能会考虑已换肤的形式加进来。
* 统一控件处理，将所有使用统一控件的地方统一处理。
* UI 风格更改。
* 增加了两种数据。

### 2017.5.26

[x] 使用 googlesamples MVP + Rxjava 结构实现
[x] 清除无用代码及无用的依赖库，合并一些基础工具类
[x] 为了之后的 Android 组件化做了结构调整 2017.5.26
[x] 添加 eventbus 使用

### 效果图

<img src="screenshot/simple_1.png" width=216/><img src="screenshot/simple_2.png" width=216/><img src="screenshot/simple_3.png" width=216/><img src="screenshot/simple_4.png" width=216/>
### App设计

本代码库借鉴了[SimpleNews](https://github.com/liuling07/SimpleNews)，在原来得基础上，修改了数据层和UI层的逻辑，使用RxJava+MVP组合
目前除了一些 tab 切换及 UI 使用原 SimpleNews 逻辑，其他基本上已经修改。

### 引用库

库名称 | 库信息
------- | -------
[todo-mvp](https://github.com/googlesamples/android-architecture/tree/todo-mvp/)  | Google googlesamples MVP
[RxJava](https://github.com/ReactiveX/RxJava) | 一个在 Java VM 上使用可观测的序列来组成异步的、基于事件的程序的库.
[RxAndroid](https://github.com/ReactiveX/RxAndroid) | RxAndroid 是 RxJava 的一个针对 Android 平台的扩展.
[Gson](https://github.com/google/gson) | Google json库，使用了@SerializedName标签、转对象.
[okhttp](https://github.com/square/okhttp) |  网络请求库.
[circleimageview](https://github.com/hdodenhof/CircleImageView) | 圆形图片操作.
[glide](https://github.com/bumptech/glide) | 图片加载.
[MultiType](https://github.com/drakeet/MultiType) | An Android library to create multiple item types list views easily and flexibly.

### 参考

* [NotRxJava懒人专用指南](http://www.devtf.cn/?p=323)
* [深入浅出RxJava(二：操作符)](https://github.com/lzyzsd/Awesome-RxJava?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io)
* [给 Android 开发者的 RxJava 详解](http://gank.io/post/560e15be2dca930e00da1083#toc_1)
* [android-architecture](https://github.com/googlesamples/android-architecture) 
* [todo-mvp](https://github.com/googlesamples/android-architecture/tree/todo-mvp/) 
* [todo-mvp-rxjava/](https://github.com/googlesamples/android-architecture/tree/todo-mvp-rxjava/)
* [android-architecture](https://github.com/googlesamples/android-architecture)
* [FakeWeather](https://github.com/li-yu/FakeWeather)
* [gank.io](http://gank.io/)

# License
Copyright 2015 liuling <lauren.liuling@gmail.com><br/>
Copyright 2015 whiskeyfei <whiskeyfei@gmail.com><br/>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
