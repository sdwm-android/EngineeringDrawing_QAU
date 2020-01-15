package com.android.qau.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.qau.Adapter.exercise_2_Adapter;
import com.android.qau.BaseActivity;
import com.android.qau.Helper.exercise_2_helper;
import com.android.qau.R;

import java.util.ArrayList;
import java.util.List;

public class Exercise_2 extends BaseActivity implements AdapterView.OnItemClickListener {
    private List<exercise_2_helper> list;
    private String[] index = {"aa","bb","cc","dd","ee","ff","gg","hh","ii"};
    private int [] pagesNumber = {8,10,6,14,8,18,18,15,8};
    private int thisPages;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_2);
        initNavBar(true,"习题及答案",true);
        listView = findViewById(R.id.listview_exercise_2);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        thisPages = bundle.getInt("thisPage");
        init(index[thisPages],pagesNumber[thisPages]);
        exercise_2_Adapter adapter = new exercise_2_Adapter(Exercise_2.this,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    private void init(String index,int thisInt){
        list = new ArrayList<>();
        for (int i=0;i<thisInt;i++) {
            int res = getResources().getIdentifier(index+(i+1),"drawable",this.getPackageName());
            list.add(new exercise_2_helper(res));
        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(Exercise_2.this,Exercise_big_ppt.class);
        Bundle bundle = new Bundle();
        bundle.putInt("thisNumber",thisPages);
        bundle.putInt("thisPPTNumber",i);
        bundle.putInt("pptSum",pagesNumber[thisPages]);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
