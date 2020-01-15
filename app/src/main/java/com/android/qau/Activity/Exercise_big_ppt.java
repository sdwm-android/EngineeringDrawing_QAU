package com.android.qau.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.qau.R;

public class Exercise_big_ppt extends AppCompatActivity {

    private String[] keys = {"aa","bb","cc","dd","ee","ff","gg","hh","ii"};
    private int thisNumber;
    private int thisPPTNumber;
    private int pptSum;
    ImageButton im_forward;
    ImageButton im_back;
    ImageButton im_go;
    TextView tv_number;
    int PPTNumber =1;
    String packageName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ppt_big);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        thisNumber = bundle.getInt("thisNumber");
        thisPPTNumber = bundle.getInt("thisPPTNumber");
        pptSum = bundle.getInt("pptSum");
        im_forward = findViewById(R.id.im_ppt_forward);
        im_go = findViewById(R.id.im_ppt_go);
        im_back = findViewById(R.id.im_ppt_back);
        tv_number = findViewById(R.id.tv_number);
        im_forward.setBackgroundResource(getResources().getIdentifier(keys[thisNumber]+(thisPPTNumber+1),"drawable",this.getPackageName()));
        packageName = this.getPackageName();
        PPTNumber = thisPPTNumber+1;
        tv_number.setText(PPTNumber+"/"+pptSum);
        im_forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (PPTNumber==pptSum){
                    Toast.makeText(Exercise_big_ppt.this, "这是最后一张了", Toast.LENGTH_SHORT).show();
                }else {
                    PPTNumber++;
                    im_forward.setBackgroundResource(getResources().getIdentifier(keys[thisNumber] + PPTNumber, "drawable", packageName));
                    tv_number.setText(PPTNumber+"/"+pptSum);
                }
            }
        });
        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (PPTNumber==1){
                    Toast.makeText(Exercise_big_ppt.this, "这是第一张了", Toast.LENGTH_SHORT).show();
                }else {
                    PPTNumber--;
                    im_forward.setBackgroundResource(getResources().getIdentifier(keys[thisNumber] + PPTNumber, "drawable", packageName));
                    tv_number.setText(PPTNumber+"/"+pptSum);
                }
            }
        });
        im_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (PPTNumber==pptSum){
                    Toast.makeText(Exercise_big_ppt.this, "这是最后一张了", Toast.LENGTH_SHORT).show();
                }else {
                    PPTNumber++;
                    im_forward.setBackgroundResource(getResources().getIdentifier(keys[thisNumber] + PPTNumber, "drawable", packageName));
                    tv_number.setText(PPTNumber+"/"+pptSum);
                }
            }
        });
    }
}
