package com.isoft.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.pojo.entity.Info;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.pojo.vo.DetailVo;
import com.isoft.pojo.vo.InfoVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2021-01-09
 */
public interface InfoMapper extends BaseMapper<Info> {

	Info getInfoDeatilById(Integer id);

    Page<InfoVo> getInfoList(Page<InfoVo> page, Integer id);
}
