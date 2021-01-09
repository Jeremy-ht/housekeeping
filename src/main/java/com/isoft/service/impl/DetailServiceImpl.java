package com.isoft.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.pojo.entity.Detail;
import com.isoft.dao.DetailMapper;
import com.isoft.pojo.vo.DetailVo;
import com.isoft.pojo.vo.EchartsVo;
import com.isoft.service.DetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.isoft.utils.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ht
 * @since 2020-11-26
 */
@Service
@Slf4j
public class DetailServiceImpl extends ServiceImpl<DetailMapper, Detail> implements DetailService {

    @Autowired
    private DetailMapper detailMapper;

    @Override
    public Page<DetailVo> getSceneryList(long pagenum, long pagesize,
                                         Integer categoryId, Integer draft, Integer creator) {
        Page<DetailVo> page = new Page<>(pagenum, pagesize);
        try {
            Page<DetailVo> p = detailMapper.getSceneryList(page, categoryId, draft, creator);
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("DetailServiceImpl：错误" + e);
            return null;
        }


    }

    @Override
    public ResponseData getSceneryInfo(Integer id) {
        DetailVo d = detailMapper.getSceneryInfo(id);
        if (StringUtils.isEmpty(d)) {
            return ResponseData.error().message("获取详情失败！");
        }
        return ResponseData.success().message("获取详情成功！").data("data", d);
    }

    @Override
    public boolean pullScenery(Integer id) {

        return detailMapper.pullScenery(id) == 1;
    }

    @Override
    public int countDetail() {

        return detailMapper.countDetail();
    }

    @Override
    public List<Detail> getSearchContent(String content) {
        return detailMapper.getSearchContent(content);
    }

    @Override
    public List<EchartsVo> getEchartsCategory() {
        return detailMapper.getEchartsCategory();
    }

    @Override
    public List<EchartsVo> getEchartsUser() {
        int year = LocalDate.now().getYear();
        return detailMapper.getEchartsUser(String.valueOf(year));
    }
}
