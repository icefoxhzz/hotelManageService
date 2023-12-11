package com.hz.web.mapper.provider;

import com.hz.utils.MyStringUtil;
import com.hz.web.entity.HotelSOrg;
import com.hz.web.entity.HotelSUser;
import com.swsk.lib.base.utils.Common;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;

@Slf4j
public class UserMapperProvider {
    public String getResetPasswdSql(@Param("pwd") String pwd, @Param("id") int id){
        pwd = MyStringUtil.encodeMd5(pwd);
        return  "update hotel_s_user set pwd = '" + pwd + "' where id = " + id;
    }

    public String getLoginSql(@Param("name") String name, @Param("pwd") String pwd){
        pwd = MyStringUtil.encodeMd5(pwd);
        return "select count(1) from hotel_s_user where name = '" + name + "' and pwd = '" + pwd + "'";
    }

    public String getAddUserSql(@Param("user") HotelSUser user){
        user.setPwd(MyStringUtil.encodeMd5(user.getPwd()));

        String sql = "insert into hotel_s_user(name, pwd, phone, sex, email, avatar, sort, email_hash) values('%s', '%s', '%s', %d, '%s', '%s', %d, %d)";
        sql = String.format(sql,
                user.getName(),
                user.getPwd(),
                user.getPhone(),
                user.getSex(),
                user.getEmail(),
                user.getAvatar(),
                user.getSort(),
                user.getEmail().hashCode()
                );
        return sql;
    }

    public String getAddOrgSql(@Param("org") HotelSOrg org){
        String sql = "insert into hotel_s_org(name) values('%s')";
        sql = String.format(sql,
                org.getName()
        );
        return sql;
    }

    public String getUpdateOrgSql(@Param("org") HotelSOrg org){
        String sql = "update hotel_s_org set name='%s' where id=%d";
        sql = String.format(sql,
                org.getName(),
                org.getId()
        );
        return sql;
    }


    public String getUserInfoSql(@Param("loginName") String loginName){
        String sql = "select * from v_sa_loaduser where loginname='%s'";
        sql = String.format(sql, loginName);
        return sql;
    }

    public String getListOrgSql(@Param("key") String key){
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(" select * from hotel_s_org where 1=1 ");
        if (!Common.isNullOrEmpty(key)){
            sBuilder.append(String.format(" and name like %%s% ", key));
        }

//        sBuilder.append(" order by create_time asc");
        return sBuilder.toString();
    }


}
