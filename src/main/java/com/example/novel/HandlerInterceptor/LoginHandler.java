package com.example.novel.HandlerInterceptor;

import com.example.novel.bean.UserBean;
import com.example.novel.service.UserService;
import com.example.novel.serviceImpl.UserServiceImpl;
import com.example.novel.until.JWTUntils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginHandler
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/11 14:57
 * @Version 1.0
 **/
public class LoginHandler implements HandlerInterceptor {

  @Autowired
  private UserService userService;


  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


    //getHeader 传入数据
    System.out.println(request.getServletPath());
    String logintoken = request.getHeader("jwt");
    if (logintoken != null) {
      Claims claims = JWTUntils.checkJWT(logintoken);
      int id = (Integer) claims.get("id");
      request.setAttribute("userid", id);
      System.out.println(id);
      return true;
    } else {
      System.out.println("获取权限失败");
//      response.sendRedirect("/user/login?name=zhangsan&password=123");
      return false;
    }
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

  }
}
