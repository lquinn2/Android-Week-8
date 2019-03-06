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
        list.addLevel(0,0, res.getDrawable(R.drawable.ic_battery_20v));
        list.addLevel(1,1, res.getDrawable(R.drawable.ic_battery_30v));
        list.addLevel(2,2, res.getDrawable(R.drawable.ic_battery_50v));
        list.addLevel(3,3, res.getDrawable(R.drawable.ic_battery_60v));
        list.addLevel(4,4, res.getDrawable(R.drawable.ic_battery_80v));
        list.addLevel(5,5, res.getDrawable(R.drawable.ic_battery_90v));
        list.addLevel(6,6, res.getDrawable(R.drawable.ic_battery_100v));

        battery.setImageDrawable(list);
    }

    public void decreaseBatteryLife(View view) {
        // Decrease battery life
        if (currentBatteryLevel > 0){
            currentBatteryLevel--;
            battery.setImageLevel(currentBatteryLevel);
            Log.d("TAG", "decreaseBatteryLife: " + currentBatteryLevel);
        }
    }

    public void increaseBatteryLife(View view) {
        // Increase battery life
        if (currentBatteryLevel < 6){
            currentBatteryLevel++;
            battery.setImageLevel(currentBatteryLevel);
            Log.d("TAG", "increaseBatteryLife: " + currentBatteryLevel);
        }
    }
}
