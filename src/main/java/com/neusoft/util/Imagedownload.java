package com.neusoft.util;

import com.sun.deploy.net.DownloadException;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Imagedownload {

    private static FastDFS fastDFS = new FastDFS();

    public static void download(String filePath, String imgUrl) {
        // 若指定文件夹没有，则先创建
        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 截取图片文件名
        String fileName = imgUrl.substring(imgUrl.lastIndexOf('/') + 1);

        try {
            // 文件名里面可能有中文或者空格，所以这里要进行处理。但空格又会被URLEncoder转义为加号
            String urlTail = URLEncoder.encode(fileName, "UTF-8");
            // 因此要将加号转化为UTF-8格式的%20
            imgUrl = imgUrl.substring(0, imgUrl.lastIndexOf('/') + 1) + urlTail.replaceAll("\\+", "\\%20");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 写出的路径
        File file = new File(filePath + File.separator + fileName + ".jpg");

        try {
            // 获取图片URL
            URL url = new URL(imgUrl);
            // 获得连接
            URLConnection connection = url.openConnection();
            // 设置10秒的相应时间
            connection.setConnectTimeout(10 * 1000);
            // 获得输入流
            InputStream in = connection.getInputStream();
            // 获得输出流
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
            // 构建缓冲区
            byte[] buf = new byte[1024];
            int size;
            // 写入到文件
            while (-1 != (size = in.read(buf))) {
                out.write(buf, 0, size);
            }
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getImgName(String imgUrl) {
        return imgUrl.substring(imgUrl.lastIndexOf('/') + 1, imgUrl.length()) + ".jpg";
    }

    public static String fastdfsdownload(String imgUrl) {
        String filepath = "";
        File file = null;
        try {
            // 获取图片URL
            URL url = new URL(imgUrl);
            // 获得连接
            URLConnection connection = url.openConnection();
            // 设置10秒的相应时间
            connection.setConnectTimeout(10 * 1000);

            //模拟浏览器访问，防止网站屏蔽
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.19 Safari/537.36");

            InputStream is = connection.getInputStream();
            if (is == null || is.available() <= 0) {
                return null;
            }
            //得到临时文件
            file = getTemplateFile(is);
            // 获得输出流
            filepath = fastDFS.upload(file);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filepath;
    }

    public static File getTemplateFile(InputStream inputStream) {
        File file = null;
        try {
            file = File.createTempFile("temp_image", null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputStreamToFile(inputStream, file);
        if (file.exists() && file.length() <= 0) {
            return null;
        }
        return file;
    }

    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            try {
                int bytesRead = 0;
                byte[] buffer = new byte[8192];
                while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
                os.flush();
            } finally {
                if (os != null) {
                    os.close();
                }
                if (ins != null) {
                    ins.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
