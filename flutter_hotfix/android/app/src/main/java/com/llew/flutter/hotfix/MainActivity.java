package com.llew.flutter.hotfix;

import androidx.annotation.NonNull;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {
    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine);
    }

    @Override @NonNull
    public FlutterShellArgs getFlutterShellArgs() {
        FlutterShellArgs shellArgs = super.getFlutterShellArgs();
        shellArgs.add("--aot-shared-library-name=" + HotfixApplication.INSTANCE.getAotSharedLibraryPath());
        return shellArgs;
    }
}
