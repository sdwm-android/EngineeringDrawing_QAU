package com.android.qau.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.qau.Helper.video_2_helper;
import com.android.qau.R;

import java.util.List;

public class video_2_Adapter extends BaseAdapter {

    private Context context;
    private List<video_2_helper> list;

    public video_2_Adapter(Context context, List<video_2_helper> list) {
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
        View myView = View.inflate(context, R.layout.video_2_item,null);
        TextView textView = myView.findViewById(R.id.tv_video_2_name);
        textView.setText(list.get(i).getVideo_2_name());
        return  myView;
    }
}
