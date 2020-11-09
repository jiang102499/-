package com.example.novel.until;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/10/12
 * Description: com.example.novel.until
 * version: 1.0
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @ClassName DownUntils
 * @Description TODO
 * @Author lenovo
 * @Date 2020/10/12 11:05
 * @Version 1.0
 **/
@RestController
public class DownUntils {


  @GetMapping("/download")
  public String download(HttpServletResponse response) {
    //设置路径
    String downloadPath = "C:\\Users\\lenovo\\Desktop\\";
    //文件名
    String fileName = "index.docx";

    File file = new File(downloadPath + "\\" + fileName);
    if (file.exists()) {
      response.setContentType("application/force-download");// 设置强制下载不打开
      response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
      byte[] buffer = new byte[1024];
      //设置缓冲
      FileInputStream fis = null;
      BufferedInputStream bis = null;
      try {
        fis = new FileInputStream(file);
        bis = new BufferedInputStream(fis);
        OutputStream outputStream = response.getOutputStream();
        int i = bis.read(buffer);
        while (i != -1) {
          outputStream.write(buffer, 0, i);
          i = bis.read(buffer);
        }

        return "下载成功";
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        if (bis != null) {
          try {
            bis.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        if (fis != null) {
          try {
            fis.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
    return "下载失败";
  }

}
