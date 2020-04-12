package com.llew.flutter.hotfix;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.channels.FileChannel;

import io.flutter.embedding.engine.hotfix.FlutterLogger;
import io.flutter.view.FlutterMain;

public class SplashActivity extends Activity {

    private EditText mEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        mEditText = findViewById(R.id.name);
    }

    public void init(View view) {
        FlutterMain.startInitialization(this);
    }

    public void open(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void fix(View view) {
        File dir = new File(getFilesDir(), "/flutter/hotfix");
        if (!dir.exists()) {
            if (dir.mkdirs()) {
                FlutterLogger.i("mkdirs success: " + dir.getAbsolutePath());
            } else {
                FlutterLogger.i("mkdirs failure: " + dir.getAbsolutePath());
            }
        } else {
            FlutterLogger.i("dirs exists: " + dir.getAbsolutePath());
        }


        try {
            File source = new File("/sdcard/" + mEditText.getText().toString());
            File dest = new File(dir, "hotfix.so");
            if (dest.exists() && !dest.delete()) {
                FileWriter writer = new FileWriter(dest, false);
                writer.write("");
                writer.flush();
                writer.close();
            }

            FileChannel inputChannel = new FileInputStream(source).getChannel();
            FileChannel outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
            inputChannel.close();
            outputChannel.close();

            FlutterLogger.i("copy fixed file finish: " + dest.getAbsolutePath());

            HotfixApplication.INSTANCE.setAotSharedLibraryPath(dest.getAbsolutePath());
        } catch (Throwable error) {
            FlutterLogger.e("copy file error: " + error);
        }
    }
}
