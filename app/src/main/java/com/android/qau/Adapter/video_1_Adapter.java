package com.android.qau.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.qau.Helper.video_1_helper;
import com.android.qau.R;

import java.util.List;

public class video_1_Adapter extends BaseAdapter {
    private Context context;
    private List<video_1_helper> list;

    public video_1_Adapter(Context context, List<video_1_helper> list) {
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
        View thisView = View.inflate(context, R.layout.video_1_item,null);
        TextView textView = thisView.findViewById(R.id.tv_video_1);
        ImageView imageView = thisView.findViewById(R.id.iv_video_1);
        textView.setText(list.get(i).getVideo_1_name());
        //imageView.setBackgroundResource(list.get(i).getVideo_1_img());
        return thisView;
    }
}
