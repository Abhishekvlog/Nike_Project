package com.example.nike;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import SignAndLogin.Login;
import SignAndLogin.SigIn;

public class Dashboard extends AppCompatActivity {
    private VideoView mtvSplashVideo;
    private Button mbtnJoinUs;
    private Button mbtnSignIn;
    private VideoView videoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initViews();
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.splash_video);

        videoview.setVideoURI(uri);
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        videoview.start();

       mbtnSignIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(Dashboard.this, SigIn.class);
               startActivity(intent);
           }
       });
        mbtnJoinUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Login.class);
                startActivity(intent);
            }
        });


    }

    private void initViews() {
        mtvSplashVideo=findViewById(R.id.tvsplashvideo);
        mbtnSignIn = findViewById(R.id.btnsignin);
        mbtnJoinUs = findViewById(R.id.btnjoinus);
        videoview = findViewById(R.id.tvsplashvideo);
    }

}