package com.android.qau.Helper;

import com.android.qau.R;

public class unKey {
    private int videoName;
    private int CH1_name[] = {R.string.ch1_1,R.string.ch1_2,R.string.ch1_3,R.string.ch1_4,R.string.ch1_5,R.string.ch1_6,R.string.ch1_7,R.string.ch1_8,R.string.ch1_9,R.string.ch1_10,R.string.ch1_11,R.string.ch1_12,R.string.ch1_13,R.string.ch1_14,R.string.ch1_15,R.string.ch1_16,R.string.ch1_17,R.string.ch1_18,R.string.ch1_19,R.string.ch1_20};
    private int CH7_name[] = {R.string.ch7_1,R.string.ch7_2,R.string.ch7_3,R.string.ch7_4,R.string.ch7_5,R.string.ch7_6,R.string.ch7_7};
    private int CH8_name[] = {R.string.ch8_1,R.string.ch8_2,R.string.ch8_3,R.string.ch8_4,R.string.ch8_5};


    private int CH1_name_decode[] = {R.raw.a,R.raw.b,R.raw.c,R.raw.d,R.raw.e,R.raw.f,R.raw.g,R.raw.h,R.raw.i,R.raw.j,R.raw.k,R.raw.l,R.raw.m,R.raw.n,R.raw.o,R.raw.p,R.raw.q,R.raw.r,R.raw.s,R.raw.t,};
    private int CH7_name_decode[] = {R.raw.aaa,R.raw.aab,R.raw.aac,R.raw.aad,R.raw.aae,R.raw.aaf,R.raw.aag};
    private int CH8_name_decode[] = {R.raw.aah,R.raw.aai,R.raw.aaj,R.raw.aak,R.raw.aal};




    private Boolean isFind = true;


    public unKey(int videoName) {
        this.videoName = videoName;
    }

    public int decode(){
        int afterDecode=0;
        while (isFind){
            for (int i=0;i<CH1_name.length;i++){
                if (CH1_name[i] == videoName){
                    afterDecode = CH1_name_decode[i];
                    isFind = false;
                }
            }
            for (int i=0;i<CH7_name.length;i++){
                if (CH7_name[i] == videoName){
                    afterDecode = CH7_name_decode[i];
                    isFind = false;
                }
            }
            for (int i=0;i<CH8_name.length;i++){
                if (CH8_name[i] == videoName){
                    afterDecode = CH8_name_decode[i];
                    isFind = false;
                }
            }
        }
        return  afterDecode;
    }

}
