package com.isoft.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.pojo.entity.Detail;
import com.isoft.pojo.entity.Info;
import com.isoft.pojo.entity.Skills;
import com.isoft.pojo.vo.DetailVo;
import com.isoft.pojo.vo.InfoVo;
import com.isoft.service.InfoService;
import com.isoft.service.SkillsService;
import com.isoft.utils.ResponseData;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/info")
@Api(tags = "家政人员管理")
public class InfoController {

	@Autowired
	private InfoService infoService;

	@Autowired
	private SkillsService skillsService;


	/**
	 * 添加家政人员
	 */
	@PostMapping("/addInfo")
	public ResponseData addInfo(@RequestBody Info info) {

		return infoService.save(info) ? ResponseData.success().message("添加成功")
				: ResponseData.error().message("添加失败");
	}


	/**
	 * 删除家政人员
	 */
	@GetMapping("/delInfo/{id}")
	public ResponseData delInfo(@PathVariable("id") Integer id) {
		if (id == null) {
			return ResponseData.error().message("请求参数不能为空");
		}

		return infoService.removeById(id) ? ResponseData.success().message("删除成功")
				: ResponseData.error().message("删除失败");
	}


	/**
	 * 获取家政人员具体信息
	 */
	@GetMapping("/getInfoDeatilById/{id}")
	public ResponseData getInfoDeatilById(@PathVariable("id") Integer id) {

		Info info = infoService.getById(id);
		if (info == null) {
			return ResponseData.error().message("没有查询到该家政人员信息，请刷新再试");
		}

		List<Skills> skillsname = skillsService.list(new QueryWrapper<Skills>().eq("infoid", id));
		Map<String, Object> map = new HashMap<>();
		map.put("info", info);
		map.put("skillsname", skillsname);
		return ResponseData.success().data(map);
	}

	/**
	 *
	 * @param pagenum
	 * @param pagesize
	 * @param id 分类id
	 * @return
	 */
	@GetMapping("/getInfoList/{id}")
	public ResponseData getInfoList(@RequestParam(name = "pagenum", defaultValue = "1", required = false) long pagenum,
									   @RequestParam(name = "pagesize", defaultValue = "100", required = false) long pagesize,
									   @PathVariable("id") Integer id) {

		Page<InfoVo> page = infoService.getInfoList(pagenum, pagesize, id);
		if (page != null) {
			Map<String, Object> map = new HashMap<>();
			map.put("total", page.getTotal());
			map.put("data", page.getRecords());
			return ResponseData.success().message("获取成功！").data(map);
		}
		return ResponseData.error().message("获取失败！");

	}



}

