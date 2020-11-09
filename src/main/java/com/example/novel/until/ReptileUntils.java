package com.example.novel.until;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/10/2
 * Description: com.example.novel.until
 * version: 1.0
 */

import com.example.novel.bean.ChapterBean;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName 爬虫
 * @Description TODO
 * @Author lenovo
 * @Date 2020/10/2 14:45
 * @Version 1.0
 **/
public class ReptileUntils {

  public ChapterBean parseBidding() throws IOException {
    //斗破苍穹第一章
    String url = "https://read.qidian.com/chapter/2R9G_ziBVg41/eSlFKP1Chzg1.html";
    //获取该url，如果在30秒过后没有获取到，就放弃
    //解析网页，（jsoup返回的Document就是；浏览器Document对象
    Document document = null;

    document = Jsoup.parse(new URL(url), 30000);
    //所有在js中可以使用的都可以用，获取div名称类型为class名称为read-content j_readContent里面包含的数据
    Elements elements = document.getElementsByClass("read-content j_readContent");
    //将获取的数据直接初始化为字符串类型
    String message = elements.toString();
    //打印出来
    System.out.println(message);

    ChapterBean chapterBean = new ChapterBean();

    chapterBean.setC_content(message);

    return chapterBean;
  }

}
