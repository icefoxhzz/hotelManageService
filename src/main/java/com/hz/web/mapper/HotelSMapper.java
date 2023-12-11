package com.hz.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.hz.web.entity.*;
import com.hz.web.mapper.provider.UserMapperProvider;
import com.swsk.lib.base.entity.RoleInfo;
import com.swsk.lib.base.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HotelSMapper extends BaseMapper<HotelSOrg> {
    @SelectProvider(type = UserMapperProvider.class, method = "getLoginSql")
    int login(@Param("name") String name, @Param("pwd") String pwd);

//    @Select("select * from v_sa_loaduser where loginname='#{loginName}'")
    @SelectProvider(type = UserMapperProvider.class, method = "getUserInfoSql")
    UserInfo getUserInfo(@Param("loginName") String loginName);

    @Select("select * from hotel_s_user where name='#{name}'")
    HotelSUser getUserByName(@Param("name") String name);

    @Select("select * from hotel_s_user where id=#{id}")
    HotelSUser getUserById(@Param("id") Integer id);

    @Select("select * from hotel_s_role where id in (select a.id as roleid from hotel_s_role a, hotel_s_org_role b, hotel_s_org_user c where c.user_id=#{userId} and c.org_id=b.org_id and b.role_id=a.id)")
    List<HotelSRole> getUserRoles(@Param("userId") int userId);

    @UpdateProvider(type = UserMapperProvider.class, method = "getResetPasswdSql")
    int resetPasswd(@Param("pwd") String pwd, @Param("id") int id);

    @Select("select * from hotel_s_user where status=#{status}")
    Page<HotelSUser> listUser(@Param("status") int status);

    @Select("select * from hotel_s_role where status=#{status}")
    Page<HotelSUser> listRole(@Param("status") int status);

    @Select("select a.id as roleid, a.name as rolename from hotel_s_role a, hotel_s_org_role b, hotel_s_org_user c where c.user_id=#{userId} and c.org_id=b.org_id and b.role_id=a.id")
    List<RoleInfo> getUserRoleInfo(@Param("userId") int userId);

    @Select("select DISTINCT(menu_id) from hotel_s_role_menu where role_id in (select a.id as roleid from hotel_s_role a, hotel_s_org_role b, hotel_s_org_user c where c.user_id=#{userId} and c.org_id=b.org_id and b.role_id=a.id)")
    List<Integer> getMenuIdByUser(@Param("userId") int userId);

    @Select("select * from hotel_s_menu where id in (select DISTINCT(menu_id) from hotel_s_role_menu where role_id in (select a.id as roleid from hotel_s_role a, hotel_s_org_role b, hotel_s_org_user c where c.user_id=#{userId} and c.org_id=b.org_id and b.role_id=a.id))")
    List<HotelSMenu> getMenuByUser(@Param("userId") int userId);

    @UpdateProvider(type = UserMapperProvider.class, method = "getAddUserSql")
    int addUser(@Param("user") HotelSUser user);

    @Update("update hotel_s_user set status=0 where id=#{userId}")
    int removeUser(@Param("userId") int userId);

//    @Select("select * from hotel_s_org")
    @SelectProvider(type = UserMapperProvider.class, method = "getListOrgSql")
    Page<HotelSOrg> listOrg(String key);

//    @Select("select * from hotel_s_org where id=#{orgId}")
//    HotelSOrg getOrgById(int orgId);

    @InsertProvider(type = UserMapperProvider.class, method = "getAddOrgSql")
    int addOrg(@Param("org") HotelSOrg org);

    @UpdateProvider(type = UserMapperProvider.class, method = "getUpdateOrgSql")
    int updateOrg(@Param("org") HotelSOrg org);

    @Delete("delete from hotel_s_org where id=#{orgId}")
    int removeOrg(@Param("orgId") int orgId);

    @Insert("insert into hotel_s_org_role(org_id,role_id) values(#{orgId},#{roleId})")
    int addRole(@Param("orgId") int orgId, @Param("roleId") int roleId);

    @Delete("delete from hotel_s_org_role where role_id=#{roleId} and org_id=#{orgId}")
    int removeRole(@Param("orgId") int orgId, @Param("roleId") int roleId);

    @Select("select b.* from hotel_s_org_role a, hotel_s_role b where a.org_id=#{orgId} and  a.role_id=b.id")
    List<HotelSRole> getRoleByOrg(@Param("orgId") int orgId);

    @Insert("insert into hotel_s_role_menu(role_id, menu_id) values(#{roleId}, #{menuId})")
    int addMenuToRole(@Param("roleId") int roleId, @Param("menuId") int menuId);

    @Delete("delete from hotel_s_role_menu where role_id=#{roleId} and menu_id=#{menuId}")
    int removeMenuFromRole(@Param("roleId") int roleId, @Param("menuId") int menuId);

    @Select("select * from hotel_s_menu where status =1")
    List<HotelSMenu> listMenu();

    @Select("select b.* from hotel_s_role_menu a, hotel_s_menu b where role_id=#{roleId} and a.menu_id=b.id")
    List<HotelSMenu> getMenuByRole(@Param("roleId") int roleId);

    @Select("select IFNULL(max(sort),0) as maxSort from hotel_s_user")
    int getMaxSort();

    @Update("update hotel_s_user set sort=#{sort} where id=#{id}")
    int updateUserSort(@Param("id") int id, @Param("sort") int sort);

    @Select("SELECT `status` FROM hotel_s_user WHERE `id` = #{id}")
    String getUserStatus(@Param("id") int id);
}
