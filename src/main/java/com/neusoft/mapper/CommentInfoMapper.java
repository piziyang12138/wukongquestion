package com.neusoft.mapper;

import com.neusoft.bean.CommentInformation;
import com.neusoft.bean.Commentinfo;

import java.util.List;

public interface CommentInfoMapper {
    int addComment(Commentinfo commentinfo);
    List<CommentInformation> queryCommentByAid(int aid);
    List<CommentInformation> queryCommentInfoById(int id);
}
