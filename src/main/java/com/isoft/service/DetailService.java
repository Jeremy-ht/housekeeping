package com.isoft.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.pojo.entity.Detail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.pojo.vo.DetailVo;
import com.isoft.pojo.vo.EchartsVo;
import com.isoft.utils.ResponseData;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ht
 * @since 2020-11-26
 */
public interface DetailService extends IService<Detail> {

    Page<DetailVo> getSceneryList(long pagenum, long pagesize, Integer categoryId,Integer draft,Integer creator);

    ResponseData getSceneryInfo(Integer id);

    boolean pullScenery(Integer id);

    int countDetail();

    List<Detail> getSearchContent(String content);

    List<EchartsVo> getEchartsCategory();

    List<EchartsVo> getEchartsUser();
}
