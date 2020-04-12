package com.llew.flutter.hotfix;

import android.app.Application;

import io.flutter.embedding.engine.hotfix.FlutterLogger;
import io.flutter.view.FlutterMain;

public class HotfixApplication extends Application {

    // Must match values in flutter::switches
    public static final String AOT_SHARED_LIBRARY_NAME = "aot-shared-library-name";

    private String aotSharedLibraryPath;

    public static HotfixApplication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public String getAotSharedLibraryPath() {
        return aotSharedLibraryPath;
    }

    public void setAotSharedLibraryPath(String aotSharedLibraryPath) {
        this.aotSharedLibraryPath = aotSharedLibraryPath;
        FlutterLogger.i("路径设置完毕：" + aotSharedLibraryPath);
    }
}
