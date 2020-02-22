# flutter_hotfix
hotfix in flutter

# init with none fixed aotFile
```java
FlutterManager.startInitialization(context);
```

# init with fixed aotFile
```java
FlutterManager.startInitialization(this, aotFile, FlutterVersion.VERSION_011400);
```

# proguard
```java
-keep class io.flutter.** {
   *;
}
```

# blog site
[https://blog.csdn.net/llew2011/article/details/104075796](https://blog.csdn.net/llew2011/article/details/104075796)