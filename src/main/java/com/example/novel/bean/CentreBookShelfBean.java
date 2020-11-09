package com.example.novel.bean;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/23
 * Description: com.example.novel.bean
 * version: 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName 中间表
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/23 9:47
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CentreBookShelfBean {
  //中间表id
  private int cen_id;
  //书架id
  private int b_id;
  //小说id
  private int n_id;
}
