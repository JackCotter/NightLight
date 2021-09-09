package com.example.screenfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int alpha = (int)(60 * 255.0f);
        View view = findViewById(R.id.MyLayout);
        //LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        //RelativeLayout overlay = (RelativeLayout) inflater.inflate(R.layout.activity_main, null);
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        assert windowManager != null;
        //view.setBackgroundColor(Color.argb(alpha,200,200,60));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY, 20,
                PixelFormat.TRANSLUCENT
        );


        windowManager.addView(view, layoutParams);
    }
    int STATE = 0;


    public void turnon(View view){
        if(STATE == 0) {

            STATE = 1;
        }else if (STATE == 1){
            view = findViewById(R.id.MyLayout);
            view.setBackgroundColor(android.R.color.background_light);
            WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
            assert windowManager != null;
            windowManager.removeView(view);
            STATE = 0;
        }
    }

}
