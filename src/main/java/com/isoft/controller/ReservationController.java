package com.isoft.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.isoft.dao.ReservationMapper;
import com.isoft.pojo.entity.Comment;
import com.isoft.pojo.entity.Reservation;
import com.isoft.pojo.vo.ReservationVo;
import com.isoft.service.CommentService;
import com.isoft.service.ReservationService;
import com.isoft.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ReservationMapper reservationMapper;

    @Autowired
    private CommentService commentService;

    @GetMapping("/goYY/{userid}/{infoid}")
    public ResponseData goYY(@PathVariable("userid") Integer userid,
                             @PathVariable("infoid") Integer infoid) {

        Reservation reservation = new Reservation();
        reservation.setUserid(userid);
        reservation.setInfoid(infoid);
        reservation.setIscomment(0);
        return reservationService.save(reservation) ? ResponseData.success().message("预约成功，请保持手机畅通")
                : ResponseData.error().message("预约失败");
    }

    @GetMapping("/isYY/{userid}/{infoid}")
    public ResponseData isYY(@PathVariable("userid") Integer userid,
                             @PathVariable("infoid") Integer infoid) {

        boolean temp = false;
        if (reservationMapper.isYY(userid, infoid) != null) {
            temp = true;
        }
        return ResponseData.success().message("预约成功，请保持手机畅通").data("data", temp);
    }

    @GetMapping("/getYYinfo/{userid}")
    public ResponseData getYYinfo(@PathVariable("userid") Integer userid) {
        List<ReservationVo> list = reservationMapper.getYYinfo(userid);
        return ResponseData.success().message("预约成功，请保持手机畅通").data("data", list);
    }


}

