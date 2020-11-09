package com.example.novel.mapper;

import com.example.novel.bean.WriterBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/30
 * Description: com.example.novel.mapper
 * version: 1.0
 */
@Mapper
@Repository
public interface WriterMapper {


  /**
   * 签约作者
   *
   * @param writerBean
   * @return
   */
  public int signupWriter(WriterBean writerBean);

  /**
   * 根据id查询作者信息，为修改做准备
   *
   * @param w_id
   * @return
   */
  public WriterBean selectWriter(int w_id);

  /**
   * 修改作者
   *
   * @param writerBean
   * @return
   */
  public int updateWriter(WriterBean writerBean);

  /**
   * 删除
   *
   * @param w_id
   * @return
   */
  public int deleteWriter(int w_id);
}
