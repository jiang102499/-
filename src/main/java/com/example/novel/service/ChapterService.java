package com.example.novel.service;

import com.example.novel.bean.ChapterBean;

import java.util.List;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/10/5
 * Description: com.example.novel.service
 * version: 1.0
 */
public interface ChapterService {

  /**
   * 增加章节
   *
   * @param chapterBean
   * @return
   */
  public int insertChapter(ChapterBean chapterBean);


  /**
   * 根据小说id查询该小说的目录章节，以及内容
   *
   * @param n_id
   * @return
   */
  public List<ChapterBean> selectAllChapterNovelId(int n_id);


  /**
   * 获取该小说的一个章节
   *
   * @param n_id
   * @param cn_id
   * @return
   */
  public ChapterBean selectChapterNovelId(int n_id, int cn_id);


  /**
   * 获取该小说的小说章节数
   *
   * @param n_id
   * @return
   */
  public int selectCountChapterNovel(int n_id);
}
