package com.isoft.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.pojo.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.pojo.vo.AdminVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ht
 * @since 2020-11-26
 */
public interface AdminService extends IService<Admin> {

    Page<AdminVo> getCateList(long pagenum, long pagesize);

    boolean updPwdById(Integer id, String newPas);
}
