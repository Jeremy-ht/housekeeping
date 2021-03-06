package com.isoft.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.pojo.entity.Detail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.pojo.vo.DetailVo;
import com.isoft.pojo.vo.EchartsVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface DetailMapper extends BaseMapper<Detail> {

    Page<DetailVo> getSceneryList(@Param("page") Page<DetailVo> page,
                                  @Param("categoryId") Integer categoryId,
                                  @Param("draft") Integer draft,
                                  @Param("creator") Integer creator);

    DetailVo getSceneryInfo(Integer id);

    @Update("update detail set draft = 1 where id = #{id}")
    int pullScenery(Integer id);

    @Select("SELECT count(1) FROM detail WHERE releasetime >= CURDATE() and state = 1 and draft = 1")
    int countDetail();

    List<Detail> getSearchContent(String content);

    List<EchartsVo> getEchartsCategory();

    List<EchartsVo> getEchartsUser(String date);

    List<EchartsVo> getEchartsYY(String valueOf);

    List<EchartsVo> getEchartsInfo(String valueOf);
}
