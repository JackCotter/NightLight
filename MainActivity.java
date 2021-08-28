package com.example.screenfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    int STATE = 0;



    public void turnon(View view){
        if(STATE == 0) {
            view = findViewById(R.id.MyLayout);
            view.setBackgroundColor(Color.rgb(200, 200, 200));
            STATE = 1;
        }else if (STATE == 1){
            view = findViewById(R.id.MyLayout);
            view.setBackgroundColor(android.R.color.background_light);
            STATE = 0;
        }
    }
}
