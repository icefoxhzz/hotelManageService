package com.hz.web.controller;


import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.pagehelper.Page;
import com.hz.web.ResponseEntiry.ResCode;
import com.hz.web.entity.*;
import com.hz.web.service.HotelSService;
import com.hz.web.service.SessionService;
import com.swsk.lib.base.entity.ResponseEntity;
import com.swsk.lib.base.entity.SessionInfo;
import com.swsk.lib.base.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @Autowired
    SessionService sessionService;

    @PostMapping(value = "/login")
    @ResponseBody
    public ResponseEntity login(@RequestBody Map<String, String> userLoginMap) throws Exception {
        String name = userLoginMap.get("name");
        String pwd = userLoginMap.get("pwd");

        SessionInfo login = hotelSService.login(name, pwd);

        if (login != null) {
            return ResultUtil.success(login, "success");
        }

        return ResultUtil.error(null, "fail");
    }

    @PostMapping(value = "/loginOut")
    @ResponseBody
    public ResponseEntity loginOut(@RequestBody Map<String, String> userLoginOutMap) {
        String token = userLoginOutMap.get("token");
        if (hotelSService.logout(token)) {
            return ResultUtil.success(token, "success");
        }

        return ResultUtil.error(null, "fail");
    }

    @PostMapping(value = "/getMenuByRole")
    @ResponseBody
    public ResponseEntity getMenuByRole(@RequestBody Map<String, String> roleMap) {
        int role = Integer.parseInt(roleMap.get("role"));
        List<HotelSMenu> menus = hotelSService.getMenuByRole(role);
        if (menus != null) {
            return ResultUtil.success(menus, "success");
        }

        return ResultUtil.error(null, "fail");
    }

    @GetMapping(value = "/listOrg")
    @ResponseBody
    public ResponseEntity listOrg(@RequestParam(name = "key", required = false) String key,
                                  @RequestParam(name = "page") int page,
                                  @RequestParam(name = "size") int size
                                  ) {
        Page<HotelSOrg> orgList = hotelSService.listOrg(key, page, size);
        Map<String, Object> map = new HashMap<>();
        map.put("list", orgList);
        map.put("pages", orgList.getPages());
        map.put("count", orgList.getTotal());

        return ResultUtil.success(map, "success");
    }

