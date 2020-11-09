package com.example.novel.until;

import com.example.novel.bean.UserBean;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/14
 * Description: com.example.novel.until
 * version: 1.0
 */

/**
 * jwt封装类
 */
public class JWTUntils {


  public static final String SUBJECT = "xdclass";

  public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;//过期时间，毫秒，一周

  public static final String APPSECRET = "xd666";  //秘钥

  /**
   * 生成 Jwt
   *
   * @param userBean
   * @return
   */
  public static String geneJsonWebToken(UserBean userBean) {

    if (userBean == null || userBean.getId() == 0 || userBean.getName() == null || userBean.getPassword() == null) {
      return null;
    }
    String token = Jwts.builder().setSubject(SUBJECT)
      .claim("id", userBean.getId())
      .claim("name", userBean.getName())
      .claim("password", userBean.getPassword())
      .setIssuedAt(new Date())   //SetIsuseAt发行时间
      .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))  //setExpiration:过期时间，
      .signWith(SignatureAlgorithm.HS256, APPSECRET).compact(); //signWith里面定义算法和密钥，最后compact使字符串紧密一下
    return token;  //最终返回的是一个字符串
  }

  /**
   * 校检
   *
   * @param token
   * @return
   */
  public static Claims checkJWT(String token) {
    try {
      final Claims claims = Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(token).getBody();
      return claims;
    } catch (Exception e) {
    }
    return null;
  }
}
