package com.neusoft.bean;

public class UserInfo extends User {
    private int rescount;
    private int followedcount;
    private int followcount;

    public int getFollowcount() {
        return followcount;
    }

    public void setFollowcount(int followcount) {
        this.followcount = followcount;
    }

    public int getFollowedcount() {
        return followedcount;
    }

    public void setFollowedcount(int followedcount) {
        this.followedcount = followedcount;
    }

    public int getRescount() {
        return rescount;
    }

    public void setRescount(int rescount) {
        this.rescount = rescount;
    }


}
