package com.neusoft.thread;

import com.neusoft.util.GetCommentinfo;
import com.neusoft.util.GetwukongQuestion;

import java.io.IOException;
import java.util.Set;

public class SearchThread implements Runnable {
    private String name;
    private String filename;
    private String category;
    private String url;

    public SearchThread(String name, String filename, String category,String url) {
        this.name = name;
        this.filename = filename;
        this.category = category;
        this.url = url;
    }
    @Override
    public void run() {
        GetwukongQuestion getwukongQuestion = new GetwukongQuestion();
        GetCommentinfo commentinfo = new GetCommentinfo();
        while(true) {
            System.out.println("搜索"+name);
            Set<String> urls = null;
            try {
                urls = getwukongQuestion.getquestion(filename,category,url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("搜索"+name+"中的文章");
            try{
                commentinfo.getCommentinfo(urls);
            }catch (Exception e){
                System.out.println("报了个错");
                e.printStackTrace();
            }
            System.out.println(name + "分类爬完一次 休息2分钟");
            try {
                Thread.sleep(1000*60*2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
