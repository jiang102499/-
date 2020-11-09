package com.example.novel.serviceImpl;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/10/6
 * Description: com.example.novel.serviceImpl
 * version: 1.0
 */

import com.example.novel.bean.EvaluateBean;
import com.example.novel.mapper.EvaluateMapper;
import com.example.novel.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName EvaluateServiceImpl
 * @Description TODO
 * @Author lenovo
 * @Date 2020/10/6 17:23
 * @Version 1.0
 **/
@Service
public class EvaluateServiceImpl implements EvaluateService {

  @Autowired
  EvaluateMapper mapper;

  @Override
  public int insertEvaluate(EvaluateBean evaluateBean) {
    return mapper.insertEvaluate(evaluateBean);
  }

  @Override
  public int deleteEvaluate(int e_id) {
    return mapper.deleteEvaluate(e_id);
  }

  @Override
  public List<EvaluateBean> selectAllEvaluateNovelId(int n_id) {
    return mapper.selectAllEvaluateNovelId(n_id);
  }
}
