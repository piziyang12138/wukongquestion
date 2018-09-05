package com.neusoft.bean;

/**
 * Created by ttc on 2018/7/20.
 */
public class CommentInformation extends Commentinfo {
    private String username;
    private String picpath;
    private String atitle;
    private int arescount;
    private int aid;
    private boolean hasFollowed = false;
    private int likecount;
    private int unlikecount;
    private boolean islike;
    private boolean isunlike;

    public boolean isIslike() {
        return islike;
    }

    public void setIslike(boolean islike) {
        this.islike = islike;
    }

    public boolean isIsunlike() {
        return isunlike;
    }

    public void setIsunlike(boolean isunlike) {
        this.isunlike = isunlike;
    }

    public int getLikecount() {
        return likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }

    public int getUnlikecount() {
        return unlikecount;
    }

    public void setUnlikecount(int unlikecount) {
        this.unlikecount = unlikecount;
    }

    public boolean isHasFollowed() {
        return hasFollowed;
    }

    public void setHasFollowed(boolean hasFollowed) {
        this.hasFollowed = hasFollowed;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAtitle() {
        return atitle;
    }

    public void setAtitle(String atitle) {
        this.atitle = atitle;
    }

    public int getArescount() {
        return arescount;
    }

    public void setArescount(int arescount) {
        this.arescount = arescount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }
}
