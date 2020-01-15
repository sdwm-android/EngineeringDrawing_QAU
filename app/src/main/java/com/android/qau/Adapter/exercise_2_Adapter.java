package com.android.qau.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.android.qau.Helper.exercise_2_helper;
import com.android.qau.R;

import java.util.List;

public class exercise_2_Adapter extends BaseAdapter {

    Context context;
    List<exercise_2_helper> list;

    public exercise_2_Adapter(Context context, List<exercise_2_helper> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View thisView = View.inflate(context, R.layout.exercise_2_item,null);
        ImageView imageView = thisView.findViewById(R.id.exercise_2_image);
        imageView.setBackgroundResource(list.get(i).getImg_exercise());
        return thisView;
    }
}
