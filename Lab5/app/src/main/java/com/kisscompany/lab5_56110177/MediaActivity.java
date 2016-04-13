package com.kisscompany.lab5_56110177;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;


public class MediaActivity extends AppCompatActivity {

    private VideoView myVideoV;
    private String VideoURL = "http://www.w3schools.com/html/mov_bbb.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        myVideoV = (VideoView)findViewById(R.id.videoView1);
        myVideoV.setVideoURI(Uri.parse("android.resource://" + getPackageName() +"/"+R.raw.video1));
       //String url = "http://www.somedomain.com/samplevideo.mp4";
       // myVideoV.setVideoURI(Uri.parse(url));
        myVideoV.setMediaController(new MediaController(this));
        myVideoV.requestFocus();
        myVideoV.start();




    }
}
