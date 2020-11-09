package com.example.novel.service;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/15
 * Description: com.example.novel.service
 * version: 1.0
 */

import com.example.novel.bean.UserBean;

/**
 * @ClassName RegisterService
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/15 19:13
 * @Version 1.0
 **/
public interface RegisterService {

  //注册
  public int register(UserBean userBean);

  //查看是否注册过
  int selectAlready(String name);
}
