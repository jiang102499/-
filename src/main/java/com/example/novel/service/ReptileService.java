package com.example.novel.service;

import com.example.novel.bean.ChapterBean;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName ReptileService
 * @Description TODO
 * @Author ht
 * @Date 2020/8/26 10:03
 * @Version 1.0
 **/
public interface ReptileService {

  /**
   * 爬取数据
   *
   * @param
   * @return
   * @throws IOException
   */
  public ChapterBean parseBidding() throws IOException;
}
