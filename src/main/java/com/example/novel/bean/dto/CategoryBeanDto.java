package com.example.novel.bean.dto;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/17
 * Description: com.example.novel.bean
 * version: 1.0
 */

import com.example.novel.bean.NovelBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
public class CategoryBeanDto {
  //类别id
  private int cg_id;
  //类别名称
  private String cg_name;
  //小说对象
  private List<NovelBean> novelBean;
}
