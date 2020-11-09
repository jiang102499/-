package com.example.novel.test;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/10/30
 * Description: com.example.novel.test
 * version: 1.0
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @ClassName test3
 * @Description TODO
 * @Author lenovo
 * @Date 2020/10/30 11:26
 * @Version 1.0
 **/
public class test3 {


  public static void main(String[] args) {
    test3 t3 = new test3();
    t3.addDateMinut();
  }

  public void addDateMinut() {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = null;
    try {
      Scanner scanner = new Scanner(System.in);
      System.out.println("输入起始时间：");
      String day = scanner.nextLine();
      date = format.parse(day);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("front:" + format.format(date)); //显示输入的日期
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.HOUR, 1);// 24小时制
    date = cal.getTime();
    System.out.println("after:" + format.format(date));  //显示更新后的日期

  }
}
