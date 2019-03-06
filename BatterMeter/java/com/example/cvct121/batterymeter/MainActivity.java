package com.example.cvct121.batterymeter;

import android.graphics.drawable.LevelListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    LevelListDrawable lldraw;
    int level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        level=0;

        lldraw = new LevelListDrawable();
        lldraw.setLevel(level);
        lldraw.addLevel(0,0, getDrawable(R.drawable.ic_battery_empty_black_24dp));
        lldraw.addLevel(1,1, getDrawable(R.drawable.ic_battery_20_black_24dp));
        lldraw.addLevel(2,2, getDrawable(R.drawable.ic_battery_30_black_24dp));
        lldraw.addLevel(3,3, getDrawable(R.drawable.ic_battery_50_black_24dp));
        lldraw.addLevel(4,4, getDrawable(R.drawable.ic_battery_60_black_24dp));
        lldraw.addLevel(5,5, getDrawable(R.drawable.ic_battery_80_black_24dp));
        lldraw.addLevel(6,6, getDrawable(R.drawable.ic_battery_90_black_24dp));
        lldraw.addLevel(7,7, getDrawable(R.drawable.ic_battery_full_black_24dp));

        image = findViewById(R.id.imageView);
        image.setImageDrawable(lldraw);
    }

    public void onDecrement(View view){if(level>0) image.setImageLevel(--level);}
    public void onIncrement(View view){if(level<7) image.setImageLevel(++level);}
}
