package com.example.novel.controller;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/15
 * Description: com.example.novel.controller
 * version: 1.0
 */

import com.example.novel.bean.ResultBean;
import com.example.novel.bean.UserBean;
import com.example.novel.service.BookShelfService;
import com.example.novel.service.RegisterService;
import com.example.novel.service.UserService;
import com.example.novel.until.ResultUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName RegisterController
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/15 19:33
 * @Version 1.0
 **/
@Controller
public class RegisterController {

  @Autowired
  RegisterService service;

  @Autowired
  BookShelfService shelfService;

  @Autowired
  UserService userService;


  @GetMapping("/topage")
  public String topage() {
    return "add";
  }

  /**
   * 注册
   *
   * @param userBean
   * @param file
   * @return
   */
  @PostMapping("/user/register")
  @ResponseBody
  public ResultBean registerUser(UserBean userBean, MultipartFile file) {
    if (file.isEmpty()) {
      return ResultUntil.result(ResultUntil.code500, " ", "请选择文件");
    }
    String fileName = file.getOriginalFilename();//文件名
    String suffixName = fileName.substring(fileName.lastIndexOf("."));//后缀名
    String path = "C:\\Users\\lenovo\\Desktop\\pic";//文件存储位置
    File dest = new File(path + "\\" + fileName);
    if (!dest.getParentFile().exists()) {//判断你输入的文件夹是否存在
      //getParentFile().mkdirs的含义
      //如果你输入的路径中的文件夹不存在，它会帮你创建，"C:\\Users\\lenovo\\Desktop\\pic\\logo.jpg"
      //如果你没有C:\\Users\\lenovo\\Desktop\\pic\\logo.jpg这个文件，它会创建一个文件
      //将相当于，你把你选择的文件上传后，它会在另一个文件夹里面创建你输入的文件，
      //就相当于是把你上传的所有文件，都放在这个C:\\Users\\lenovo\\Desktop\\pic文件夹里面
      dest.getParentFile().mkdirs();
    }
    try {
      file.transferTo(dest);
      String url = "/pic/" + fileName;
      //获取文件的路径
      System.out.println(url);
      userBean.setImg(url);
      String name = userBean.getName();
      int count = service.selectAlready(name);
      if (count > 0) {
        return ResultUntil.result(ResultUntil.code200, " ", "用户名已存在,请重新注册");
      } else {
        int count1 = service.register(userBean);
        if (count1 > 0) {
          return ResultUntil.result(ResultUntil.code200, count1, "注册成功");
        } else {
          return ResultUntil.result(ResultUntil.code401, "", "注册失败");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return ResultUntil.result(ResultUntil.code500, "", "你这操作我都没搞明白");
  }


  /**
   * 注册
   *
   * @param userBean
   * @param file
   * @return
   */
  @PostMapping("/user/register2")
  @ResponseBody
  public ResultBean registerUser2(UserBean userBean, MultipartFile file) {
    String name = userBean.getName();
    int count = service.selectAlready(name);
    if (count > 0) {
      return ResultUntil.result(ResultUntil.code200, " ", "用户名已存在,请重新注册");
    } else {
      int count1 = service.register(userBean);
      UserBean user = userService.loginUser(userBean);
      System.out.println(user);
      //获取用户id
      int id = user.getId();
      System.out.println(id);
      //创建暑假
      int count2 = shelfService.creatBookShelf(id);
      System.out.println(count2);
      if (count1 > 0) {
        return ResultUntil.result(ResultUntil.code200, count1, "注册成功");
      } else {
        return ResultUntil.result(ResultUntil.code401, "", "注册失败");
      }
    }
  }
}
