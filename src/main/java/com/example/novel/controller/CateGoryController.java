package com.example.novel.controller;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/27
 * Description: com.example.novel.controller
 * version: 1.0
 */

import com.example.novel.bean.CategoryBean;
import com.example.novel.bean.NovelBean;
import com.example.novel.bean.ResultBean;
import com.example.novel.bean.dto.CategoryBeanDto;
import com.example.novel.service.CateGoryService;
import com.example.novel.until.ResultUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName 首页，分类
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/27 11:16
 * @Version 1.0
 **/
@RestController
public class CateGoryController {

  @Autowired
  CateGoryService cateGoryService;


  /**
   * 查询根据类别查询属于该类别的所有小说
   *
   * @param
   * @return
   */
  @GetMapping("/selectCategory")
  public ResultBean selectCategory() {
    List<CategoryBeanDto> novels = cateGoryService.selectCategory();
    if (novels != null) {
      return ResultUntil.result(ResultUntil.code200, novels, "查询成功");
    }
    {
      return ResultUntil.result(ResultUntil.code500, "", "查询失败");
    }
  }

  /**
   * 查询根据类别id 查询属于该类别的所有小说
   *
   * @param
   * @return
   */
  @PostMapping("/selectCategoryById")
  public ResultBean selectCategoryById(int cg_id) {
    List<CategoryBean> novels = cateGoryService.selectCategoryById(cg_id);
    if (novels != null) {
      return ResultUntil.result(ResultUntil.code200, novels, "查询成功");
    }
    {
      return ResultUntil.result(ResultUntil.code500, "", "查询失败");
    }
  }


  /**
   * 增加分类的类别
   *
   * @param categoryBean
   * @return
   */
  @PostMapping("/insertCategory")
  public ResultBean insertCategory(CategoryBean categoryBean) {
    int count = cateGoryService.insertCategory(categoryBean);
    if (count > 0) {
      return ResultUntil.result(ResultUntil.code200, count, "添加成功");
    } else {
      return ResultUntil.result(ResultUntil.code500, "", "添加失败");
    }
  }

  /**
   * 根据cg_id查询该信息的属性，再修改
   *
   * @param cg_id
   * @return
   */
  @GetMapping("/selectupdate")
  public ResultBean selectupdate(int cg_id) {
    CategoryBean selectupdate = cateGoryService.selectupdate(cg_id);
    return ResultUntil.result(ResultUntil.code200, selectupdate, "查询成功");
  }


  /**
   * 修改类别
   *
   * @param categoryBean
   * @return
   */
  @PostMapping("/updateCategory")
  public ResultBean updateCateGory(CategoryBean categoryBean) {
    int count = cateGoryService.updateCategory(categoryBean);
    if (count > 0) {
      return ResultUntil.result(ResultUntil.code200, count, "修改成功");
    } else {
      return ResultUntil.result(ResultUntil.code500, "", "修改失败");
    }
  }


  /**
   * 删除分类的类别
   *
   * @param cg_id
   * @return
   */
  @GetMapping("/deleteCategory")
  public ResultBean deleteCategory(int cg_id) {
    int count = cateGoryService.deleteCategory(cg_id);
    if (count > 0) {
      return ResultUntil.result(ResultUntil.code200, count, "删除成功");
    } else {
      return ResultUntil.result(ResultUntil.code500, "", "删除失败");
    }
  }


  /**
   * 查询状态为完结的所有小说
   *
   * @return
   */
  @GetMapping("/selectEnd")
  public ResultBean selectEnd() {
    List<NovelBean> novelBeans = cateGoryService.selectEnd();
    if (novelBeans != null) {
      return ResultUntil.result(ResultUntil.code200, novelBeans, "查询成功");
    }
    {
      return ResultUntil.result(ResultUntil.code500, "", "查询失败");
    }
  }

  /**
   * 查询状态为未完结的小说
   *
   * @return
   */
  @GetMapping("/selectUnEnd")
  public ResultBean selectUnEnd() {
    List<NovelBean> novelBeans = cateGoryService.selectUnEnd();
    if (novelBeans != null) {
      return ResultUntil.result(ResultUntil.code200, novelBeans, "查询成功");
    }
    {
      return ResultUntil.result(ResultUntil.code500, "", "查询失败");
    }
  }

  /**
   * 排行
   *
   * @return
   */
  @GetMapping("/ranking")
  public ResultBean Ranking() {
    List<NovelBean> novelBeans = cateGoryService.Ranking();
    if (novelBeans != null) {
      return ResultUntil.result(ResultUntil.code200, novelBeans, "查询成功");
    }
    {
      return ResultUntil.result(ResultUntil.code500, "", "查询失败");
    }
  }
}
