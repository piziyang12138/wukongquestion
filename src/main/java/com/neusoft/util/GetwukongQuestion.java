package com.neusoft.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neusoft.Service.ArticleService;
import com.neusoft.Service.UserService;
import com.neusoft.bean.Article;
import com.neusoft.bean.Articlecategory;
import com.neusoft.bean.User;
import com.neusoft.fastdfsTemlate.FastDFSTemplate;
import com.neusoft.mapper.ArticleMapper;
import com.neusoft.mapper.CommentInfoMapper;
import com.neusoft.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class GetwukongQuestion {
    private UserMapper userMapper;
    private ArticleMapper articleMapper;
    private CommentInfoMapper commentInfoMapper;

    @BeforeEach
    public void init() {
//        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
//        sqlSession = sqlSessionFactory.openSession();
//        userMapper = sqlSession.getMapper(UserMapper.class);
//        articleMapper = sqlSession.getMapper(ArticleMapper.class);
//        commentInfoMapper = sqlSession.getMapper(CommentInfoMapper.class);

    }

    public Set<String> getquestion(String filename,String category,String url) throws IOException {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:spring-fastdfs.xml");
        FastDFSTemplate dfsTemplate = (FastDFSTemplate) beanFactory.getBean("fastDFSTemplate");
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserService userService = new UserService();
        ArticleService articleService = new ArticleService();
        SolrAdd solrAdd = new SolrAdd();
        FileWriter fileWriter = new FileWriter(filename, true);
//"https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6300775428692904450&t=" + System.currentTimeMillis()
        Connection.Response res = Jsoup.connect(url)
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                .timeout(10000).ignoreContentType(true)
                .execute();
        JSONObject object = JSON.parseObject(res.body());
        JSONArray array = object.getJSONArray("data");
        Set<String> urlSet = InitSet.initSet(filename);
        Set<String> newurl = new HashSet<>();
        for (Object jsonObject : array) {
            JSONObject object1 = (JSONObject) jsonObject;
            JSONObject question = object1.getJSONObject("question");
            if (question != null && !urlSet.contains("https://www.wukong.com/question/"+question.getString("qid"))) {
                JSONObject user_data = question.getJSONObject("user");
                JSONObject content_data = question.getJSONObject("content");
                User user = new User();
                if (user_data != null) {
                    user.setUsername(user_data.getString("uname"));
                    user.setPwd("123");
                    String filepath = Imagedownload.fastdfsdownload(user_data.getString("avatar_url"));
                    if (filepath == null){
//                        filepath = "http://192.168.230.133/group1/M00/00/5C/wKjmhVt_QsaAB1BCAAAvWPyiDo4712_big.jpg";
                        filepath = "http://120.79.237.11/group1/M00/00/00/rBJmnFuPRWmAOyCvAAAvWPyiDo4982_big.jpg";
                    }
                    user.setPicpath(filepath);
                    userService.addUser(user);
                }
                Article article = new Article();
                article.setUserid(user.getId());
                article.setTitle(question.getString("title"));
                article.setContent(content_data.getString("text"));
                JSONArray article_img = content_data.getJSONArray("thumb_image_list");
                if (article_img.size() != 0) {
                    String filepath = Imagedownload.fastdfsdownload(((JSONObject) article_img.get(0)).getString("url"));
                    article.setPicpath(filepath);
                }
                JSONArray tags = question.getJSONArray("concern_tags");
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0;i < tags.size();i++){
                    JSONObject tag = tags.getJSONObject(i);
                    stringBuilder.append(tag.getString("name")).append(",");
                }
                if (stringBuilder.length() != 0){
                    article.setTags(stringBuilder.substring(0,stringBuilder.lastIndexOf(",")));
                }

                Articlecategory articlecategory = new Articlecategory();
                articlecategory.setCategory(category);

                articleService.addArticle(article,articlecategory);
                solrAdd.solradd(article);
                urlSet.add("https://www.wukong.com/question/" + question.getString("qid"));
                newurl.add("https://www.wukong.com/question/" + question.getString("qid"));
                fileWriter.append("https://www.wukong.com/question/" + question.getString("qid") + "\n");
                fileWriter.flush();
            }
        }
//        sqlSession.commit();
        return newurl;
    }

}
