package com.android.qau.Login;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.qau.BaseActivity;
import com.android.qau.Helper.MyDatabaseHelper;
import com.android.qau.Page.IosAlertDialog;
import com.android.qau.R;



public class MeActivity extends BaseActivity {

    private MyDatabaseHelper dbHelper;

    private EditText musername,mOldPassword,mNewPassword,mNewPasswordAffirm;

    private String data="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        initNavBar(true,"用户",false);
        dbHelper = new MyDatabaseHelper(this,"Users.db",null,2);
        musername = findViewById(R.id.edit_username);
        mOldPassword = findViewById(R.id.edit_old_password);
        mNewPassword = findViewById(R.id.edit_new_password);
        mNewPasswordAffirm = findViewById(R.id.edit_new_password_affirm);
        data = getUser();
        Log.i("data=====>","data=====>"+data);
    }

    public void setText(){

    }

    public void teacherDate(View V){


        switch (V.getId()){

            case R.id.btn_update:

                new IosAlertDialog(MeActivity.this).builder().setTitle("确认修改密码")
                        .setMsg("修改密码后，下次登陆请使用新密码！")
                        .setPositiveButton("确认", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                changeAccount(1,data);
                            }
                        }).setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();

                break;

            case R.id.btn_delete:

                new IosAlertDialog(MeActivity.this).builder().setTitle("注销当前账号")
                        .setMsg("注销后再次使用请重新注册")
                        .setPositiveButton("确认", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                changeAccount(2,data);
                            }
                        }).setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();

                break;

        }

    }


    public void changeAccount (int intention,String data){

        String username = musername.getText().toString();
        String oldPassword = mOldPassword.getText().toString();
        String newPassword = mNewPassword.getText().toString();
        String newPsswordAffifm = mNewPasswordAffirm.getText().toString();
        String table = data;

        if (intention == 1) {

            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues cv = new ContentValues();
            cv.put("password", newPassword);
            int count = db.update(data, cv, "username=" + username, null);
            if (count > 0) {
                Toast.makeText(this, "修改成功！", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "修改失败！", Toast.LENGTH_SHORT).show();
            }
            db.close();
            Log.i("tag", "-----teacherUpdate-----");
        }else {

            SQLiteDatabase db = dbHelper.getWritableDatabase();

            db = dbHelper.getWritableDatabase();

            int countt = db.delete("teacher","username="+username,null);
            if (countt>0){
                Toast.makeText(this, "注销成功！", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "注销失败！", Toast.LENGTH_SHORT).show();
            }
            db.close();
            Log.i("tag","-----delete-----");

        }
    }

}
