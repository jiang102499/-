package com.example.novel.until;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/10/2
 * Description: com.example.novel.until
 * version: 1.0
 */

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.xmlbeans.XmlException;
import org.springframework.util.StringUtils;

import java.io.*;

/**
 * @ClassName DocUntils
 * @Description TODO
 * @Author lenovo
 * @Date 2020/10/2 15:30
 * @Version 1.0
 **/

public class DocUntils {

  /**
   * 读取word文件内容
   *
   * @param
   * @return 返回文件内容
   */
  public static String readWord(String path) {
    String buffer = "";
    try {
      if (path.endsWith(".doc")) {
        //对InputStream 进行读操作，我们输入的path地址
        InputStream is = new FileInputStream(new File(path));
        //将word解析
        WordExtractor ex = new WordExtractor(is);
        //通过getText()方式显示
        buffer = ex.getText();
        //关闭
        ex.close();
      } else if (path.endsWith(".docx")) {
        OPCPackage opcPackage = POIXMLDocument.openPackage(path);
        POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
        buffer = extractor.getText();
        extractor.close();
      } else {
        System.out.println("此文档不是word文档");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return buffer;
  }


  public static void main(String[] args) throws IOException, OpenXML4JException, XmlException {
    DocUntils tp = new DocUntils();
    String content = tp.readWord("C:\\Users\\lenovo\\Desktop\\index.docx");
    if (!StringUtils.hasText(content)) {
      System.out.println("文档为空");
    }
    System.out.println("content====" + content);

  }
}

