package com.example.novel.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName UserBean
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/11 9:12
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBean implements Serializable {
  //用户id
  private int id;
  //头像
  private String img;
  //用户名
  private String name;
  //用户密码
  private String password;
  //性别
  private int sex;
  //余额
  private String balance;
  //权限
  private String limits;
}
