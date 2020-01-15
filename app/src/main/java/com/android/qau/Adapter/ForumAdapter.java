package com.android.qau.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.qau.Activity.Forum;
import com.android.qau.R;

import java.util.List;

public class ForumAdapter extends ArrayAdapter<Forum> {

    public int resourceID;

    public ForumAdapter(@NonNull Context context, int textViewResourceId, List<Forum> objects) {
        super(context ,textViewResourceId,objects);
        resourceID = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Forum forum = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        ImageView forumImage = (ImageView) view.findViewById(R.id.forum_image);
        TextView forumForum = (TextView) view.findViewById(R.id.forum_forum);
        forumImage.setImageResource(forum.getImageId());
        forumForum.setText(forum.getForum());
        return view;
    }
}
