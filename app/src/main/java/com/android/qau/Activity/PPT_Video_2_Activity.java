package com.android.qau.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.qau.Adapter.video_2_Adapter;
import com.android.qau.BaseActivity;
import com.android.qau.Helper.video_2_helper;
import com.android.qau.R;

import java.util.ArrayList;
import java.util.List;

public class PPT_Video_2_Activity extends BaseActivity implements AdapterView.OnItemClickListener {

    private List<video_2_helper> list;
    private ListView lv_listview_2;
    private int CH1_name[] = {R.string.ch1_1,R.string.ch1_2,R.string.ch1_3,R.string.ch1_4,R.string.ch1_5,R.string.ch1_6,R.string.ch1_7,R.string.ch1_8,R.string.ch1_9,R.string.ch1_10,R.string.ch1_11,R.string.ch1_12,R.string.ch1_13,R.string.ch1_14,R.string.ch1_15,R.string.ch1_16,R.string.ch1_17,R.string.ch1_18,R.string.ch1_19,R.string.ch1_20};
    private int CH7_name[] = {R.string.ch7_1,R.string.ch7_2,R.string.ch7_3,R.string.ch7_4,R.string.ch7_5,R.string.ch7_6,R.string.ch7_7};
    private int CH8_name[] = {R.string.ch8_1,R.string.ch8_2,R.string.ch8_3,R.string.ch8_4,R.string.ch8_5};
    private String [] ppt_name = {"ch2点直线平面的投影PPT","ch3立体的投影PPT","ch4组合体的视图PPT","ch5轴测投影图PPT","ch6图样画法PPT","ch8零件图PPT","ch9装配图PPT","第七章:标准件与常用件PPT","基本知识PPT","绪论PPT"};
    private int [] ppt_name_int = {R.string.ppt_0,R.string.ppt_1,R.string.ppt_2,R.string.ppt_3,R.string.ppt_4,R.string.ppt_5,R.string.ppt_6,R.string.ppt_7,R.string.ppt_8,R.string.ppt_9};
    private int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_2);
        initNavBar(true,"教学课件",true);
        lv_listview_2 = findViewById(R.id.lv_video_2);
        lv_listview_2.setOnItemClickListener(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        number = bundle.getInt("video_1_number");
        switch (number){
            case 0:
                initList9();
                break;
            case 1:
                initList0();
                break;
            case 2:
                initList1();
                break;
            case 3:
                initList2();
                break;
            case 4:
                initList3();
                break;
            case 5:
                initList4();
                break;
            case 6:
                initList5();
                break;
            case 7:
                initList6();
                break;
            case 8:
                initList7();
                break;
            case 9:
                initList8();
                break;
            default:
                break;
        }
        video_2_Adapter video_2_adapter = new video_2_Adapter(PPT_Video_2_Activity.this,list);
        lv_listview_2.setAdapter(video_2_adapter);
    }
    public void initList0(){
        list = new ArrayList<>();
        list.add(new video_2_helper(ppt_name_int[8]));
        for (int i=0;i<CH1_name.length;i++){
            list.add(new video_2_helper(CH1_name[i]));
        }
    }

    public void initList1(){
        list = new ArrayList<>();
        list.add(new video_2_helper(ppt_name_int[0]));
    }

    public void initList2(){
        list = new ArrayList<>();
        list.add(new video_2_helper(ppt_name_int[1]));
    }

    public void initList3(){
        list = new ArrayList<>();
        list.add(new video_2_helper(ppt_name_int[2]));
    }

    public void initList4(){
        list = new ArrayList<>();
        list.add(new video_2_helper(ppt_name_int[3]));
    }

    public void initList5(){
        list = new ArrayList<>();
        list.add(new video_2_helper(ppt_name_int[4]));
    }

    private void initList6(){
        list = new ArrayList<>();
        list.add(new video_2_helper(ppt_name_int[7]));
        for (int i=0;i<CH7_name.length;i++){
            list.add(new video_2_helper(CH7_name[i]));
        }
    }

    private void initList7(){
        list = new ArrayList<>();
        list.add(new video_2_helper(ppt_name_int[5]));
        for (int i=0;i<CH8_name.length;i++){
            list.add(new video_2_helper(CH8_name[i]));
        }
    }

    public void initList8(){
        list = new ArrayList<>();
        list.add(new video_2_helper(ppt_name_int[6]));
    }

    public void initList9(){
        list = new ArrayList<>();
        list.add(new video_2_helper(ppt_name_int[9]));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        if (i == 0){
            Intent intent1 = new Intent(PPT_Video_2_Activity.this,PPT_Activity.class);
            Bundle bundle1 = new Bundle();
            bundle1.putInt("Number",number);
            intent1.putExtras(bundle1);
            startActivity(intent1);
        }else{
            Bundle bundle = new Bundle();
            bundle.putInt("thisVideo",list.get(i).getVideo_2_name());
            bundle.putInt("thisVideoNumber",i);
            bundle.putInt("Number",number);
            Intent intent = new Intent(PPT_Video_2_Activity.this,VideoPlayActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }





}
