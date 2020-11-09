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
 * @ClassName 章节表
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/17 22:30
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterBean {
  //章节id
  private int c_id;
  //
  private int cn_id;
  //章节名称
  private String c_name;
  //章节内容
  private String c_content;
  //小说id
  private int n_id;
}
