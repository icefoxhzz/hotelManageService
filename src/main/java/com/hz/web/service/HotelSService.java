package com.hz.web.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hz.web.entity.*;
import com.hz.web.mapper.HotelSMapper;
import com.swsk.lib.base.common.Const;
import com.swsk.lib.base.entity.SessionInfo;
import com.swsk.lib.base.entity.UserInfo;
import com.swsk.lib.base.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class HotelSService {
    @Autowired
    HotelSMapper hotelSMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${spring.redis.expire}")
    int expire;

    public SessionInfo login(String name, String pwd) throws Exception {
        UserInfo user = hotelSMapper.getUserInfo(name);
        if (null == user || !user.getPwd().equals(pwd)) {
            throw new Exception("用户名或密码错误");
        }

        SessionInfo loginInfo = new SessionInfo(user);

        String token = Common.getUUID();
        loginInfo.setUserid(user.getUserid());
        loginInfo.setUsername(user.getLoginname());
        loginInfo.setDisplayname(user.getUsername());
        loginInfo.setAreacode(user.getAreacode());
        loginInfo.setAdcode(user.getAdcode());
        loginInfo.setUserorg(user.getUserorg());
        loginInfo.setUserorgname(user.getUserorgname());
        loginInfo.setGeokey(token);
        loginInfo.setRoles(hotelSMapper.getUserRoleInfo(user.getUserid()));
        loginInfo.setActivetime(new Date());
        loginInfo.setLogintime(new Date());
        loginInfo.setPhone(user.getPhone());

        redisTemplate.opsForHash().put(Const.REDIS_SESSION_KEY, token, loginInfo);

        //设置过期时间
        redisTemplate.expire(Const.REDIS_SESSION_KEY, expire, TimeUnit.MINUTES);

        return loginInfo;
    }

    public boolean logout(String token) {
        if (redisTemplate.opsForHash().hasKey(Const.REDIS_SESSION_KEY, token)) {
            return redisTemplate.opsForHash().delete(Const.REDIS_SESSION_KEY, token) > 0;
        }
        return true;
    }

    public List<HotelSMenu> getMenuByRole(int roleId) {
        return hotelSMapper.getMenuByRole(roleId);
    }

    public Page<HotelSOrg> listOrg(String key, int page, int size) {
        // todo checkSession
        PageHelper.startPage(page, size);
        return hotelSMapper.listOrg(key);
    }

//    public HotelSOrg getOrgById(int orgId) {
//        return hotelSMapper.getOrgById(orgId);
//    }

    public int addOrg(HotelSOrg org) {
        return hotelSMapper.insert(org);
    }

    public int updateOrg(HotelSOrg org) {
        return hotelSMapper.updateOrg(org);
    }

    public int removeOrg(int orgId) {
        return hotelSMapper.removeOrg(orgId);
    }

    public List<HotelSRole> getRoleByOrg(int orgId) {
        return hotelSMapper.getRoleByOrg(orgId);
    }

    public int addRole(HotelSOrgRole hotelSOrgRole) {
        return hotelSMapper.addRole(hotelSOrgRole.getOrgId(), hotelSOrgRole.getRoleId());
    }

    public int removeRole(HotelSOrgRole hotelSOrgRole) {
        return hotelSMapper.removeRole(hotelSOrgRole.getOrgId(), hotelSOrgRole.getRoleId());
    }

    public int addMenuToRole(HotelSRoleMenu hotelSRoleMenu) {
        return hotelSMapper.addMenuToRole(hotelSRoleMenu.getRoleId(), hotelSRoleMenu.getMenuId());
    }

    public int removeMenuFromRole(HotelSRoleMenu hotelSRoleMenu) {
        return hotelSMapper.removeMenuFromRole(hotelSRoleMenu.getRoleId(), hotelSRoleMenu.getMenuId());
    }

    public int addUser(HotelSUser user) {
        return hotelSMapper.addUser(user);
    }

    public int removeUser(int userId) {
        return hotelSMapper.removeUser(userId);
    }
}
