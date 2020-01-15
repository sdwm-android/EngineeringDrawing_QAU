package com.android.qau.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.qau.Helper.exercise_listview_helper;
import com.android.qau.R;

import java.util.List;

public class exercise_Adapter extends BaseAdapter {

    private Context context;
    private List<exercise_listview_helper> list;


    public exercise_Adapter(Context context, List<exercise_listview_helper> list) {
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
        View thisView = View.inflate(context, R.layout.exercise_item,null);
        TextView textView = thisView.findViewById(R.id.exercise_item);
        textView.setText(list.get(i).getExercise_list_name());
        return thisView;
    }
}
