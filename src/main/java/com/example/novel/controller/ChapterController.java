package com.example.novel.controller;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/10/5
 * Description: com.example.novel.controller
 * version: 1.0
 */

import com.example.novel.bean.ChapterBean;
import com.example.novel.bean.ResultBean;
import com.example.novel.service.ChapterService;
import com.example.novel.until.DocUntils;
import com.example.novel.until.ResultUntil;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName ChapterController
 * @Description TODO
 * @Author lenovo
 * @Date 2020/10/5 15:36
 * @Version 1.0
 **/
@RestController
public class ChapterController {

  @Autowired
  ChapterService service;

  /**
   * 增加章节
   *
   * @param chapterBean
   * @param file
   * @param request
   * @return
   */
  @PostMapping("/insertChapter")
  public ResultBean insertChapter(ChapterBean chapterBean, MultipartFile file, HttpServletRequest request) {
    try {
      String fileName = file.getOriginalFilename();//获取文件名
      String suffix = fileName.substring(fileName.lastIndexOf("."));//获取文件后缀名
      if (fileName.endsWith(".docx")) {
        XWPFDocument xwp = new XWPFDocument(file.getInputStream());//获取该文件的文件流，传入给XWPDocument
        System.out.println(file);
        XWPFWordExtractor extractor = new XWPFWordExtractor(xwp);//读取docx文档的内容时，我们只能获取到其文本，而不能获取到其文本对应的属性值
        String doc1 = extractor.getText();//将文本内容变成text
        System.out.println(doc1);
        if (!StringUtils.hasText(doc1)) {
          return ResultUntil.result(ResultUntil.code500, "", "提取文件内容不成功");
        }
        return ResultUntil.result(ResultUntil.code200, doc1, "提取文件内容成功");
      } else {
        System.out.println("文件格式不正确");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ResultUntil.result(ResultUntil.code500, "", "操作有误");
  }


  /**
   * 根据小说的id查询该小说的所有目录，内容
   *
   * @param n_id
   * @return
   */
  @PostMapping("/selectAllChapterNovelId")
  public ResultBean selectAllChapterNovelId(int n_id) {
    List<ChapterBean> beanList = service.selectAllChapterNovelId(n_id);
    if (beanList != null) {
      return ResultUntil.result(ResultUntil.code200, beanList, "章节内容显示成功");
    } else {
      return ResultUntil.result(ResultUntil.code500, " ", "章节内容显示失败");
    }
  }


  /**
   * 根据小说的id查询该小说的所有目录，内容
   *
   * @param n_id
   * @return
   */
  @PostMapping("/selectChapterNovelId")
  public ResultBean selectChapterNovelId(int n_id, int cn_id) {
    ChapterBean bean = service.selectChapterNovelId(n_id, cn_id);
    if (bean != null) {
      return ResultUntil.result(ResultUntil.code200, bean, "章节内容显示成功");
    } else {
      return ResultUntil.result(ResultUntil.code500, " ", "章节内容显示失败");
    }
  }


  @PostMapping("/selectCountChapterNovel")
  public ResultBean selectCountChapterNovel(int n_id) {
    int count = service.selectCountChapterNovel(n_id);
    if (count > 0) {
      return ResultUntil.result(ResultUntil.code200, count, "小说章节显示成功");
    } else {
      return ResultUntil.result(ResultUntil.code500, "", "小说章节显示失败");
    }

  }
}
