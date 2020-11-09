package com.example.novel.bean;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/17
 * Description: com.example.novel.bean
 * version: 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName 我的书架
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/17 22:26
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookShelfBean {
  //书架id
  private int b_id;
  //用户id
  private int u_id;
}
