package com.android.qau.Activity;

public class Forum {

    private int imageId;
    private String forum;

    public Forum(int imageId,String forum){
        this.imageId = imageId;
        this.forum = forum;
    }

    public int getImageId() {
        return imageId;
    }

    public String getForum() {
        return forum;
    }
}
