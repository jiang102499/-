package com.example.novel.controller;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/10/4
 * Description: com.example.novel.controller
 * version: 1.0
 */

import com.example.novel.bean.NovelBean;
import com.example.novel.bean.ResultBean;
import com.example.novel.bean.dto.NovelBeanDto;
import com.example.novel.service.NovelService;
import com.example.novel.until.ResultUntil;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName NovelController
 * @Description TODO
 * @Author lenovo
 * @Date 2020/10/4 15:25
 * @Version 1.0
 **/
@RestController
@CrossOrigin
public class NovelController {

  @Autowired
  NovelService novelService;


  /**
   * 查询所有的小说
   *
   * @return
   */
  @GetMapping("/selectAllNovel")
  public ResultBean selectAllNovel() {

    List<NovelBean> novelBeans = novelService.selectAllNovel();
    return ResultUntil.result(ResultUntil.code200, novelBeans, "查询成功");
  }

  /**
   * 增加小说
   *
   * @param novelBeanDto
   * @return
   */
  @PostMapping("/insertNovel")
  public ResultBean insertNovel(NovelBeanDto novelBeanDto, MultipartFile file) {
    if (file.isEmpty()) {
      return ResultUntil.result(ResultUntil.code500, "", "请选择文件");
    }
    String fileName = file.getOriginalFilename();//获取文件名
    String suffixName = fileName.substring(fileName.lastIndexOf("."));//后缀
    String path = "C:\\Users\\lenovo\\Desktop\\pic";//文件存储位置
    File dest = new File(path + "\\" + fileName);
    if (!dest.getParentFile().exists()) {
      dest.getParentFile().mkdirs();
    }
    try {
      file.transferTo(dest);
      String url = "\\pic\\" + fileName;
      novelBeanDto.setN_img(url);
      int count = novelService.insertNovel(novelBeanDto);
      if (count > 0) {
        return ResultUntil.result(ResultUntil.code200, count, "增加成功");
      } else {
        return ResultUntil.result(ResultUntil.code500, " ", "增加失败");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ResultUntil.result(ResultUntil.code500, "", "别乱搞");
  }

  /**
   * 通过小说id查询该小说的所有信息
   *
   * @param n_id
   * @return
   */
  @GetMapping("/selectNovelId")
  public ResultBean selectNovelId(int n_id) {
    NovelBean bean = novelService.selectNovelId(n_id);
    return ResultUntil.result(ResultUntil.code200, bean, "查询成功");
  }

  /**
   * 修改小说
   *
   * @param novelBeanDto
   * @return
   */
  @PostMapping("/updateNovel")
  public ResultBean updateNovel(NovelBeanDto novelBeanDto, MultipartFile file) {
    if (file.isEmpty()) {
      return ResultUntil.result(ResultUntil.code500, "", "请选择文件");
    }
    String fileName = file.getOriginalFilename();//获取文件名
    String subffixName = fileName.substring(fileName.lastIndexOf("."));//后缀名
    String path = "C:\\Users\\lenovo\\Desktop\\pic";//文件存储位置
    File dest = new File(path + "\\" + fileName);
    if (!dest.getParentFile().exists()) {
      dest.getParentFile().mkdirs();
    }
    try {
      file.transferTo(dest);
      String url = "\\pic\\" + fileName;
      novelBeanDto.setN_img(url);
      int count = novelService.updateNovel(novelBeanDto);
      if (count > 0) {
        return ResultUntil.result(ResultUntil.code200, count, "修改成功");
      } else {
        return ResultUntil.result(ResultUntil.code500, " ", "修改失败");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ResultUntil.result(ResultUntil.code500, "", "别乱搞");
  }

  /**
   * 删除小说
   *
   * @param n_id
   * @return
   */
  @GetMapping("/deleteNovel")
  public ResultBean deleteNovel(int n_id) {
    int count = novelService.deleteNovel(n_id);
    if (count > 0) {
      return ResultUntil.result(ResultUntil.code200, count, "删除成功");
    } else {
      return ResultUntil.result(ResultUntil.code500, " ", "删除失败");
    }
  }

  /**
   * 根据作者id查询属于该作者的所有小说
   *
   * @param w_id
   * @return
   */
  @GetMapping("/selectNovelWriterId")
  public ResultBean selectNovelWriterId(int w_id) {
    List<NovelBean> beanList = novelService.selectNovelWriterId(w_id);
    if (beanList != null) {
      return ResultUntil.result(ResultUntil.code200, beanList, "查询成功");
    } else {
      return ResultUntil.result(ResultUntil.code500, "", "查询失败");
    }
  }


}
