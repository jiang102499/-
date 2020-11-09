package com.example.novel;

import com.example.novel.bean.UserBean;
import com.example.novel.service.UserService;
import com.example.novel.until.JWTUntils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootTest
class NovelApplicationTests {

  @Test
  void contextLoads() {
    UserBean userBean = new UserBean();
    userBean.setId(1);
    userBean.setName("zhangsan");
    userBean.setPassword("123");
    String token = JWTUntils.geneJsonWebToken(userBean);
    System.out.println("token令牌为：" + token);
  }

  @Test
  void chectJWT() {
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZGNsYXNzIiwiaWQiOjEsIm5hbWUiOiJ6aGFuZ3NhbiIsInBhc3N3b3JkIjoiMTIzIiwiaWF0IjoxNjAwMDQ4NzY4LCJleHAiOjE2MDA2NTM1Njh9.PT0_9RVnpXaZeE75g5R2AxuOvlV025QAu9roi0AddbE";
    Claims claims = JWTUntils.checkJWT(token);
    if (claims != null) {
      int id = (Integer) claims.get("id");
      String name = (String) claims.get("name");
      String password = (String) claims.get("password");
      System.out.println(id);
      System.out.println(name);
      System.out.println(password);
    } else {
      System.out.println("非法token");
    }
  }


  @Test
  void Test2() {
    // ==和equals的区别
    String a = "aaa";
    String b = "aaa";
    String c = new String("abc");
    String d = new String("abc");
    System.out.println(a == b);
    System.out.println(a.equals(b));
    System.out.println(c == d);
    System.out.println(c.equals(d));

  }


}

