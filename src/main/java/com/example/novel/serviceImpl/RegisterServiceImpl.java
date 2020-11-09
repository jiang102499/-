package com.example.novel.serviceImpl;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/15
 * Description: com.example.novel.serviceImpl
 * version: 1.0
 */

import com.example.novel.bean.UserBean;
import com.example.novel.mapper.RegisterMapper;
import com.example.novel.service.RegisterService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName RegisterServiceImpl
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/15 19:13
 * @Version 1.0
 **/
@Service
public class RegisterServiceImpl implements RegisterService {

  @Autowired
  RegisterMapper mapper;

  /**
   * 注册
   *
   * @param userBean
   * @return
   */
  @Override
  public int register(UserBean userBean) {
    return mapper.register(userBean);
  }

  @Override
  public int selectAlready(String name) {
    return mapper.selectAlready(name);
  }
}
