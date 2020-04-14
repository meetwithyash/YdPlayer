package com.dcdhameliya.dc_player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ykhokhaneshiya.dcdhameliya.ydplayer.YdPlayer;

public class MainActivity extends AppCompatActivity {

    YdPlayer ydPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        ydPlayer = findViewById(R.id.yd_video);
        ydPlayer.setUp(this, "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4", "Local Video");
        Glide.with(this).load("https://cdn.vox-cdn.com/thumbor/Pkmq1nm3skO0-j693JTMd7RL0Zk=/0x0:2012x1341/1200x800/filters:focal(0x0:2012x1341)/cdn.vox-cdn.com/uploads/chorus_image/image/47070706/google2.0.0.jpg").into(ydPlayer.posterImageView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ydPlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ydPlayer.start();
    }
}