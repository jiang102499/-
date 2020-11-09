package com.example.novel.bean;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/17
 * Description: com.example.novel.bean
 * version: 1.0
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName 评价表
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/17 22:31
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluateBean {
  //评论id
  private int e_id;
  //评论内容
  private String e_content;
  //评论时间
  //  @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
  //  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date e_time;
  //用户id
  private int u_id;
  //小说id
  private int n_id;
}
