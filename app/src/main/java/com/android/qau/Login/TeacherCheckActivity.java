package com.android.qau.Login;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.qau.BaseActivity;
import com.android.qau.Helper.MyDatabaseHelper;
import com.android.qau.R;

public class TeacherCheckActivity extends BaseActivity {

    private MyDatabaseHelper dbHelper;

    private EditText mTeacherID,mTeacherPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_check);
        initNavBar(true,"教师登陆",false);
        dbHelper = new MyDatabaseHelper(this,"Users.db",null,2);
        mTeacherID = findViewById(R.id.et_teacher_username);
        mTeacherPassword = findViewById(R.id.et_teacher_password);


    }

    public  void  onTeacherSingIn(View V){
        Intent intent = new Intent(this,TeacherSignInActivity.class);
        startActivity(intent);
    }

    public void onTeacherLogin (View V){

        String teacherID = mTeacherID.getText().toString();
        String teacherPassword = mTeacherPassword.getText().toString();
        Boolean flag = false;

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("teacher",null,null,null,null,null,null);
        if (cursor.moveToNext()){
            Log.i("shujuku","-----1-----");
            cursor.moveToPrevious();
            while (cursor.moveToNext()){
              String username = cursor.getString(cursor.getColumnIndex("username"));
              String password = cursor.getString(cursor.getColumnIndex("password"));
                Log.i("chaxun:",username);
                Log.i("chaxun:",password);
              if (teacherID.equals(username) && teacherPassword.equals(password)){
                  db.close();
                  Intent intent = new Intent(this, CheckAuthActivity.class);
                  startActivity(intent);
                  flag = true;
              }
            }
            if (flag == false){
                Toast.makeText(this, "账号或密码错误！", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "请先注册账号！", Toast.LENGTH_SHORT).show();
        }

    }
}
