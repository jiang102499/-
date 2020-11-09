package com.example.novel.bean.dto;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/23
 * Description: com.example.novel.bean
 * version: 1.0
 */

import com.example.novel.bean.NovelBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
public class CentreBookShelfBeanDto {
  //中间表id
  private int cen_id;
  //书架id
  private int b_id;
  //小说id
  private List<NovelBean> novelBean;
}
