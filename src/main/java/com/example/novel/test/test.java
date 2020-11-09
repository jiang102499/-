package com.example.novel.test;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/10/27
 * Description: com.example.novel.test
 * version: 1.0
 */

/**
 * @ClassName test
 * @Description TODO
 * @Author lenovo
 * @Date 2020/10/27 23:20
 * @Version 1.0
 **/
class A {

  static {
    System.out.print("1");
  }

  public A() {
    System.out.print("2");
  }
}

class B extends A {

  static {
    System.out.print("a");
  }

  public B() {
    System.out.print("b");
  }
}

public class test {

  public static void main(String[] args) {
    A ab = new B();
    System.out.println("==============================");
    ab = new B();
  }

}
