package com.android.qau;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.qau.Login.ActivityCollector;
import com.android.qau.Login.MeActivity;

public class BaseActivity extends Activity {

    private ImageView mIvBack,mIvUser;
    private TextView mTvTitle;
    private int a;
    static private String user;

    protected void initNavBar (boolean isShowBack,String title,boolean isShowUser) {

        mIvBack  = findViewById(R.id.iv_back);
        mIvUser = findViewById(R.id.iv_user);
        mTvTitle = findViewById(R.id.tv_title);

        mIvBack.setVisibility(isShowBack ? View.VISIBLE : View.GONE);
        mIvUser.setVisibility(isShowUser ? View.VISIBLE : View.GONE);
        mTvTitle.setText(title);

        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        }) ;

        mIvUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaseActivity.this,MeActivity.class));
            }
        });
        ActivityCollector.addActivity(this);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    public void setData (int data){
        if (data == 1){
            user = "teacher";
        }else{
            user = "student";
        }
        Log.i("BaseUser","user=====>"+user);
    }

    public String getUser(){
        Log.i("getUser","user22222=====>"+user);
        return user;
    }
}
