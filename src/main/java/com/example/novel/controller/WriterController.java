package com.example.novel.controller;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/30
 * Description: com.example.novel.controller
 * version: 1.0
 */

import com.example.novel.bean.ResultBean;
import com.example.novel.bean.WriterBean;
import com.example.novel.service.WriterService;
import com.example.novel.until.ResultUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName WriterController
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/30 9:36
 * @Version 1.0
 **/
@RestController
public class WriterController {
  @Autowired
  WriterService writerService;


  /**
   * 签约作者
   *
   * @param writerBean
   * @return
   */
  @PostMapping("/sginupWriter")
  public ResultBean signupWriter(WriterBean writerBean) {
    int count = writerService.signupWriter(writerBean);
    return ResultUntil.result(ResultUntil.code200, count, "签约成功");
  }

  /**
   * 根据id查询作者信息，用于修改
   *
   * @param w_id
   * @return
   */
  @GetMapping("/selectWriter")
  public ResultBean selectWriter(int w_id) {
    WriterBean writerBean = writerService.selectWriter(w_id);
    return ResultUntil.result(ResultUntil.code200, writerBean, "查询成功");
  }


  /**
   * 修改作者信息
   *
   * @param writerBean
   * @return
   */
  @PostMapping("/updateWriter")
  public ResultBean updateWriter(WriterBean writerBean) {
    int count = writerService.updateWriter(writerBean);
    if (count > 0) {
      return ResultUntil.result(ResultUntil.code200, count, "修改成功");
    } else {
      return ResultUntil.result(ResultUntil.code500, " ", "修改失败");
    }
  }


  /**
   * 删除作者
   *
   * @param w_id
   * @return
   */
  @GetMapping("/deleteWriter")
  public ResultBean deleteWriter(int w_id) {
    int count = writerService.deleteWriter(w_id);
    if (count > 0) {
      return ResultUntil.result(count, count, "删除成功");
    } else {
      return ResultUntil.result(ResultUntil.code500, " ", "删除失败");
    }
  }


}
