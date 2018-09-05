package com.neusoft.bean;


public class Commentinfo {

  private int cid;
  private int userid;
  private String content;
  private java.sql.Timestamp createtime;
  private String chtml;
  private int articleid;
  private int fabulous;
  private int tread;


  public int getCid() {
    return cid;
  }

  public void setCid(int cid) {
    this.cid = cid;
  }


  public int getUserid() {
    return userid;
  }

  public void setUserid(int userid) {
    this.userid = userid;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }


  public String getChtml() {
    return chtml;
  }

  public void setChtml(String chtml) {
    this.chtml = chtml;
  }


  public int getArticleid() {
    return articleid;
  }

  public void setArticleid(int articleid) {
    this.articleid = articleid;
  }


  public int getFabulous() {
    return fabulous;
  }

  public void setFabulous(int fabulous) {
    this.fabulous = fabulous;
  }


  public int getTread() {
    return tread;
  }

  public void setTread(int tread) {
    this.tread = tread;
  }

}
