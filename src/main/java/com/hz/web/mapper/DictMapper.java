package com.hz.web.mapper;

import com.hz.web.ResponseEntiry.CommonDict;
import com.hz.web.ResponseEntiry.ServiceDict;
import com.hz.web.mapper.provider.DictMapperProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface DictMapper {
    @SelectProvider(type = DictMapperProvider.class, method = "getCommonDictSql")
    List<CommonDict> getCommonDict(@Param("tableName") String tableName);

    @SelectProvider(type = DictMapperProvider.class, method = "getServiceDictSql")
    List<ServiceDict> getServiceDict();
}
