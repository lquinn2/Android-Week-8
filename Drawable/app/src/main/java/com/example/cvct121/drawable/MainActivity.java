package com.example.cvct121.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView battery;
    LevelListDrawable list;
    Resources res;
//    android.graphics.drawable.Drawable battery20;
//    android.graphics.drawable.Drawable battery30;
//    android.graphics.drawable.Drawable battery50;
//    android.graphics.drawable.Drawable battery60;
//    android.graphics.drawable.Drawable battery80;
//    android.graphics.drawable.Drawable battery90;
//    android.graphics.drawable.Drawable[] batteryLevels = {battery20, battery30, battery50, battery60, battery80, battery90};
    private int currentBatteryLevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        battery = (ImageView) findViewById(R.id.battery);

        res = getResources();
        list = new LevelListDrawable();
        list.setLevel(currentBatteryLevel);
        list.addLevel(0,0, res.getDrawable(R.drawable.ic_battery_20));
        list.addLevel(0,0, res.getDrawable(R.drawable.ic_battery_30));
        list.addLevel(0,0, res.getDrawable(R.drawable.ic_battery_50));
        list.addLevel(0,0, res.getDrawable(R.drawable.ic_battery_60));
        list.addLevel(0,0, res.getDrawable(R.drawable.ic_battery_80));
        list.addLevel(0,0, res.getDrawable(R.drawable.ic_battery_90));
        list.addLevel(0,0, res.getDrawable(R.drawable.ic_battery_100));

        battery.setImageDrawable(list);
    }

    public void decreaseBatteryLife(View view) {
        // Decrease battery life
        if (currentBatteryLevel <= 6){
            currentBatteryLevel--;
            battery.setImageLevel(currentBatteryLevel);
            Log.d("TAG", "increaseBatteryLife: " + currentBatteryLevel);
        }
    }

    public void increaseBatteryLife(View view) {
        // Increase battery life
        if (currentBatteryLevel >= 0){
            currentBatteryLevel--;
            battery.setImageLevel(currentBatteryLevel);
            Log.d("TAG", "increaseBatteryLife: " + currentBatteryLevel);
        }
    }
}
