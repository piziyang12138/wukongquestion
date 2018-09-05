package com.neusoft.util;

import com.neusoft.Service.ArticleService;
import com.neusoft.Service.CommentInfoService;
import com.neusoft.Service.UserService;
import com.neusoft.bean.Article;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SolrAdd {
//    SolrServer solrServer = new HttpSolrServer("http://192.168.230.130:8080/solr/collection1");
    SolrServer solrServer = new HttpSolrServer("http://120.79.237.11:8080/solr/collection1");
    @Test
    public void solradd() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ArticleService articleService = new ArticleService();

        List<Article> articles = articleService.queryAllArticle();
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
//        SolrServer solrServer = new HttpSolrServer("http://192.168.230.130:8080/solr/collection1");
        SolrServer solrServer = new HttpSolrServer("http://120.79.237.11:8080/solr/collection1");


        for (Article article : articles) {

            UUID uuid = UUID.randomUUID();
            SolrInputDocument solrDocument = new SolrInputDocument();
            solrDocument.addField("id", uuid.toString());
            solrDocument.addField("article_title", article.getTitle());
            solrDocument.addField("article_content", article.getContent() == null ? "" : article.getContent());
            solrDocument.addField("article_aid", article.getAid());
            solrDocument.addField("article_userid", article.getUserid());
            solrDocument.addField("article_createtime", article.getCreatetime());
            solrDocument.addField("article_tags", article.getTags() == null ? "" : article.getTags());
            solrDocument.addField("article_picpath", article.getPicpath() == null ? "" : article.getPicpath());
            try {
                solrServer.add(solrDocument);
            } catch (SolrServerException | IOException e) {
                e.printStackTrace();
            }

        }
        try {
            solrServer.commit();
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSimpleQuery() throws IOException, SolrServerException {
//        SolrServer solrServer = new HttpSolrServer("http://192.168.230.130:8080/solr/collection1");
        SolrServer solrServer = new HttpSolrServer("http://120.79.237.11:8080/solr/collection1");

        SolrQuery solrQuery = new SolrQuery();
        solrQuery.set("q", "1231");
        solrQuery.set("df", "item_keywords");//df=>default field


        //开启高亮显示
        QueryResponse queryResponse = solrServer.query(solrQuery);
        SolrDocumentList solrDocumentList = queryResponse.getResults();

        for (SolrDocument solrDocument : solrDocumentList) {
            Date timestamp = (Date) solrDocument.get("article_createtime");
            DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            if (timestamp != null) {
                System.out.println(dateFormat.format(timestamp));
                System.out.println();
            }
        }
    }

    public void solradd(Article article) {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ArticleService articleService = new ArticleService();

        List<Article> articles = articleService.queryAllArticle();
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

        UUID uuid = UUID.randomUUID();
        SolrInputDocument solrDocument = new SolrInputDocument();
        solrDocument.addField("id", uuid.toString());
        solrDocument.addField("article_title", article.getTitle());
        solrDocument.addField("article_content", article.getContent() == null ? "" : article.getContent());
        solrDocument.addField("article_aid", article.getAid());
        solrDocument.addField("article_userid", article.getUserid());
        solrDocument.addField("article_createtime", article.getCreatetime());
        solrDocument.addField("article_tags", article.getTags() == null ? "" : article.getTags());
        solrDocument.addField("article_picpath", article.getPicpath() == null ? "" : article.getPicpath());
        try {
            solrServer.add(solrDocument);
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }
    }

    public void commit(){
        try {
            solrServer.commit();
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }
    }
}
