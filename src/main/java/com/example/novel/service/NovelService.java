package com.example.novel.service;

import com.example.novel.bean.NovelBean;
import com.example.novel.bean.dto.NovelBeanDto;

import java.util.List;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/10/4
 * Description: com.example.novel.service
 * version: 1.0
 */
public interface NovelService {

  /**
   * 查询所有的小说
   *
   * @return
   */
  public List<NovelBean> selectAllNovel();

  /**
   * 增加小说
   *
   * @param novelBeanDto
   * @return
   */
  public int insertNovel(NovelBeanDto novelBeanDto);

  /**
   * 通过小说id获取到该小说的所有信息
   *
   * @param n_id
   * @return
   */
  public NovelBean selectNovelId(int n_id);


  /**
   * 修改小说
   *
   * @param novelBeanDto
   * @return
   */
  public int updateNovel(NovelBeanDto novelBeanDto);

  /**
   * 通过小说id（n_id）,删除该小说
   *
   * @param n_id
   * @return
   */
  public int deleteNovel(int n_id);

  /**
   * 根据作者的id查询该作者的所有小说
   *
   * @param w_id
   * @return
   */
  public List<NovelBean> selectNovelWriterId(int w_id);
}
