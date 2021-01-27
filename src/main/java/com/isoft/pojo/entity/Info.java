package com.isoft.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer sex;

    private Integer age;

    /**
     * 籍贯
     */
    private String nativeplace;

    /**
     * 婚姻状况
     */
    private String marriage;

    /**
     * 当前状态
     */
    private Integer currentstate;

    private Integer height;

    private Integer weight;

    /**
     * 工作经验
     */
    private Integer workexper;

    private Integer salary;

    private Integer noroom;

    private String introduction;

    private LocalDateTime creatime;

    private Integer state;

    private Integer creator;

    private String image;

    private Integer categoryid;
}
