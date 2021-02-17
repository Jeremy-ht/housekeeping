package com.isoft.service.impl;

import com.isoft.pojo.entity.Reservation;
import com.isoft.dao.ReservationMapper;
import com.isoft.service.ReservationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class ReservationServiceImpl extends ServiceImpl<ReservationMapper, Reservation> implements ReservationService {

}
