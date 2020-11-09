package com.example.novel.bean;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/10/9
 * Description: com.example.novel.bean
 * version: 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ResultBean2
 * @Description TODO
 * @Author lenovo
 * @Date 2020/10/9 9:36
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean2 {
  //状态（正确200 服务器错误50x 客户端错误40x）
  private int code;
  //数据
  private Object data;

  private Object data2;
  //提示
  private String msg;


  public ResultBean2(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}
