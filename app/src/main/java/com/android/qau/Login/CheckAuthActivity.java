package com.android.qau.Login;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.qau.BaseActivity;
import com.android.qau.Helper.MyDatabaseHelper;
import com.android.qau.MainActivity;
import com.android.qau.R;

public class CheckAuthActivity extends BaseActivity {

    private MyDatabaseHelper dbHelper;
    private EditText mAuth;

//    private TextView mTeacherAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chack_auth);
        initNavBar(true,"登陆验证",false);
//        mTeacherAuth = findViewById(R.id.tv_teacher_auth_code);
        mAuth = findViewById(R.id.et_auth_code);
        dbHelper = new MyDatabaseHelper(this,"User.db",null,1);
    }

    public void onChackAuth(View view){

        String authCode = mAuth.getText().toString();
        Boolean flag = false;

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query("authCode", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {

//            cursor.moveToPrevious();

            while (cursor.moveToNext()) {
                String auth = cursor.getString(cursor.getColumnIndex("authCode"));
                if (authCode.equals(auth)) {
                    flag = true;
                }
            }
        }
        if (flag){
            Toast.makeText(this, "验证成功!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "授权码输入错误!(请联系老师获取验证码!)", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClose(View view){
        ActivityCollector.finishAll();
//        System.exit(1);
    }


//    public void teacherRefAuth( View V){
//
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//        ArrayList<Integer> authList = new ArrayList<Integer>();
//
//        Cursor cursor = db.query("authCode",null,null,null,null,null,null);
//        Log.i("tag","-----验证码读取-----");
//        if (cursor.moveToFirst()){
//            Log.i("tag","------进入if-----");
//            int i=0;
//            do {
//                authList.add(cursor.getInt(cursor.getColumnIndex("authCode")));
//                Log.i("auth", String.valueOf(authList.get(i)));
//                i++;
//
//            }while (cursor.moveToNext());
//            Log.i("shuzuchangdu",String.valueOf(cursor.getCount()));
//            cursor.close();
//        }
//
//        Random random = new Random();
//        int a = random.nextInt(9);
//        Log.i("sujishu",String.valueOf(a));
//        mTeacherAuth.setText(String.valueOf(authList.get(a)));
//    }
//
//    public void teacherToMain(View V) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();
//    }




}
