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

public class StudentSignInActivity extends BaseActivity {

    private MyDatabaseHelper dbHelper;

    private EditText mStudentID,mStudentPassword,mAuthCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_in);
        initNavBar(true,"学生注册",false);
        dbHelper = new MyDatabaseHelper(this,"Users.db",null,2);
        mStudentID = findViewById(R.id.edit_set_studentid);
        mStudentPassword = findViewById(R.id.edit_set_studentpassword);
//        mAuthCode = findViewById(R.id.edit_authCode);
    }

    public void studentSignIn(View V) {

        String username = mStudentID.getText().toString();
        String password = mStudentPassword.getText().toString();
//        String authCode = mAuthCode.getText().toString();
        Boolean flag = false;

        SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//        Cursor cursor = db.query("authCode", null, null, null, null, null, null);
//
//        if (cursor.moveToNext()) {
//            Log.i("shujuku", "-----1-----");
//            cursor.moveToPrevious();
//            while (cursor.moveToNext()) {
//                String auth = cursor.getString(cursor.getColumnIndex("authCode"));
//                Log.i("chaxun:", auth);
//                if (authCode.equals(auth)) {
//                    flag = true;
//                }
//            }

//            if (flag == true) {

                Cursor ID = db.query("student", new String[]{"id"}, "id>=0", null, null, null, null);
                int id = 0;
                while (ID.moveToNext()) {
                    id = ID.getInt(ID.getColumnIndex("id"));
                }
                id++;

                ContentValues values = new ContentValues();
                values.put("id", id);
                values.put("username", username);
                values.put("password", password);

                long result = db.insert("student", null, values);

                if (result > 0) {
                    Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                } else {
                    Toast.makeText(this, "注册失败！", Toast.LENGTH_SHORT).show();
                }

                Log.i("tag", "-----学生注册-----");
                db.close();

//            } else {
//                Toast.makeText(this, "授权码输入错误！", Toast.LENGTH_SHORT).show();
//            }
//        }
    }

}
