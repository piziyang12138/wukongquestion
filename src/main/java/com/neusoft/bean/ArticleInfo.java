package com.neusoft.bean;

import java.sql.Timestamp;

public class ArticleInfo extends Article {
    private int rescount;
    private String upicpath;
    private int collection_count;
    private Long cid;
    private Long comment_userid;
    private String content;
    private Timestamp createtime;
    private String chtml;
    private Long articleid;
    private Long fabulous;
    private Long tread;
    private String username;
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

    public Long getComment_userid() {
        return comment_userid;
    }

    public void setComment_userid(Long comment_userid) {
        this.comment_userid = comment_userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRescount() {
        return rescount;
    }

    public void setRescount(int rescount) {
        this.rescount = rescount;
    }

    public String getUpicpath() {
        return upicpath;
    }

    public void setUpicpath(String upicpath) {
        this.upicpath = upicpath;
    }

    public int getCollection_count() {
        return collection_count;
    }

    public void setCollection_count(int collection_count) {
        this.collection_count = collection_count;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public Timestamp getCreatetime() {
        return createtime;
    }

    @Override
    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getChtml() {
        return chtml;
    }

    public void setChtml(String chtml) {
        this.chtml = chtml;
    }

    public Long getArticleid() {
        return articleid;
    }

    public void setArticleid(Long articleid) {
        this.articleid = articleid;
    }

    public Long getFabulous() {
        return fabulous;
    }

    public void setFabulous(Long fabulous) {
        this.fabulous = fabulous;
    }

    public Long getTread() {
        return tread;
    }

    public void setTread(Long tread) {
        this.tread = tread;
    }
}
