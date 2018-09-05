package com.neusoft;

import com.neusoft.thread.SearchThread;
import com.neusoft.util.SolrAdd;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args ) throws IOException, InterruptedException {
//        new Thread(new SearchThread("热门","d:/SeachWukongNetSet/Hot.txt","热门","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6300775428692904450&t=1534230489373")).start();
//        new Thread(new SearchThread("社会","d:/SeachWukongNetSet/Society.txt","社会","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497899397089794&t=1534230512790")).start();
//        new Thread(new SearchThread("娱乐","d:/SeachWukongNetSet/Society.txt","娱乐","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497896830175745&t=1534231293202")).start();
//        new Thread(new SearchThread("体育","d:/SeachWukongNetSet/Sport.txt","体育","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497726554016258&t=1534231605101")).start();
//        new Thread(new SearchThread("汽车","d:/SeachWukongNetSet/Car.txt","汽车","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497898671475202&t=1534231638780")).start();
//        new Thread(new SearchThread("财经","d:/SeachWukongNetSet/Economics.txt","财经","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497900357585410&t=1534231658054")).start();
//        new Thread(new SearchThread("科技","d:/SeachWukongNetSet/science.txt","科技","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497899594222081&t=1534231697993")).start();
//        new Thread(new SearchThread("育儿","d:/SeachWukongNetSet/Childcare.txt","育儿","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497900164647426&t=1534231779351")).start();
//        new Thread(new SearchThread("历史","d:/SeachWukongNetSet/History.txt","历史","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497901590710786&t=1534231817982")).start();
//        new Thread(new SearchThread("美食与烹饪","d:/SeachWukongNetSet/cooking.txt","美食与烹饪","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497899774577154&t=1534231869514")).start();
//        new Thread(new SearchThread("数码","d:/SeachWukongNetSet/Digital.txt","数码","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497897518041601&t=1534231954880")).start();
//        new Thread(new SearchThread("时尚","d:/SeachWukongNetSet/fashion.txt","时尚","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497898084272641&t=1534232004785")).start();
//        new Thread(new SearchThread("宠物","d:/SeachWukongNetSet/Pet.txt","宠物","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215847700051528193&t=1534232046302")).start();
        new Thread(new SearchThread("热门","/opt/SeachWukongNetSet/Hot.txt","热门","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6300775428692904450&t=1534230489373")).start();
        new Thread(new SearchThread("社会","/opt/SeachWukongNetSet/Society.txt","社会","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497899397089794&t=1534230512790")).start();
        new Thread(new SearchThread("娱乐","/opt/SeachWukongNetSet/Society.txt","娱乐","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497896830175745&t=1534231293202")).start();
        new Thread(new SearchThread("体育","/opt/SeachWukongNetSet/Sport.txt","体育","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497726554016258&t=1534231605101")).start();
        new Thread(new SearchThread("汽车","/opt/SeachWukongNetSet/Car.txt","汽车","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497898671475202&t=1534231638780")).start();
        new Thread(new SearchThread("财经","/opt/SeachWukongNetSet/Economics.txt","财经","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497900357585410&t=1534231658054")).start();
        new Thread(new SearchThread("科技","/opt/SeachWukongNetSet/science.txt","科技","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497899594222081&t=1534231697993")).start();
        new Thread(new SearchThread("育儿","/opt/SeachWukongNetSet/Childcare.txt","育儿","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497900164647426&t=1534231779351")).start();
        new Thread(new SearchThread("历史","/opt/SeachWukongNetSet/History.txt","历史","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497901590710786&t=1534231817982")).start();
        new Thread(new SearchThread("美食与烹饪","/opt/SeachWukongNetSet/cooking.txt","美食与烹饪","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497899774577154&t=1534231869514")).start();
        new Thread(new SearchThread("数码","/opt/SeachWukongNetSet/Digital.txt","数码","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497897518041601&t=1534231954880")).start();
        new Thread(new SearchThread("时尚","/opt/SeachWukongNetSet/fashion.txt","时尚","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215497898084272641&t=1534232004785")).start();
        new Thread(new SearchThread("宠物","/opt/SeachWukongNetSet/Pet.txt","宠物","https://www.wukong.com/wenda/web/nativefeed/brow/?concern_id=6215847700051528193&t=1534232046302")).start();
        SolrAdd solrAdd = new SolrAdd();
        while(true){
            Thread.sleep(10000);
            solrAdd.commit();
            System.out.println("solr提交");
        }
    }

}
