package com.neusoft.Service;

import com.neusoft.bean.Articlecategory;
import com.neusoft.mapper.ArticleMapper;
import com.neusoft.mapper.ArticlecategoryMapper;
import com.neusoft.mapper.CommentInfoMapper;
import com.neusoft.mapper.UserMapper;
import com.neusoft.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ArticlecategoryService {
    SqlSession sqlSession;
    private UserMapper userMapper;
    private ArticleMapper articleMapper;
    private CommentInfoMapper commentInfoMapper;
    private ArticlecategoryMapper articlecategoryMapper;
    public ArticlecategoryService(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        articleMapper = sqlSession.getMapper(ArticleMapper.class);
        commentInfoMapper = sqlSession.getMapper(CommentInfoMapper.class);
        articlecategoryMapper = sqlSession.getMapper(ArticlecategoryMapper.class);
    }

    public int addArticlecategory(Articlecategory articlecategory){
        Articlecategory articlecategory1 = articlecategoryMapper.isArticlecategoryExist(articlecategory);
        if (articlecategory1 != null){
            return 0;
        }else {
            return articlecategoryMapper.addArticlecategory(articlecategory);
        }
    }
}
