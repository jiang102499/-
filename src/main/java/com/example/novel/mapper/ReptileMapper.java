package com.example.novel.mapper;

import com.example.novel.bean.ChapterBean;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName ReptileMapper
 * @Description TODO
 * @Author ht
 * @Date 2020/8/26 10:06
 * @Version 1.0
 **/
@Mapper
@Repository
public interface ReptileMapper {

  /**
   * 爬取数据
   *
   * @param chapterBean
   * @return
   * @throws IOException
   */
  public int parseBidding(ChapterBean chapterBean) throws IOException;
}
