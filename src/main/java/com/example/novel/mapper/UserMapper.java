package com.example.novel.mapper;

import com.example.novel.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/11 9:13
 * @Version 1.0
 **/
@Mapper
@Repository
public interface UserMapper {
  //登录
  public UserBean loginUser(UserBean userBean);

  //修改
  public int update(UserBean userBean);

  //根据id查询数据
  public UserBean selectUser(int id);
}
