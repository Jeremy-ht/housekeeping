package com.isoft.service;

import com.isoft.pojo.entity.Info;
import com.baomidou.mybatisplus.extension.service.IService;
import com.isoft.utils.ResponseData;


public interface InfoService extends IService<Info> {

	ResponseData getInfoDeatilById(Integer id);

	ResponseData getInfoByCategoryId(Integer id);
}
