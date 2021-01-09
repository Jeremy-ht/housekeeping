package com.isoft.service.impl;

import com.isoft.dao.DetailMapper;
import com.isoft.pojo.entity.Info;
import com.isoft.dao.InfoMapper;
import com.isoft.pojo.vo.DetailVo;
import com.isoft.service.InfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-09
 */
@Service
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements InfoService {
	@Autowired
	private InfoMapper infoMapper;


	@Override
	public ResponseData getInfoDeatilById(Integer id) {
		Info d = infoMapper.getInfoDeatilById(id);
		if (StringUtils.isEmpty(d)) {
			return ResponseData.error().message("获取详情失败！");
		}
		return ResponseData.success().message("获取详情成功！").data("data", d);
	}

	@Override
	public ResponseData getInfoByCategoryId(Integer id) {
		return null;
	}
}
