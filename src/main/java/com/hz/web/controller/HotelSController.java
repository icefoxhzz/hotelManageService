package com.hz.web.controller;


import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.hz.web.ResponseEntiry.RestfulRet;
import com.hz.web.ResponseEntiry.ServiceDict;
import com.hz.web.entity.HotelSMenu;
import com.hz.web.service.HotelSService;
import com.swsk.lib.base.entity.SessionInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 房间信息表 前端控制器
 * </p>
 *
 * @author saber
 * @since 2023-12-07
 */
@Slf4j
@Controller
@RequestMapping("/hotel/sys")
public class HotelSController {
    @Autowired
    HotelSService hotelSService;

    @PostMapping(value = "/login")
    @ResponseBody
    public RestfulRet login(@RequestBody Map<String, String> userLoginMap) {
        RestfulRet restfulRet = new RestfulRet();
        restfulRet.setMsg("failed").setCode("-1");

        try {
            String name = userLoginMap.get("name");
            String pwd = userLoginMap.get("pwd");

            SessionInfo login = hotelSService.login(name, pwd);

            if (login != null) {
                restfulRet.setMsg("success").setCode("200").setData(JSONObject.from(login));
            }
        }catch (Exception ex){
            restfulRet.setMsg(ex.toString());
        }
        return restfulRet;
    }

    @PostMapping(value = "/loginOut")
    @ResponseBody
    public RestfulRet loginOut(@RequestBody Map<String, String> userLoginOutMap) {
        RestfulRet restfulRet = new RestfulRet();
        restfulRet.setMsg("failed").setCode("-1");

        try {
            String token = userLoginOutMap.get("token");
            if (hotelSService.logout(token)){
                restfulRet.setMsg("success").setCode("200");
            }
        }catch (Exception ex){
            restfulRet.setMsg(ex.toString());
        }
        return restfulRet;
    }

    @PostMapping(value = "/getMenuByRole")
    @ResponseBody
    public RestfulRet getMenuByRole(@RequestBody Map<String, String> roleMap) {
        RestfulRet restfulRet = new RestfulRet();
        restfulRet.setMsg("failed").setCode("-1");

        try {
            int role = Integer.parseInt(roleMap.get("role"));
            List<HotelSMenu> menus = hotelSService.getMenuByRole(role);
            if (menus != null){
                restfulRet.setMsg("success").setCode("200").setData(JSONArray.from(menus));
            }
        }catch (Exception ex){
            restfulRet.setMsg(ex.toString());
        }
        return restfulRet;
    }

}

