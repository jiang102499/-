package com.example.novel.controller;

import com.example.novel.bean.ChapterBean;
import com.example.novel.serviceImpl.ReptileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName ReptileController
 * @Description TODO
 * @Author ht
 * @Date 2020/8/26 10:13
 * @Version 1.0
 **/
@RestController
public class ReptileController {

  @Autowired
  ReptileServiceImpl reptileImpl;


  /**
   * 爬取数据
   *
   * @return
   * @throws IOException
   */
  @RequestMapping("/reptile")
  public ChapterBean insert() throws IOException {
    ChapterBean chapterBean1 = reptileImpl.parseBidding();
    System.out.println(chapterBean1);
    return chapterBean1;
  }
}
