package com.awesomeprojectnm;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;


public class OpenActivityModule extends ReactContextBaseJavaModule {
    OpenActivityModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @ReactMethod
    public void open() {
        Intent intent = new Intent(getCurrentActivity(), AndroidActivity.class);
        getCurrentActivity().startActivity(intent);
    }

    @NonNull
    @Override
    public String getName() {
        return "OpenActivity";
    }
}
