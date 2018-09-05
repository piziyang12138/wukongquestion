package com.neusoft.Service;

import com.neusoft.bean.Article;
import com.neusoft.bean.Articlecategory;
import com.neusoft.mapper.ArticleMapper;
import com.neusoft.mapper.ArticlecategoryMapper;
import com.neusoft.mapper.CommentInfoMapper;
import com.neusoft.mapper.UserMapper;
import com.neusoft.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ArticleService {
    SqlSession sqlSession;
    private UserMapper userMapper;
    private ArticleMapper articleMapper;
    private CommentInfoMapper commentInfoMapper;
    private ArticlecategoryMapper articlecategoryMapper;
    private ArticlecategoryService articlecategoryService;
    public ArticleService(){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        articleMapper = sqlSession.getMapper(ArticleMapper.class);
        commentInfoMapper = sqlSession.getMapper(CommentInfoMapper.class);
        articlecategoryMapper = sqlSession.getMapper(ArticlecategoryMapper.class);
        articlecategoryService = new ArticlecategoryService();
    }

    public int addArticle(Article article, Articlecategory articlecategory){
        Article article1 = articleMapper.isArticleExsit(article);
        if (article1 != null){
            articlecategory.setArticleid(article1.getAid());
            return articlecategoryService.addArticlecategory(articlecategory);
        }else{
            articleMapper.addArticle(article);
            articlecategory.setArticleid(article.getAid());
            return articlecategoryService.addArticlecategory(articlecategory);
        }
    }
    public Article queryArticleByTitle(String title){
        return articleMapper.queryArticleByTitle(title);
    }

    public List<Article> queryAllArticle(){
        return articleMapper.queryAllArticle();
    }

}
