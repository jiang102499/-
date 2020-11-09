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
 * @ClassName 小说表
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/21 11:53
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NovelBean {

  //小说id
  private int n_id;
  //小说名称
  private String n_name;
  //类别id
  private CategoryBean categoryBean;
  //作者id
  private WriterBean writerBean;
  //标签
  private String lable;
  //简介
  private String synopsis;
  //评分
  private Float score;
  //小说状态（1：连载中，0：已完结）
  private int state;
  //小说封面
  private String n_img;

}
