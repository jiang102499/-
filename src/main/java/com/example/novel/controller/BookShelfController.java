package com.example.novel.controller;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/23
 * Description: com.example.novel.controller
 * version: 1.0
 */

import com.example.novel.bean.BookShelfBean;
import com.example.novel.bean.CentreBookShelfBean;
import com.example.novel.bean.NovelUserCentreBean;
import com.example.novel.bean.ResultBean;
import com.example.novel.bean.dto.CentreBookShelfBeanDto;
import com.example.novel.service.BookShelfService;
import com.example.novel.until.RedisUntils;
import com.example.novel.until.ResultUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName BookShelfController
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/23 9:33
 * @Version 1.0
 **/
@RestController
public class BookShelfController {


  @Autowired
  BookShelfService shelfService;

  /**
   * 根据用户id查询是否拥有书架，没有的话就创建
   *
   * @param id
   * @return
   */
  @GetMapping("/whetherHaveBookShelf")
  public ResultBean whetherHaveBookShelf(int id) {
    BookShelfBean shelfBean = shelfService.selectHaveBookShelf(id);
    if (shelfBean != null) {
      return ResultUntil.result(ResultUntil.code200, " ", "该用户已经拥有书架");
    } else {
      int count = shelfService.creatBookShelf(id);
      return ResultUntil.result(ResultUntil.code200, count, "已经根据该用户id创建了该用户id书架");
    }
  }

  /**
   * 收藏小说id，根据jwt解析它的用户id，通过用户id查询它的书架id，将小说添加进入该书架
   *
   * @param centreBean
   * @param request
   * @return
   */
  @PostMapping("/collectNovel")
  public ResultBean collectNovel(CentreBookShelfBean centreBean, HttpServletRequest request) {
    int id = (int) request.getAttribute("userid");
    BookShelfBean shelfBean = shelfService.selectHaveBookShelf(id);
    centreBean.setB_id(shelfBean.getB_id());
    int count = shelfService.collectNovel(centreBean);
    return ResultUntil.result(ResultUntil.code200, count, "收藏成功");
  }

  /**
   * 根据书架id，查询该书架的收藏的所有小说
   *
   * @param centreBookShelfBeanDto
   * @param request
   * @return
   */
  @PostMapping("/selectCollectNovel")
  public ResultBean selectCollectNovel(CentreBookShelfBeanDto centreBookShelfBeanDto, HttpServletRequest request) {
    int id = (int) request.getAttribute("userid");
    BookShelfBean shelfBean = shelfService.selectHaveBookShelf(id);
    centreBookShelfBeanDto.setB_id(shelfBean.getB_id());
    List<CentreBookShelfBeanDto> dtoList = shelfService.selectCollectNovel(centreBookShelfBeanDto);
    return ResultUntil.result(ResultUntil.code200, dtoList, "查询成功");
  }

  /**
   * 删除收藏的小说
   *
   * @param centreBookShelfBean
   * @param request
   * @return
   */
  @PostMapping("/deleteCollectNovel")
  public ResultBean deleteCollectNovel(CentreBookShelfBean centreBookShelfBean, HttpServletRequest request) {
    int id = (int) request.getAttribute("userid");
    BookShelfBean shelfBean = shelfService.selectHaveBookShelf(id);
    centreBookShelfBean.setB_id(shelfBean.getB_id());
    int count = shelfService.deleteCollectNovel(centreBookShelfBean);
    return ResultUntil.result(ResultUntil.code200, count, "删除成功");
  }

  /**
   * 查询该用户的阅读历史，通过jwt获取用户id
   *
   * @param request
   * @return
   */
  @GetMapping("/readHistory")
  public ResultBean readHistory(HttpServletRequest request) {
    int u_id = (int) request.getAttribute("userid");
    List<NovelUserCentreBean> novelHistory = shelfService.readHistory(u_id);
    return ResultUntil.result(ResultUntil.code200, novelHistory, "该用户阅读历史记录显示成功");
  }
}
