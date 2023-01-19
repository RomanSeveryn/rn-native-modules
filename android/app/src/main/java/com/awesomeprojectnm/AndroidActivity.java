package com.awesomeprojectnm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AndroidActivity extends AppCompatActivity {

    private Button toggleButton;

    boolean hasCameraFlash = false;
    boolean flashOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);

        toggleButton = findViewById(R.id.button2);

        hasCameraFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(hasCameraFlash){
                    if(flashOn){

                        flashOn = false;
                        toggleButton.setText("On");
                        flashLightOff();
                    }
                    else{

                        flashOn = true;
                        toggleButton.setText("Off");
                        flashLightOn();
                    }
                } else{
                    Toast.makeText(AndroidActivity.this, "No flash available on your device", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

    private void flashLightOn(){
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try{
            assert cameraManager != null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode("0", true);
            }
            Toast.makeText(AndroidActivity.this, "FlashLight is ON", Toast.LENGTH_SHORT).show();
        }
        catch(CameraAccessException e){
            Log.e("Camera Problem", "Cannot turn on camera flashlight");
        }
    }


    private void flashLightOff(){
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try{
            assert cameraManager != null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode("0", false);
            }
            Toast.makeText(AndroidActivity.this, "FlashLight is OFF", Toast.LENGTH_SHORT).show();
        }
        catch(CameraAccessException e){
            Log.e("Camera Problem", "Cannot turn off camera flashlight");
        }
    }
}
