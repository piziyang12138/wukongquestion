package com.neusoft.util;

import com.neusoft.Service.ArticleService;
import com.neusoft.Service.CommentInfoService;
import com.neusoft.Service.UserService;
import com.neusoft.bean.Article;
import com.neusoft.bean.Commentinfo;
import com.neusoft.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.Set;

public class GetCommentinfo {

    public void getCommentinfo(Set<String> urls) throws IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserService userService = new UserService();
        ArticleService articleService = new ArticleService();
        CommentInfoService commentInfoService = new CommentInfoService();

        for (String url : urls) {
            System.out.println(url);
            Document document = Jsoup.connect(url)
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36")
                    .get();
            Article article = articleService.queryArticleByTitle(document.selectFirst(".question-name").text());
            if (article != null) {
                Elements elements = document.select(".answer-item");
                for (Element element : elements) {
                    User user = new User();
                    Element img = element.selectFirst(".answer-user-avatar img");
                    Element uname = element.selectFirst(".answer-user-name");
                    Element richtext = element.selectFirst(".answer-text-full");
                    String user_filepath = Imagedownload.fastdfsdownload(img.attr("src"));
                    if (user_filepath == null){
//                        user_filepath = "http://192.168.230.133/group1/M00/00/5C/wKjmhVt_QsaAB1BCAAAvWPyiDo4712_big.jpg";
                        user_filepath = "http://120.79.237.11/group1/M00/00/00/rBJmnFuPRWmAOyCvAAAvWPyiDo4982_big.jpg";
                    }
                    user.setPicpath(user_filepath);
                    user.setUsername(uname.ownText());
                    user.setPwd("123");
                    userService.addUser(user);
                    Commentinfo commentinfo = new Commentinfo();
                    commentinfo.setUserid(user.getId());
                    commentinfo.setArticleid(article.getAid());
                    Document html = Jsoup.parse(richtext.toString());
                    Elements elements1 = html.select("img");
                    for (Element element1:elements1){
                        String img_filepath = Imagedownload.fastdfsdownload(element1.attr("src"));
                        element1.attr("src",img_filepath);
                    }
                    commentinfo.setChtml(html.body().child(0).html());
//                System.out.println(richtext.html().replace("http://p3.pstatp.com/large", "${pageContext.request.contextPath}/large")
//                        .replace("http://p1.pstatp.com/large","${pageContext.request.contextPath}/large")
//                        .replace("http://p9.pstatp.com/large","${pageContext.request.contextPath}/large")
//                        .replace("http://p99.pstatp.com/large","${pageContext.request.contextPath}/large"));
//                    for (Element content_img : content_imgs) {
//                        Imagedownload.download("C:\\Users\\ttc\\IdeaProjects\\wukongwenda\\src\\main\\webapp/upload", content_img.attr("src"));
//                    }
                    commentInfoService.addComment(commentinfo);
                }
            }
        }
        sqlSession.commit();
        System.out.println("提交完成");
        sqlSession.close();
    }
}
