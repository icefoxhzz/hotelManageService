package com.hz.web.controller;


import com.alibaba.fastjson2.JSONArray;
import com.hz.web.ResponseEntiry.CommonDict;
import com.hz.web.ResponseEntiry.RestfulRet;
import com.hz.web.ResponseEntiry.ServiceDict;
import com.hz.web.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 证件字典表 前端控制器
 * </p>
 *
 * @author saber
 * @since 2023-12-07
 */
@Controller
@RequestMapping("/dict")
public class DictController {
    @Autowired
    DictService dictService;

    @GetMapping(value = "/{dictName}")
    @ResponseBody
    public RestfulRet getCommonDict(@PathVariable("dictName") String dictName) {
        RestfulRet restfulRet = new RestfulRet();
        try {
            List<CommonDict> commonDictList = dictService.getCommonDict(dictName);
            JSONArray data = JSONArray.from(commonDictList);
            restfulRet.setMsg("success").setData(data);
        }catch (Exception ex){
            restfulRet.setCode("-1").setMsg(ex.toString());
        }
        return restfulRet;
    }

    @GetMapping(value = "/serviceDict")
    @ResponseBody
    public RestfulRet getServiceDict() {
        RestfulRet restfulRet = new RestfulRet();
        try {
            List<ServiceDict> serviceDictList = dictService.getServiceDict();
            JSONArray data = JSONArray.from(serviceDictList);
            restfulRet.setMsg("success").setData(data);
        }catch (Exception ex){
            restfulRet.setCode("-1").setMsg(ex.toString());
        }
        return restfulRet;
    }
}

