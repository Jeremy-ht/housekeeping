package com.isoft.dao;

import com.isoft.pojo.entity.Info;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.pojo.vo.DetailVo;

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
}
