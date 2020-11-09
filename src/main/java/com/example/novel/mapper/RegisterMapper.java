package com.example.novel.mapper;

import com.example.novel.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/15
 * Description: com.example.novel.mapper
 * version: 1.0
 */
@Mapper
@Repository
public interface RegisterMapper {
  //注册
  public int register(UserBean userBean);

  //查看是否注册过
  int selectAlready(String name);
}
