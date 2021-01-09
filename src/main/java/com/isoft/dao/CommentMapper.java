package com.isoft.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.pojo.entity.Comment;
import com.isoft.pojo.vo.CommentVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ht
 * @since 2020-11-26
 */
public interface CommentMapper extends BaseMapper<Comment> {


    Page<CommentVo> getCommentList(@Param("page") Page<CommentVo> page,
								   @Param("detailId") Integer detailId);

    @Update("update scenery_comment set state = #{state} where id = #{id}")
    int updCommentState(Integer id, Integer state);

    @Select("SELECT count(1) FROM scenery_comment WHERE creatime >= CURDATE() and state = 1")
    int countComment();
}
