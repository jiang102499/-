package com.example.novel.service;

import com.example.novel.bean.BookShelfBean;
import com.example.novel.bean.CentreBookShelfBean;
import com.example.novel.bean.NovelBean;
import com.example.novel.bean.NovelUserCentreBean;
import com.example.novel.bean.dto.CentreBookShelfBeanDto;

import java.util.List;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/23
 * Description: com.example.novel.service
 * version: 1.0
 */
public interface BookShelfService {

  /**
   * 根据id查询该用户是否拥有书架
   *
   * @param id
   * @return
   */
  public BookShelfBean selectHaveBookShelf(int id);

  /**
   * 根据用户id创建书架
   *
   * @param id
   * @return
   */
  public int creatBookShelf(int id);

  /**
   * 收藏小说
   *
   * @param centreBean
   * @return
   */
  public int collectNovel(CentreBookShelfBean centreBean);


  /**
   * 根据书架id，查询该书架的收藏的所有小说
   *
   * @param centreBookShelfBeanDto
   * @return
   */
  public List<CentreBookShelfBeanDto> selectCollectNovel(CentreBookShelfBeanDto centreBookShelfBeanDto);

  /**
   * 删除收藏的小说
   *
   * @param centreBookShelfBean
   * @return
   */
  public int deleteCollectNovel(CentreBookShelfBean centreBookShelfBean);

  /**
   * 查看该用户的阅读历史
   *
   * @param u_id
   * @return
   */
  public List<NovelUserCentreBean> readHistory(int u_id);

}
