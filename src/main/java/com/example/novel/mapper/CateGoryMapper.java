package com.example.novel.mapper;

import com.example.novel.bean.CategoryBean;
import com.example.novel.bean.NovelBean;
import com.example.novel.bean.dto.CategoryBeanDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/27
 * Description: com.example.novel.mapper
 * version: 1.0
 */
@Mapper
@Repository
public interface CateGoryMapper {

  //查询根据类别查询属于该类别的所有小说
  public List<CategoryBeanDto> selectCategory();

  /**
   * 查询根据类别id查询属于该类别的所有小说
   *
   * @param
   * @return
   */
  public List<CategoryBean> selectCategoryById(int cg_id);

  /**
   * 增加分类类别
   *
   * @param categoryBean
   * @return
   */
  public int insertCategory(CategoryBean categoryBean);

  /**
   * 通过cg_id查询该信息的属性
   *
   * @param cg_id
   * @return
   */
  public CategoryBean selectupdate(int cg_id);

  /**
   * 修改分类类别
   *
   * @param categoryBean
   * @return
   */
  public int updateCategory(CategoryBean categoryBean);

  /**
   * 删除分类类别
   *
   * @param cg_id
   * @return
   */
  public int deleteCategory(int cg_id);

  /**
   * 查询完结的小说
   *
   * @return
   */
  public List<NovelBean> selectEnd();

  /**
   * 查询未完结的小说
   *
   * @return
   */
  public List<NovelBean> selectUnEnd();

  /**
   * 排行
   *
   * @return
   */
  public List<NovelBean> Ranking();

}
