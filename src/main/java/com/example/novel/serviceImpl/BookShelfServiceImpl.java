package com.example.novel.serviceImpl;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/23
 * Description: com.example.novel.serviceImpl
 * version: 1.0
 */

import com.example.novel.bean.BookShelfBean;
import com.example.novel.bean.CentreBookShelfBean;
import com.example.novel.bean.NovelBean;
import com.example.novel.bean.NovelUserCentreBean;
import com.example.novel.bean.dto.CentreBookShelfBeanDto;
import com.example.novel.mapper.BookeShelfMapper;
import com.example.novel.service.BookShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BookShelfServiceImpl
 * @Description TODO
 * @Author lenovo
 * @Date 2020/9/23 9:34
 * @Version 1.0
 **/
@Service
public class BookShelfServiceImpl implements BookShelfService {
  @Autowired
  BookeShelfMapper mapper;

  @Override
  public BookShelfBean selectHaveBookShelf(int id) {
    return mapper.selectHaveBookShelf(id);
  }

  @Override
  public int creatBookShelf(int id) {
    return mapper.creatBookShelf(id);
  }

  @Override
  public int collectNovel(CentreBookShelfBean centreBean) {
    return mapper.collectNovel(centreBean);
  }

  @Override
  public List<CentreBookShelfBeanDto> selectCollectNovel(CentreBookShelfBeanDto centreBookShelfBeanDto) {
    return mapper.selectCollectNovel(centreBookShelfBeanDto);
  }

  @Override
  public int deleteCollectNovel(CentreBookShelfBean centreBookShelfBean) {
    return mapper.deleteCollectNovel(centreBookShelfBean);
  }


  @Override
  public List<NovelUserCentreBean> readHistory(int u_id) {
    return mapper.readHistory(u_id);
  }

}
