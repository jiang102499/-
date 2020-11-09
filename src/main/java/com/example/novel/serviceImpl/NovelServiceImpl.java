package com.example.novel.serviceImpl;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/10/4
 * Description: com.example.novel.serviceImpl
 * version: 1.0
 */

import com.example.novel.bean.NovelBean;
import com.example.novel.bean.dto.NovelBeanDto;
import com.example.novel.mapper.NovelMapper;
import com.example.novel.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName NovelServiceImpl
 * @Description TODO
 * @Author lenovo
 * @Date 2020/10/4 15:25
 * @Version 1.0
 **/
@Service
public class NovelServiceImpl implements NovelService {

  @Autowired
  NovelMapper mapper;

  @Override
  public List<NovelBean> selectAllNovel() {
    return mapper.selectAllNovel();
  }

  @Override
  public int insertNovel(NovelBeanDto novelBeanDto) {
    return mapper.insertNovel(novelBeanDto);
  }

  @Override
  public NovelBean selectNovelId(int n_id) {
    return mapper.selectNovelId(n_id);
  }

  @Override
  public int updateNovel(NovelBeanDto novelBeanDto) {
    return mapper.updateNovel(novelBeanDto);
  }

  @Override
  public int deleteNovel(int n_id) {
    return mapper.deleteNovel(n_id);
  }

  @Override
  public List<NovelBean> selectNovelWriterId(int w_id) {
    return mapper.selectNovelWriterId(w_id);
  }
}
