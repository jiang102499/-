package com.example.novel.test;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/10/30
 * Description: com.example.novel.test
 * version: 1.0
 */

import com.sun.org.apache.xpath.internal.operations.Minus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @ClassName test2
 * @Description TODO
 * @Author lenovo
 * @Date 2020/10/30 10:38
 * @Version 1.0
 **/
public class test2 {

  public static void main(String[] args) {

    test2 t = new test2();
    t.ObtainTime();

  }


  public void ObtainTime() {


    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    try {
      Scanner scanner = new Scanner(System.in);
      System.out.println("请输入起始时间：");
      String stime = scanner.nextLine();
      Date d1 = sdf.parse(stime);

      //获取到三小时后的时间
      Calendar c2 = Calendar.getInstance();
      c2.setTime(d1);
      c2.add(Calendar.HOUR, 3);
      String endTime = sdf.format(c2.getTime());
      System.out.println(endTime); //打印出三个小时后的时间
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }


}
