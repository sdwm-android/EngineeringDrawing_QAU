package com.android.qau.Page;

import android.os.Bundle;

import com.android.qau.BaseActivity;
import com.android.qau.R;

public class TestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initNavBar(true,"题库",true);
    }
}
