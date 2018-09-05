package com.neusoft.bean;

public class Follower {
  private Long fid;
  private Long followid;
  private Long followedid;

  public Long getFid() {
    return fid;
  }

  public void setFid(Long fid) {
    this.fid = fid;
  }

  public Long getFollowid() {
    return followid;
  }

  public void setFollowid(Long followid) {
    this.followid = followid;
  }

  public Long getFollowedid() {
    return followedid;
  }

  public void setFollowedid(Long followedid) {
    this.followedid = followedid;
  }
}
