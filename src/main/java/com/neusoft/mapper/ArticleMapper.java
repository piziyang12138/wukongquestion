package com.neusoft.mapper;

import com.neusoft.bean.Article;
import com.neusoft.bean.ArticleInfo;
import com.neusoft.bean.Commentinfo;
import com.neusoft.bean.User;

import java.util.List;

public interface ArticleMapper {
    int addArticle(Article article);
    List<ArticleInfo> queryArticleByPage();
    ArticleInfo queryArticleByAid(int aid);
    List<ArticleInfo> getMoreArticle(int aid);
    Article queryArticleByTitle(String title);
    Article isArticleExsit(Article article);
    int updateArticle(Article article);
    List<Article> queryAllArticle();
}
