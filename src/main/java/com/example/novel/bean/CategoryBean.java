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
 * @ClassName 类别表
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/17 22:28
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryBean {
  //类别id
  private int cg_id;
  //类别名称
  private String cg_name;
}
