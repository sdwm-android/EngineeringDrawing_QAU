package com.android.qau.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_TEACHER = "create table Teacher(" +
            "id Integer primary key autoincrement," +
            "username text," +
            "password text)";
    public static final String CREATE_STUDENT = "create table student(" +
            "id Integer primary key autoincrement," +
            "username text," +
            "password text)";
    public static final String CREATE_AUTH_CUDE = "create table authCode(" +
            "id Integer primary key autoincrement," +
            "authCode Integer)";

    private Context mContext;

    public MyDatabaseHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version){
        super(context, "Users.db",null,1);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TEACHER);
        db.execSQL(CREATE_STUDENT);
        db.execSQL(CREATE_AUTH_CUDE);
        int a[] = {1219,1517,1219,1611,8576,8624,9756,9634,9856,7452};

        for (int i=0;i<a.length;i++) {
            db.execSQL("insert into authCode(id,authCode) values("+i+","+a[i]+")");
        }
        Log.i("tag","-----数据库创建成功-----");

//        ContentValues values = new ContentValues();
//        for (int i=0 ;i<a.length;i++){
//            values.put("id",i);
//            values.put("authCode",a[i]);
//        }
//        db.update("authCode",values,"authCode=?",null);
        Log.i("tag","-----验证码添加成功-----");

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i("tag","-----onUpgrade-----");
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.i("tag","-----onOpen-----");
    }
}
