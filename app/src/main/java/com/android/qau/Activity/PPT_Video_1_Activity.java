package com.android.qau.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.core.app.ActivityCompat;

import com.android.qau.Adapter.video_1_Adapter;
import com.android.qau.BaseActivity;
import com.android.qau.Helper.video_1_helper;
import com.android.qau.R;

import java.util.ArrayList;
import java.util.List;

public class PPT_Video_1_Activity extends BaseActivity implements AdapterView.OnItemClickListener {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE" };

    private ListView lv_video_1;
    private List<video_1_helper> list;
    private int [] video_name = {R.string.ch10,R.string.ch1,R.string.ch2,R.string.ch3,R.string.ch4,R.string.ch5,R.string.ch6,R.string.ch7,R.string.ch8,R.string.ch9};
    private int [] video_img = {R.drawable.a1,R.drawable.b1,R.drawable.c1,R.drawable.d1,R.drawable.e1,R.drawable.f1,R.drawable.g1,R.drawable.h1,R.drawable.i1,R.drawable.j1};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppt);
        initNavBar(true,"教学课件",true);
        PermissionGet(this);
        lv_video_1 = findViewById(R.id.lv_video_1);
        initList();
        video_1_Adapter video_1_adapter = new video_1_Adapter(PPT_Video_1_Activity.this,list);
        lv_video_1.setAdapter(video_1_adapter);
        lv_video_1.setOnItemClickListener(this);
    }

    public void initList(){
        list = new ArrayList<>();
        for (int i=0;i<video_name.length;i++){
            list.add(new video_1_helper(video_name[i],video_img[i]));
            Log.i("MyImage", String.valueOf(video_img[i]));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Bundle bundle = new Bundle();
        bundle.putInt("video_1_number",i);
        Intent intent = new Intent(PPT_Video_1_Activity.this, PPT_Video_2_Activity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public static void PermissionGet(Activity activity){
        int PermissionId = ActivityCompat.checkSelfPermission(activity,"android.permission.WRITE_EXTERNAL_STORAGE");
        if(PermissionId != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity,PERMISSIONS_STORAGE,REQUEST_EXTERNAL_STORAGE);
        }
    }
}
