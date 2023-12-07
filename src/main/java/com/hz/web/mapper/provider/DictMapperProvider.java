package com.hz.web.mapper.provider;

import org.apache.ibatis.annotations.Param;

public class DictMapperProvider {
    public String getCommonDictSql(@Param("tableName") String tableName){
        return "select id,val from " + tableName;
    }

    public String getServiceDictSql(){
        return "select a.id,a.val,a.service_type,b.val as service_val,a.price from dict_service a, dict_service_type b where a.service_type=b.id";
    }
}
