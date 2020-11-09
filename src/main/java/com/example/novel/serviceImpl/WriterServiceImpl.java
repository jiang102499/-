package com.example.novel.serviceImpl;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/30
 * Description: com.example.novel.serviceImpl
 * version: 1.0
 */

import com.example.novel.bean.WriterBean;
import com.example.novel.mapper.WriterMapper;
import com.example.novel.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName WriterServiceImpl
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/30 9:19
 * @Version 1.0
 **/
@Service
public class WriterServiceImpl implements WriterService {


  @Autowired
  WriterMapper writerMapper;

  @Override
  public int signupWriter(WriterBean writerBean) {
    return writerMapper.signupWriter(writerBean);
  }

  @Override
  public WriterBean selectWriter(int w_id) {
    return writerMapper.selectWriter(w_id);
  }

  @Override
  public int updateWriter(WriterBean writerBean) {
    return writerMapper.updateWriter(writerBean);
  }

  @Override
  public int deleteWriter(int w_id) {
    return writerMapper.deleteWriter(w_id);
  }

}
