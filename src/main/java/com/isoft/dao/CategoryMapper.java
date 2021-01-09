package com.isoft.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.pojo.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.pojo.vo.CategoryVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ht
 * @since 2020-11-26
 */
public interface CategoryMapper extends BaseMapper<Category> {

    Page<CategoryVo> selCateList(Page<CategoryVo> page);
}
