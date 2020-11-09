package com.example.novel.controller;

import com.example.novel.bean.ResultBean;
import com.example.novel.bean.ResultBean2;
import com.example.novel.bean.UserBean;
import com.example.novel.service.BookShelfService;
import com.example.novel.service.UserService;
import com.example.novel.until.JWTUntils;
import com.example.novel.until.ResultUntil;
import com.example.novel.until.ResultUntil2;
import io.jsonwebtoken.Claims;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.invoke.SerializedLambda;
import java.util.UUID;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/11 9:14
 * @Version 1.0
 **/
@RestController
public class LoginController {

  @Autowired
  UserService userService;

  /**
   * 登录
   *
   * @param userBean
   * @param request
   * @return
   */
  @PostMapping("/user/login")
  public ResultBean2 loginUser(UserBean userBean, HttpServletRequest request) {
    UserBean user = userService.loginUser(userBean);
    if (user != null) {
      //生成jwt token令牌
      String token = JWTUntils.geneJsonWebToken(user);
      System.out.println("生成jwt令牌：" + token);
      return ResultUntil2.result(ResultUntil.code200, token, user, "登录成功");
    } else {
      return ResultUntil2.result(ResultUntil.code500, " ", "", "登录失败");
    }

  }

  /**
   * 跳转到修改界面
   *
   * @param id
   * @return
   */
  @GetMapping("/topageUpdate")
  public ResultBean toPageUpdate(int id) {
    UserBean user = userService.selectUser(id);
    return ResultUntil.result(ResultUntil.code200, user, "查询成功");
  }

  @PostMapping("/updateUser")
  public ResultBean updateUser(UserBean userBean) {
    int count = userService.update(userBean);
    return ResultUntil.result(ResultUntil.code200, count, "修改成功");
  }

}
