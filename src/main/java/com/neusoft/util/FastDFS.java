package com.neusoft.util;

import com.neusoft.fastdfsTemlate.FastDFSTemplate;
import com.neusoft.fastdfsTemlate.FastDfsInfo;
import com.neusoft.fastdfsTemlate.exception.FastDFSException;
import org.csource.common.NameValuePair;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FastDFS {
    private BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:spring-fastdfs.xml");
    private FastDFSTemplate dfsTemplate = (FastDFSTemplate) beanFactory.getBean("fastDFSTemplate");

    public String upload(File tempFile) {
        InputStream is = null;
        try {
            is = new FileInputStream(tempFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] bytes = null;
        try {
            bytes = new byte[is.available()];
            int length = is.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String filePath = "";
//        try {
//            int length = fileReader.read(bytes);
//            String ext = "jpg";
//            FastDFSFile file = new FastDFSFile(bytes,ext);
//            NameValuePair[] meta_list = new NameValuePair[4];
//            meta_list[0] = new NameValuePair("fileName", filename);
//            meta_list[1] = new NameValuePair("fileLength", String.valueOf(length));
//            meta_list[2] = new NameValuePair("fileExt", ext);
//            meta_list[3] = new NameValuePair("fileAuthor", "YuanYang");
//            filePath = FileManager.upload(file,meta_list);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Map<String, String> map = new HashMap<>();
        FastDfsInfo rv = null;
        try {
            rv = dfsTemplate.upload(bytes, "jpg", map);
        } catch (FastDFSException e) {
            e.printStackTrace();
        }finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (tempFile != null) {
                tempFile.delete();
            }
        }
        assert rv != null;
        return rv.getFileAbsolutePath();
    }
}
