package com.isoft.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.pojo.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.pojo.vo.CategoryVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ht
 * @since 2020-11-26
 */
public interface CategoryService extends IService<Category> {

    Page<CategoryVo> getCateList(long pagenum, long pagesize);
}
