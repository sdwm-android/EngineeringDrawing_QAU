package com.android.qau.Page;

import android.os.Bundle;
import android.widget.ListView;

import com.android.qau.Activity.Forum;
import com.android.qau.Adapter.ForumAdapter;
import com.android.qau.BaseActivity;
import com.android.qau.R;

import java.util.ArrayList;
import java.util.List;

public class ForumActivity extends BaseActivity {

    private List<Forum> forumList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        initNavBar(true,"讨论区",true);
        initForum();
        ForumAdapter adapter = new ForumAdapter(ForumActivity.this,R.layout.forum_item,forumList);
        ListView listView = (ListView) findViewById(R.id.lv_forum);
        listView.setAdapter(adapter);

    }

    private void initForum() {
        for (int i=0;i<1;i++){
            Forum user1 = new Forum(R.drawable.xiaohui,"透视图与轴测图：混淆不清（问题解决： 一个表格）");
            forumList.add(user1);
            Forum user2 = new Forum(R.drawable.xiaohui,"基本视图的学习：记住一个规律很方便");
            forumList.add(user2);
            Forum user3 = new Forum(R.drawable.xiaohui,"尺寸标注：多标漏标尺寸，令人头疼（问题解决办法：一个公式）");
            forumList.add(user3);
            Forum user4 = new Forum(R.drawable.xiaohui,"同坡屋顶画法：模棱两可（问题解决：45度偏转法）");
            forumList.add(user4);
            Forum user5 = new Forum(R.drawable.xiaohui,"几何体读图：多解情况 始料不及（问题解决：四点须知+一个措施）");
            forumList.add(user5);
            Forum user6 = new Forum(R.drawable.xiaohui,"由于视图中基本元素点、线、面含义的不确定性，我们有必要牢记以下四点须知：");
            forumList.add(user6);
            Forum user7 = new Forum(R.drawable.xiaohui,"六个视图一定能唯一确定的几何体形状？例外确实存在");
            forumList.add(user7);
        }
    }

}
