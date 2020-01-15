package com.android.qau.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.android.qau.Helper.ppt_1_helper;
import com.android.qau.R;

import java.util.List;

public class ppt_1_adapter extends BaseAdapter {

    List<ppt_1_helper> list;
    Context context;

    public ppt_1_adapter(List<ppt_1_helper> list, Context context) {
        this.list = list;
        this.context = context;
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
        View thisView = View.inflate(context, R.layout.ppt_1_item,null);
        ImageView imageView = thisView.findViewById(R.id.ppt_item);
        imageView.setBackgroundResource(list.get(i).getPpt_img());
        return thisView;
    }
}
