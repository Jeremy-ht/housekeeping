package com.isoft.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.enums.ResultCodeEnum;
import com.isoft.pojo.entity.User;
import com.isoft.pojo.vo.LoginlogVo;
import com.isoft.service.UserService;
import com.isoft.utils.CommonUtil;
import com.isoft.utils.MD5Code;
import com.isoft.utils.ResponseData;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;



    /**
     * 注册（用户名密码）
     */
    @PostMapping("/addUser")
    public ResponseData addUser(@RequestBody User user) {
        if (org.apache.commons.lang3.StringUtils.isBlank(user.getUname())) {
            return ResponseData.error().message("用户名不能为空");
        }
        if (org.apache.commons.lang3.StringUtils.isBlank(user.getPwd())) {
            return ResponseData.error().message("密码不能为空");
        }
        if (org.apache.commons.lang3.StringUtils.isBlank(user.getPhone())) {
            return ResponseData.error().message("手机号不能为空");
        }
        user.setImage("https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png");
        String salt = CommonUtil.getRandomSixNum();
        user.setSalt(salt);
        MD5Code md5Code = new MD5Code();
        String aaaaa = md5Code.getMD5ofStr(user.getPwd() + salt);
        user.setPwd(aaaaa);
        user.setLoginway(0);    // 0-密码，1-手机号
        return userService.save(user) ? ResponseData.success().message("恭喜你，注册成功！").data("data", user.getUname())
                : ResponseData.error().code(ResultCodeEnum.FAILED.getCode()).message("注册失败了请重试!");
    }


    /**
     * 预留手机号登录（登录、注册）
     */


    /**
     * 发送验证码
     */

    /**
     * 用户名、密码登录
     */
    @PostMapping("/userLogin")
    public ResponseData userLogin(@RequestBody LoginlogVo loginlogVo) {
        if (org.apache.commons.lang3.StringUtils.isBlank(loginlogVo.getUname()) ||
                org.apache.commons.lang3.StringUtils.isBlank(loginlogVo.getPwd())) {
            return ResponseData.error().message("用户名或密码不能为空！");
        }

        User user = userService.getOne(new QueryWrapper<User>().eq("uname", loginlogVo.getUname()));
        if (org.springframework.util.StringUtils.isEmpty(user)) {
            return ResponseData.error().message("用户不存在，请重新登录！");
        }
        if (user.getState() == 2) {
            return ResponseData.error().message("您已经被禁止登录，详情请咨询客服！");
        }
        String salt = user.getSalt();
        MD5Code md5Code = new MD5Code();
        String md5ofStr = md5Code.getMD5ofStr(loginlogVo.getPwd() + salt);
        if (!org.apache.commons.lang3.StringUtils.equals(md5ofStr, user.getPwd())) {
            return ResponseData.error().message("密码错误，请重试！");
        }
        return ResponseData.success().message("登录成功").data("data", user);
    }


    /**
     * 修改用户信息
     */
    @PostMapping("updUserInfo")
    public ResponseData updUserInfo(@RequestBody User user) {
        if (StringUtils.isEmpty(user)) {
            return ResponseData.error().message("请求参数不能为空!");
        }
        return userService.updateByIds(user) ? ResponseData.success().message("修改信息成功！").data("data", user)
                : ResponseData.error().message("修改信息失败!");
    }


    /**
     * 禁用用户登录       state = 2 禁止登录
     */
    @GetMapping("/disableUserById/{userId}")
    public ResponseData disableUserById(@PathVariable("userId") String userId) {
        Integer state = 2;
        return userService.updAbleUserById(Integer.parseInt(userId), state) ? ResponseData.success().message("禁用用户登录成功!")
                : ResponseData.error().message("禁用用户登录失败!");
    }

    /**
     * 解禁用户登录       state = 2 禁止登录
     */
    @GetMapping("/ableUserById/{userId}")
    public ResponseData ableUserById(@PathVariable("userId") String userId) {
        Integer state = 1;
        return userService.updAbleUserById(Integer.parseInt(userId), state) ? ResponseData.success().message("解禁用户成功!")
                : ResponseData.error().message("解禁用户失败!");
    }


    /**
     * 获取user列表    分页+查询
     */
    @GetMapping("/getUserList")
    public ResponseData getUserList(@RequestParam(name = "pagenum", defaultValue = "1", required = false) long pagenum,
                                    @RequestParam(name = "pagesize", defaultValue = "10", required = false) long pagesize) {
        Page<User> page = userService.getCateList(pagenum, pagesize);
        if (page != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("total", page.getTotal());
            map.put("data", page.getRecords());
            return ResponseData.success().message("获取用户列表成功！").data(map);
        }
        return ResponseData.error().message("获取用户列表失败！");
    }


    @GetMapping("/getUserListByCategory/{id}")
    public ResponseData getUserListByCategory(@PathVariable("id") Integer id) {
//        userService.getUserListByCategory(id);

        return ResponseData.error().message("获取用户列表失败！");
    }



}

