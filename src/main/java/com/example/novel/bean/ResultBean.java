package com.example.novel.bean;

import com.example.novel.until.ResultUntil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName ResultBean 返回数据类
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/11 11:31
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean implements Serializable {
  //状态（正确200 服务器错误50x 客户端错误40x）
  private int code;
  //数据
  private Object data;
  //提示
  private String msg;

  public ResultBean(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }


}
