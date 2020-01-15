package com.android.qau.Login;

import android.content.ContentValues;
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

public class TeacherSignInActivity extends BaseActivity {

    private MyDatabaseHelper dbHelper;

    private EditText mTeacherID,mTeacherPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_sign_in);
        initNavBar(true,"教师注册",false);
        dbHelper = new MyDatabaseHelper(this,"Users.db",null,2);
        mTeacherID = findViewById(R.id.edit_set_teacherid);
        mTeacherPassword = findViewById(R.id.edit_set_teacherpassword);
    }

    public void teacherSignIn(View V){

        String username = mTeacherID.getText().toString();
        String password = mTeacherPassword.getText().toString();

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor ID =db.query("teacher",new String[]{"id"},"id>=0",null,null,null,null);
        int id = 0;
        while (ID.moveToNext()){
            id = ID.getInt(ID.getColumnIndex("id"));
        }
        id++;

        ContentValues values = new ContentValues();
        values.put("id",id);
        values.put("username",username);
        values.put("password",password);

        long result = db.insert("teacher",null,values);
        if (result>0){
            Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "注册失败！", Toast.LENGTH_SHORT).show();
        }

        Log.i("tag","-----教师注册-----");
        db.close();
        onBackPressed();

    }

}
