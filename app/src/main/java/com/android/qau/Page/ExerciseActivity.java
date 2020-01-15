package com.android.qau.Page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.qau.Activity.Exercise_2;
import com.android.qau.Adapter.exercise_Adapter;
import com.android.qau.BaseActivity;
import com.android.qau.Helper.exercise_listview_helper;
import com.android.qau.R;

import java.util.ArrayList;
import java.util.List;

public class ExerciseActivity extends BaseActivity implements ListView.OnItemClickListener {

    private ListView listView_Exercise;
    private List<exercise_listview_helper> list;
    private int[] exercise_do = {R.string.do_1,R.string.do_2,R.string.do_3,R.string.do_4,R.string.do_5,R.string.do_6,R.string.do_7,R.string.do_8,R.string.do_9,R.string.do_10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        initNavBar(true,"习题及答案",true);
        init();
        listView_Exercise = findViewById(R.id.exercise_list);
        exercise_Adapter exercise_adapter = new exercise_Adapter(this,list);
        listView_Exercise.setAdapter(exercise_adapter);
        listView_Exercise.setOnItemClickListener(this);
    }

    private void init() {
        list = new ArrayList<exercise_listview_helper>();
        for (int i=0;i<10;i++){
            list.add(new exercise_listview_helper(exercise_do[i]));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(ExerciseActivity.this, Exercise_2.class);
        Bundle bundle = new Bundle();
        bundle.putInt("thisPage",i);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
