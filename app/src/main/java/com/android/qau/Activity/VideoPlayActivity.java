package com.android.qau.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.android.qau.BaseActivity;
import com.android.qau.Helper.unKey;
import com.android.qau.R;

public class VideoPlayActivity extends BaseActivity {
    private VideoView myVideo;
    private int videoName;
    private int videoPlayURI;
    private MediaController mediaController;
    private int videoNumber;
    private int number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_play);
        initNavBar(true,"视频播放",false);
        myVideo = findViewById(R.id.myVideo);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        videoNumber = bundle.getInt("thisVideoNumber");
        videoName = bundle.getInt("thisVideo");
        number = bundle.getInt("Number");
        if (videoNumber == 0){
            Intent intent1 = new Intent(VideoPlayActivity.this,PPT_Activity.class);
            Bundle bundle1 = new Bundle();
            bundle1.putInt("Number",number);
            intent1.putExtras(bundle1);
            startActivity(intent1);
        }else {
            unKey unkey = new unKey(videoName);
            videoPlayURI = unkey.decode();
            myVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + videoPlayURI));
            mediaController = new MediaController(this);
            myVideo.setMediaController(mediaController);
            myVideo.requestFocus();
        }
    }
}
