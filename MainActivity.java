package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void disable(View v){
        findViewById(R.id.button).setEnabled(false);
        ((Button)findViewById(R.id.button)).setText("disabled?");
    }

    public void handleText(View v){
        TextView t = findViewById(R.id.inputtext);
        String input = t.getText().toString();
        Log.d("info", input);

    }

}

public class SharedMemory{
    private SharedPreferences mSharedPreferences;

    public SharedMemory(Context context){
        mSharedPreferences = context.getSharedPreferences("SCREEN_FILTER_PREF", Context.MODE_PRIVATE)
    }
    private int getValue(String prop, int def) {
        return mSharedPreferences.getInt(prop, def);
    }

    public int getAlpha(){
        return getValue("alpha", 0x33);
    }
    private void setValue(String value, int v){
        mSharedPreferences.edit().putInt(value, v).apply();
    }
    public void setAlpha(int val){
        setValue("alpha", val);
    }

    public int getColor(){
        return Color.argb(getAlpha(), 1, 1, 1)
    }
}