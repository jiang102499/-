package com.example.novel.serviceImpl;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/10/5
 * Description: com.example.novel.serviceImpl
 * version: 1.0
 */

import com.example.novel.bean.ChapterBean;
import com.example.novel.mapper.ChapterMapper;
import com.example.novel.service.ChapterService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ChapterServiceImpl
 * @Description TODO
 * @Author lenovo
 * @Date 2020/10/5 15:36
 * @Version 1.0
 **/
@Service
public class ChapterServiceImpl implements ChapterService {

  @Autowired
  ChapterMapper chapterMapper;

  @Override
  public int insertChapter(ChapterBean chapterBean) {
    return chapterMapper.insertChapter(chapterBean);
  }

  @Override
  public List<ChapterBean> selectAllChapterNovelId(int n_id) {
    return chapterMapper.selectAllChapterNovelId(n_id);
  }

  @Override
  public ChapterBean selectChapterNovelId(int n_id, int cn_id) {
    return chapterMapper.selectChapterNovelId(n_id, cn_id);
  }

  @Override
  public int selectCountChapterNovel(int n_id) {
    return chapterMapper.selectCountChapterNovel(n_id);
  }

}
