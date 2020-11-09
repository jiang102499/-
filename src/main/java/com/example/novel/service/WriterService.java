package com.example.novel.service;

import com.example.novel.bean.NovelBean;
import com.example.novel.bean.WriterBean;

import java.util.List;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/30
 * Description: com.example.novel.service
 * version: 1.0
 */
public interface WriterService {

  /**
   * 签约作者
   *
   * @param writerBean
   * @return
   */
  public int signupWriter(WriterBean writerBean);

  /**
   * 根据id查询作者信息，为修改做准备
   *
   * @param w_id
   * @return
   */
  public WriterBean selectWriter(int w_id);

  /**
   * 修改作者
   *
   * @param writerBean
   * @return
   */
  public int updateWriter(WriterBean writerBean);

  /**
   * 删除
   *
   * @param w_id
   * @return
   */
  public int deleteWriter(int w_id);

}
