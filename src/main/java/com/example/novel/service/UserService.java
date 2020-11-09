package com.example.novel.service;

import com.example.novel.bean.UserBean;

public interface UserService {

  /**
   * 登录
   *
   * @param userBean
   * @return
   */
  public UserBean loginUser(UserBean userBean);

  /**
   * 修改
   *
   * @param userBean
   * @return
   */
  public int update(UserBean userBean);

  /**
   * 根据id查询数据
   *
   * @param id
   * @return
   */
  public UserBean selectUser(int id);
}
