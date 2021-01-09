package com.isoft.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.pojo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ht
 * @since 2020-11-26
 */
public interface UserMapper extends BaseMapper<User> {

    Page<User> selCateList(Page<User> page);

    int updAbleUserById(@Param("id") int id,
                        @Param("state") Integer state);

    @Select("SELECT count(1) FROM scenery_user WHERE creatime >= CURDATE() and (state = 1 or state = 2)")
    int countUser();

    @Select("SELECT count(1) FROM scenery_user")
    int countUser2();
}
