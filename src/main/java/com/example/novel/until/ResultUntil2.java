package com.example.novel.until;

import com.example.novel.bean.ResultBean;
import com.example.novel.bean.ResultBean2;

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
public class ResultUntil2 {
  public static final int code200 = 200;

  public static final int code401 = 401;

  public static final int code500 = 500;

  public static ResultBean2 result(int code, Object data, Object data2, String msg) {
    return new ResultBean2(code, data, data2, msg);
  }
}
