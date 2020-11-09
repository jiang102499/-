package com.example.novel.until;

import com.example.novel.bean.ResultBean;

/**
 * @ClassName ResultUntil
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/11 11:48
 * @Version 1.0
 **/

/**
 * 返回数据封装类
 */
public class ResultUntil {
  public static final int code200 = 200;

  public static final int code401 = 401;

  public static final int code500 = 500;

  public static ResultBean result(int code, Object data, String msg) {
    return new ResultBean(code, data, msg);
  }
}
