package com.isoft.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.pojo.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.pojo.vo.AdminVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ht
 * @since 2020-11-26
 */
public interface AdminMapper extends BaseMapper<Admin> {

    Page<AdminVo> selCateList(Page<AdminVo> page);

    @Update("update scenery_admin set password = #{newPas} where id = #{id} ")
    int updPwdById(@Param("id") Integer id,
                   @Param("newPas") String newPas);
}
