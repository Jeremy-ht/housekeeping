package com.isoft.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2021-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Reservation implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userid;

    /**
     * 家政人员id

     */
    private Integer infoid;

    /**
     * 预约时间
     */
    private LocalDateTime reservationtime;

    private LocalDateTime creatime;

    private Integer state;


}
