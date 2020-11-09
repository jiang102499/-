package com.example.novel.bean;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/21
 * Description: com.example.novel.bean
 * version: 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName 作者表
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/21 11:58
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WriterBean {

  //作者id
  private int w_id;
  //作者名称
  private String w_name;
  //作者电话
  private int w_phone;
  //签约时间
  private Date start_time;
  //到期时间
  private Date end_time;
}
