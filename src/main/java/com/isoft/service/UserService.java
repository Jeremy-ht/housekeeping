package com.isoft.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.pojo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ht
 * @since 2020-11-26
 */
public interface UserService extends IService<User> {

    Page<User> getCateList(long pagenum, long pagesize);

    boolean updAbleUserById(int parseInt , Integer state);

    int countUser();

    int countUser2();
}
