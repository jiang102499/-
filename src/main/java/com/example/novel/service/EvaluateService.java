package com.example.novel.service;

import com.example.novel.bean.EvaluateBean;

import java.util.List;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/10/6
 * Description: com.example.novel.service
 * version: 1.0
 */
//评论
public interface EvaluateService {

  /**
   * 通过用户登录，根据jwt从而添加评论，添加评论
   *
   * @param evaluateBean
   * @return
   */
  public int insertEvaluate(EvaluateBean evaluateBean);


  /**
   * 删除评论
   *
   * @param e_id
   * @return
   */
  public int deleteEvaluate(int e_id);


  /**
   * 通过小说id 查询该小说的所有评论
   *
   * @param n_id
   * @return
   */
  public List<EvaluateBean> selectAllEvaluateNovelId(int n_id);
}
