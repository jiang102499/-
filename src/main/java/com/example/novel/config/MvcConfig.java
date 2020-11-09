package com.example.novel.config;

import com.example.novel.HandlerInterceptor.LoginHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.Basic;

/**
 * @ClassName MvcConfig
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/11 15:24
 * @Version 1.0
 **/
@Component
public class MvcConfig implements WebMvcConfigurer {


  @Bean
  public WebMvcConfigurer webMvcConfigurer() {
    WebMvcConfigurer mvcConfigurer = new WebMvcConfigurer() {
      //配置拦截器
      @Override
      public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns表示请求拦截,excludePathPatterns表示通行请求
        registry.addInterceptor(new LoginHandler()).addPathPatterns("/**").
          excludePathPatterns("/user/login")
          //注册
          .excludePathPatterns("/user/register")
          .excludePathPatterns("/user/register2")
//          //跳转修改界面
//        .excludePathPatterns("/topage")
//          //跳转修改界面
//        .excludePathPatterns("/topageUpdate")
//          //修改用户
//        .excludePathPatterns("/updateUser")
//          //根据用户id查询是否拥有书架，没有的话就创建
//        .excludePathPatterns("/whetherHaveBookShelf")
          //放行资源
          .excludePathPatterns("/favicon.ico")
          //放行资源
          .excludePathPatterns("/error")
          //查询根据类别查询属于该类别的所有小说
          .excludePathPatterns("/selectCategory")
          .excludePathPatterns("/selectCategoryById")
          //查询状态为完结的所有小说
          .excludePathPatterns("/selectEnd")
          //查询状态为连载的所有小说
          .excludePathPatterns("/selectUnEnd")
          //排行
          .excludePathPatterns("/ranking")
//          //增加分类的类别
//        .excludePathPatterns("/insertCategory")
//          //删除分类类别
//        .excludePathPatterns("/deleteCategory")
//          //根据cg_id查询该信息的属性，再修改
//        .excludePathPatterns("/selectupdate")
//          //修改类别
//        .excludePathPatterns("/updateCategory")
//          //签约作者
//        .excludePathPatterns("/sginupWriter")
//          //根据id查询作者信息，用于修改
//        .excludePathPatterns("/selectWriter")
//          //修改作者信息
//        .excludePathPatterns("/updateWriter")
//          //删除作者信息
//        .excludePathPatterns("/deleteWriter")
//          //爬取数据
//        .excludePathPatterns("/reptile")
          //查询所有的小说
          .excludePathPatterns("/selectAllNovel")
          //根据作者id查询属于该作者的所有小说
          .excludePathPatterns("/selectNovelWriterId")
//          //删除小说
//        .excludePathPatterns("/deleteNovel")
//          //增加小说
//        .excludePathPatterns("/insertNovel")
//          //修改小说
//        .excludePathPatterns("/updateNovel")
//          //增加章节
//        .excludePathPatterns("/insertChapter")
//          //删除评论
//        .excludePathPatterns("/deleteEvaluate")
          //根据小说id查询关于该小说的所有评论
          .excludePathPatterns("/selectAllEvaluatNovelId")
          //根据小说id查询该小说的目录章节，以及内容
          .excludePathPatterns("/selectAllChapterNovelId")
          .excludePathPatterns("/selectChapterNovelId")
          .excludePathPatterns("/selectCountChapterNovel")
          //获取图片
          .excludePathPatterns("/pic/**")
          //下载
          .excludePathPatterns("/download")
        ;
      }


      @Override
      public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //文件磁盘图片url 映射
        //配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
        registry.addResourceHandler("/pic/**").addResourceLocations("file:///C:/Users/lenovo/Desktop/pic/");
      }
    };
    return mvcConfigurer;
  }
}