//    @PostMapping(value = "/addOrg")
//    @ResponseBody
//    public ResponseEntity addOrg(@RequestBody HotelSOrg hotelSOrg) {
//        ResponseEntity restfulRet = new ResponseEntity();
//
//        try {
//            if (hotelSService.addOrg(hotelSOrg) >= 1) {
//                JSONObject jsonObject = new JSONObject();
//                jsonObject.put("id", hotelSOrg.getId());
//                restfulRet.setMsg("success").setCode(ResCode.SUCCESS.value()).setData(jsonObject);
//            }
//        } catch (Exception ex) {
//            restfulRet.setMsg(ex.toString());
//        }
//        return restfulRet;
//    }
//
//    @PostMapping(value = "/updateOrg")
//    @ResponseBody
//    public ResponseEntity updateOrg(@RequestBody HotelSOrg hotelSOrg) {
//        ResponseEntity restfulRet = new ResponseEntity();
//
//        try {
//            if (hotelSService.updateOrg(hotelSOrg) >= 1) {
//                restfulRet.setMsg("success").setCode(ResCode.SUCCESS.value());
//            }
//        } catch (Exception ex) {
//            restfulRet.setMsg(ex.toString());
//        }
//        return restfulRet;
//    }
//
//    @PostMapping(value = "/removeOrg")
//    @ResponseBody
//    public ResponseEntity removeOrg(@RequestBody Map<String, String> dataMap) {
//        ResponseEntity restfulRet = new ResponseEntity();
//
//        try {
//            int id = Integer.parseInt(dataMap.get("id"));
//            if (hotelSService.removeOrg(id) >= 1) {
//                restfulRet.setMsg("success").setCode(ResCode.SUCCESS.value());
//            }
//        } catch (Exception ex) {
//            restfulRet.setMsg(ex.toString());
//        }
//        return restfulRet;
//    }
//
//    @PostMapping(value = "/addOrgRole")
//    @ResponseBody
//    public ResponseEntity addOrgRole(@RequestBody HotelSOrgRole hotelSOrgRole) {
//        ResponseEntity restfulRet = new ResponseEntity();
//
//        try {
//            if (hotelSService.addRole(hotelSOrgRole) >= 1) {
//                restfulRet.setMsg("success").setCode(ResCode.SUCCESS.value());
//            }
//
//        } catch (Exception ex) {
//            restfulRet.setMsg(ex.toString());
//        }
//        return restfulRet;
//    }
//
//    @PostMapping(value = "/removeOrgRole")
//    @ResponseBody
//    public ResponseEntity removeOrgRole(@RequestBody HotelSOrgRole hotelSOrgRole) {
//        ResponseEntity restfulRet = new ResponseEntity();
//
//        try {
//            if (hotelSService.removeRole(hotelSOrgRole) >= 1) {
//                restfulRet.setMsg("success").setCode(ResCode.SUCCESS.value());
//            }
//
//        } catch (Exception ex) {
//            restfulRet.setMsg(ex.toString());
//        }
//        return restfulRet;
//    }
//
//    @PostMapping(value = "/getRoleByOrg")
//    @ResponseBody
//    public ResponseEntity getRoleByOrg(@RequestBody Map<String, String> dataMap) {
//        ResponseEntity restfulRet = new ResponseEntity();
//
//        try {
//            int orgId = Integer.parseInt(dataMap.get("id"));
//            List<HotelSRole> roleList = hotelSService.getRoleByOrg(orgId);
//            restfulRet.setMsg("success").setCode(ResCode.SUCCESS.value()).setData(JSONArray.from(roleList));
//
//        } catch (Exception ex) {
//            restfulRet.setMsg(ex.toString());
//        }
//        return restfulRet;
//    }
//
//    @PostMapping(value = "/addMenuToRole")
//    @ResponseBody
//    public ResponseEntity addMenuToRole(@RequestBody HotelSRoleMenu hotelSRoleMenu) {
//        ResponseEntity restfulRet = new ResponseEntity();
//
//        try {
//            if (hotelSService.addMenuToRole(hotelSRoleMenu) >= 1) {
//                restfulRet.setMsg("success").setCode(ResCode.SUCCESS.value());
//            }
//
//        } catch (Exception ex) {
//            restfulRet.setMsg(ex.toString());
//        }
//        return restfulRet;
//    }
//
//    @PostMapping(value = "/removeMenuFromRole")
//    @ResponseBody
//    public ResponseEntity removeMenuFromRole(@RequestBody HotelSRoleMenu hotelSRoleMenu) {
//        ResponseEntity restfulRet = new ResponseEntity();
//
//        try {
//            if (hotelSService.removeMenuFromRole(hotelSRoleMenu) >= 1) {
//                restfulRet.setMsg("success").setCode(ResCode.SUCCESS.value());
//            }
//
//        } catch (Exception ex) {
//            restfulRet.setMsg(ex.toString());
//        }
//        return restfulRet;
//    }
//
//
//    @PostMapping(value = "/addUser")
//    @ResponseBody
//    public ResponseEntity addUser(@RequestBody HotelSUser hotelSUser) {
//        ResponseEntity restfulRet = new ResponseEntity();
//
//        try {
//            if (hotelSService.addUser(hotelSUser) >= 1) {
//                restfulRet.setMsg("success").setCode(ResCode.SUCCESS.value());
//            }
//
//        } catch (Exception ex) {
//            restfulRet.setMsg(ex.toString());
//        }
//        return restfulRet;
//    }
//
//    @PostMapping(value = "/removeUser")
//    @ResponseBody
//    public ResponseEntity removeUser(@RequestBody Map<String, String> dataMap) {
//        ResponseEntity restfulRet = new ResponseEntity();
//
//        try {
//            int id = Integer.parseInt(dataMap.get("id"));
//            if (hotelSService.removeUser(id) >= 1) {
//                restfulRet.setMsg("success").setCode(ResCode.SUCCESS.value());
//            }
//
//        } catch (Exception ex) {
//            restfulRet.setMsg(ex.toString());
//        }
//        return restfulRet;
//    }
}

