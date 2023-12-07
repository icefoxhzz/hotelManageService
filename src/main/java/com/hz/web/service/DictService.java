package com.hz.web.service;

import com.hz.web.ResponseEntiry.CommonDict;
import com.hz.web.ResponseEntiry.ServiceDict;
import com.hz.web.mapper.DictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictService {
    @Autowired
    DictMapper dictMapper;

    public List<CommonDict> getCommonDict(String tableName) {
        return dictMapper.getCommonDict(tableName);
    }

    public List<ServiceDict> getServiceDict() {
        return dictMapper.getServiceDict();
    }
}
