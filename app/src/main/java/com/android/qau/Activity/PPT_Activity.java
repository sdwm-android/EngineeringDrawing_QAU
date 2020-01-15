package com.android.qau.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.qau.Adapter.ppt_1_adapter;
import com.android.qau.BaseActivity;
import com.android.qau.Helper.ppt_1_helper;
import com.android.qau.R;

import java.util.ArrayList;
import java.util.List;

public class PPT_Activity extends BaseActivity implements AdapterView.OnItemClickListener {

    private int number;
    private List<ppt_1_helper> list;
    private int [] ppt_sum = {11,54,49,53,69,42,65,74,93,67};
    private int [] a_img = {R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a11};
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ppt_activity);
        initNavBar(true,"教学PPT",false);
        listView = findViewById(R.id.ppt_1_listview);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        number = bundle.getInt("Number");
        listView.setOnItemClickListener(this);
        switch (number){
            case 0:
                list0();
                break;
            case 1:
                list1();
                break;
            case 2:
                list2();
                break;
            case 3:
                list3();
                break;
            case 4:
                list4();
                break;
            case 5:
                list5();
                break;
            case 6:
                list6();
                break;
            case 7:
                list7();
                break;
            case 8:
                list8();
                break;
            case 9:
                list9();
                break;
        }

        ppt_1_adapter ppt_1_adapter_this = new ppt_1_adapter(list,this);
        listView.setAdapter(ppt_1_adapter_this);



    }

    private void list0(){
        list = new ArrayList<>();
        for (int i=0;i<11;i++){
            list.add(new ppt_1_helper(a_img[i]));
        }
    }

    private void list1(){
        list = new ArrayList<>();
        for (int i=0;i<54;i++){
            int resID = getResources().getIdentifier("b"+(i+1), "drawable",this.getPackageName() );
            list.add(new ppt_1_helper(resID));
        }
    }

    private void list2(){
        list = new ArrayList<>();
        for (int i=0;i<49;i++){
            int resID = getResources().getIdentifier("c"+(i+1), "drawable",this.getPackageName() );
            list.add(new ppt_1_helper(resID));
        }
    }

    private void list3(){
        list = new ArrayList<>();
        for (int i=0;i<53;i++){
            int resID = getResources().getIdentifier("d"+(i+1), "drawable",this.getPackageName() );
            list.add(new ppt_1_helper(resID));
        }
    }

    private void list4(){
        list = new ArrayList<>();
        for (int i=0;i<69;i++){
            int resID = getResources().getIdentifier("e"+(i+1), "drawable",this.getPackageName() );
            list.add(new ppt_1_helper(resID));
        }
    }

    private void list5(){
        list = new ArrayList<>();
        for (int i=0;i<42;i++){
            int resID = getResources().getIdentifier("f"+(i+1), "drawable",this.getPackageName() );
            list.add(new ppt_1_helper(resID));
        }
    }

    private void list6(){
        list = new ArrayList<>();
        for (int i=0;i<65;i++){
            int resID = getResources().getIdentifier("g"+(i+1), "drawable",this.getPackageName() );
            list.add(new ppt_1_helper(resID));
        }
    }

    private void list7(){
        list = new ArrayList<>();
        for (int i=0;i<74;i++){
            int resID = getResources().getIdentifier("h"+(i+1), "drawable",this.getPackageName() );
            list.add(new ppt_1_helper(resID));
        }
    }

    private void list8(){
        list = new ArrayList<>();
        for (int i=0;i<93;i++){
            int resID = getResources().getIdentifier("i"+(i+1), "drawable",this.getPackageName() );
            list.add(new ppt_1_helper(resID));
        }
    }

    private void list9(){
        list = new ArrayList<>();
        for (int i=0;i<67;i++){
            int resID = getResources().getIdentifier("j"+(i+1), "drawable",this.getPackageName() );
            list.add(new ppt_1_helper(resID));
        }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        int thisNumber = number;
        Intent intent = new Intent(PPT_Activity.this,PPT_Big.class);
        Bundle bundle = new Bundle();
        bundle.putInt("thisNumber",thisNumber);
        bundle.putInt("thisPPTNumber",i);
        bundle.putInt("pptSum",ppt_sum[thisNumber]);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
