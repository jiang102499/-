package com.example.novel.bean;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/25
 * Description: com.example.novel.bean
 * version: 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName NovelUserCentre
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/25 9:28
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NovelUserCentreBean {

  //中间表id
  private int nu_id;
  //用户
  private UserBean userBean;
  //小说
  private NovelBean novelBean;
  //该用户最近一次阅读该小说的时间
  private Date read_time;
}
