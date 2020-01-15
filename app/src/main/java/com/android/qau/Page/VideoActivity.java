package com.android.qau.Page;

import android.os.Bundle;

import com.android.qau.BaseActivity;
import com.android.qau.R;

public class VideoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        initNavBar(true,"教学视频",true);
    }
}
