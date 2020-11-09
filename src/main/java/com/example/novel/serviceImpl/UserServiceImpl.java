package com.example.novel.serviceImpl;

import com.example.novel.bean.UserBean;
import com.example.novel.mapper.UserMapper;
import com.example.novel.service.UserService;
import com.example.novel.until.RedisUntils;
import jdk.nashorn.internal.parser.Token;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/11 9:13
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserMapper mapper;

  @Autowired
  RedisUntils redisUntils;

  @Override
  public UserBean loginUser(UserBean userBean) {
    UserBean user = mapper.loginUser(userBean);
//    redisUntils.set("user_"+user.getId(), user,3);
//    System.out.println(redisUntils.get("user_" + user.getId()));
    return user;
  }

  @Override
  public int update(UserBean userBean) {
    int update = mapper.update(userBean);
//    if (update!=0){
//      String key ="user_"+userBean.getId();
//      boolean haskey=redisUntils.hasKey(key); //判断redis缓存存不存在
//      if (haskey){
//      redisUntils.del(key);
//      System.out.println("删除redis缓存======>"+key);
//    }
//      //查询该用户最新的消息
//      UserBean usernew = mapper.selectUser(userBean.getId());
//      if (usernew!=null){
//        //将用户最新的消息放入redis中
//        redisUntils.set(key, usernew, 3);
//        System.out.println("放入的新的redis缓存========》"+ redisUntils.get(key));
//      }


    //}


    return update;
  }

  @Override
  public UserBean selectUser(int id) {
    String key = "user_" + id;
    boolean iskey = redisUntils.hasKey(key);
//    if (!iskey){
    UserBean user = mapper.selectUser(id);
    System.out.println("查询数据库获得数据：" + user);
    System.out.println("------------------------------------");
    //写入缓存
    redisUntils.set(key, user);
    return user;
//    }else {
//      UserBean user = (UserBean) redisUntils.get(key);
//      System.out.println("从缓存中获得数据："+user);
//      System.out.println("------------------------------------");
//      return user;
//    }
  }
}
