package com.neusoft.Service;

import com.neusoft.bean.Commentinfo;
import com.neusoft.mapper.ArticleMapper;
import com.neusoft.mapper.CommentInfoMapper;
import com.neusoft.mapper.UserMapper;
import com.neusoft.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class CommentInfoService {
    SqlSession sqlSession;
    private UserMapper userMapper;
    private ArticleMapper articleMapper;
    private CommentInfoMapper commentInfoMapper;
    public CommentInfoService(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        articleMapper = sqlSession.getMapper(ArticleMapper.class);
        commentInfoMapper = sqlSession.getMapper(CommentInfoMapper.class);
    }

    public int addComment(Commentinfo commentinfo){
        return commentInfoMapper.addComment(commentinfo);
    }
}
