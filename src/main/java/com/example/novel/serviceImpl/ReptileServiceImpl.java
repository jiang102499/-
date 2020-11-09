package com.example.novel.serviceImpl;

import com.example.novel.bean.ChapterBean;
import com.example.novel.mapper.ReptileMapper;
import com.example.novel.service.ReptileService;
import com.example.novel.until.ReptileUntils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName ReptileServiceImpl
 * @Description TODO
 * @Author ht
 * @Date 2020/8/26 10:29
 * @Version 1.0
 **/
@Service
public class ReptileServiceImpl implements ReptileService {
  @Autowired
  ReptileMapper mapper;

  //解析 斗破第一章
  @Override
  public ChapterBean parseBidding() throws IOException {
    ChapterBean chapterBean = new ReptileUntils().parseBidding();
    int count = mapper.parseBidding(chapterBean);
    return chapterBean;
  }
}
