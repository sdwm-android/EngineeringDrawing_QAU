package com.android.qau;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.qau.Login.ActivityCollector;
import com.android.qau.Login.StudentLoginActivity;
import com.android.qau.Login.TeacherCheckActivity;

public class WelcomeActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ActivityCollector.addActivity(this);
    }

    public void onTecherClick (View v){
        setData(1);
        Intent intent = new Intent(this, TeacherCheckActivity.class);
        startActivity(intent);
    }

    public void onStudentClick (View v){
        setData(2);
        Intent intent = new Intent(this, StudentLoginActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
