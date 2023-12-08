package com.hz.web.mapper;

import com.github.pagehelper.Page;
import com.hz.web.entity.HotelSMenu;
import com.hz.web.entity.HotelSRole;
import com.hz.web.entity.HotelSUser;
import com.hz.web.mapper.provider.UserMapperProvider;
import com.swsk.lib.base.entity.RoleInfo;
import com.swsk.lib.base.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HotelSMapper {
    @SelectProvider(type = UserMapperProvider.class, method = "getLoginSql")
    int login(@Param("name") String name, @Param("pwd") String pwd);

//    @Select("select * from v_sa_loaduser where loginname='#{loginName}'")
    @SelectProvider(type = UserMapperProvider.class, method = "getUserInfoSql")
    UserInfo getUserInfo(@Param("loginName") String loginName);

    @Select("select * from hotel_s_user where name='#{name}'")
    HotelSUser getUserByName(@Param("name") String name);

    @Select("select * from hotel_s_user where id=#{id}")
    HotelSUser getUserById(@Param("id") Integer id);

    @Select("select b.* from hotel_s_user_role a, hotel_s_role b where a.user_id=#{userId} and a.role_id = b.id")
    List<HotelSRole> getUserRoles(@Param("userId") int userId);

    @UpdateProvider(type = UserMapperProvider.class, method = "getResetPasswdSql")
    int resetPasswd(@Param("pwd") String pwd, @Param("id") int id);

    @Select("select * from hotel_s_user where status=#{status}")
    Page<HotelSUser> listUser(@Param("status") int status);

    @Select("select * from hotel_s_role where status=#{status}")
    Page<HotelSUser> listRole(@Param("status") int status);

    @Select("select id as roleid,name as rolename from hotel_s_role where id in(select role_id from hotel_s_user_role where user_id=#{userId})")
    List<RoleInfo> getUserRoleInfo(@Param("userId") int userId);

    @UpdateProvider(type = UserMapperProvider.class, method = "getAddUserSql")
    int addUser(@Param("user") HotelSUser user);

    @Update("update hotel_s_user set status=0 where id=#{userId}")
    int removeUser(@Param("userId") int userId);

    @Insert("insert into hotel_s_user_role(user_id,role_id) values(#{userId},#{roleId})")
    int addRole(@Param("userId") int userId, @Param("roleId") int roleId);

    @Delete("delete from hotel_s_user_role where id=#{userId}")
    int removeRole(@Param("userId") int userId);

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
