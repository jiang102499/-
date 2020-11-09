package com.example.novel.serviceImpl;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/27
 * Description: com.example.novel.serviceImpl
 * version: 1.0
 */

import com.example.novel.bean.CategoryBean;
import com.example.novel.bean.dto.CategoryBeanDto;
import com.example.novel.bean.NovelBean;
import com.example.novel.mapper.CateGoryMapper;
import com.example.novel.service.CateGoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CateGoryServiceImpl
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/27 11:17
 * @Version 1.0
 **/
@Service
public class CateGoryServiceImpl implements CateGoryService {

  @Autowired
  CateGoryMapper mapper;

  @Override
  public List<CategoryBeanDto> selectCategory() {
    return mapper.selectCategory();
  }

  @Override
  public List<CategoryBean> selectCategoryById(int cg_id) {
    return mapper.selectCategoryById(cg_id);
  }


  @Override
  public int insertCategory(CategoryBean categoryBean) {
    return mapper.insertCategory(categoryBean);
  }

  @Override
  public CategoryBean selectupdate(int cg_id) {
    return mapper.selectupdate(cg_id);
  }

  @Override
  public int updateCategory(CategoryBean categoryBean) {
    return mapper.updateCategory(categoryBean);
  }

  @Override
  public int deleteCategory(int cg_id) {
    return mapper.deleteCategory(cg_id);
  }

  @Override
  public List<NovelBean> selectEnd() {
    return mapper.selectEnd();
  }

  @Override
  public List<NovelBean> selectUnEnd() {
    return mapper.selectUnEnd();
  }

  @Override
  public List<NovelBean> Ranking() {
    return mapper.Ranking();
  }

}
