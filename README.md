# flutter_hotfix
hotfix in flutter

# init with none fixed aotFile
```java
FlutterManager.startInitialization(context);
```

# init with fixed aotFile
```java
FlutterManager.startInitialization(this, aotFile);
```

# proguard
```java
-keep class io.flutter.** {
   *;
}
```
