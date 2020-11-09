package com.example.novel.controller;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/10/6
 * Description: com.example.novel.controller
 * version: 1.0
 */

import com.example.novel.bean.EvaluateBean;
import com.example.novel.bean.ResultBean;
import com.example.novel.service.EvaluateService;
import com.example.novel.until.ResultUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @ClassName EvaluateController
 * @Description TODO
 * @Author lenovo
 * @Date 2020/10/6 17:31
 * @Version 1.0
 **/
@RestController
public class EvaluateController {
  @Autowired
  EvaluateService evaluateService;


  /**
   * 根据jwt可以知道是哪个用户增加的评论
   *
   * @param evaluateBean
   * @param request
   * @return
   */
  @PostMapping("/insertEvaluate")
  public ResultBean insertEvaluate(EvaluateBean evaluateBean, HttpServletRequest request) {
    int userId = (int) request.getAttribute("userid");
    evaluateBean.setU_id(userId);
    evaluateBean.setE_time(new Date());
    int count = evaluateService.insertEvaluate(evaluateBean);
    if (count > 0) {
      return ResultUntil.result(ResultUntil.code200, count, "增加成功");
    } else {
      return ResultUntil.result(ResultUntil.code500, "", "增加失败");
    }
  }

  /**
   * 删除评论
   *
   * @param e_id
   * @return
   */
  @GetMapping("/deleteEvaluate")
  public ResultBean deleteEvaluate(int e_id) {
    int count = evaluateService.deleteEvaluate(e_id);
    if (count > 0) {
      return ResultUntil.result(ResultUntil.code200, count, "删除成功");
    } else {
      return ResultUntil.result(ResultUntil.code500, "", "删除失败");
    }
  }

  /**
   * 根据小说的的id查询属于该小说的所有评论
   *
   * @param n_id
   * @return
   */
  @PostMapping("/selectAllEvaluatNovelId")
  public ResultBean selectAllEvaluatNovelId(int n_id) {
    List<EvaluateBean> beanList = evaluateService.selectAllEvaluateNovelId(n_id);
    if (beanList != null) {
      return ResultUntil.result(ResultUntil.code200, beanList, "查询成功");
    } else {
      return ResultUntil.result(ResultUntil.code500, "", "查询失败");
    }
  }

}
