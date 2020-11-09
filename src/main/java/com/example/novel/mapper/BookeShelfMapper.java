package com.example.novel.mapper;

import com.example.novel.bean.BookShelfBean;
import com.example.novel.bean.CentreBookShelfBean;
import com.example.novel.bean.NovelBean;
import com.example.novel.bean.NovelUserCentreBean;
import com.example.novel.bean.dto.CentreBookShelfBeanDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/9/23
 * Description: com.example.novel.mapper
 * version: 1.0
 */
@Mapper
@Repository
public interface BookeShelfMapper {

  //更加id查询该用户是否拥有书架
  public BookShelfBean selectHaveBookShelf(int id);

  //根据用户id创建书架
  public int creatBookShelf(int id);

  //收藏小说
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

  //查看该用户的阅读历史
  public List<NovelUserCentreBean> readHistory(int u_id);
}
