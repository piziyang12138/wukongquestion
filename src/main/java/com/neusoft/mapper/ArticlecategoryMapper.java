package com.neusoft.mapper;

import com.neusoft.bean.Article;
import com.neusoft.bean.Articlecategory;

public interface ArticlecategoryMapper {
    int addArticlecategory(Articlecategory articlecategory);
    Articlecategory isArticlecategoryExist(Articlecategory articlecategory);
}
