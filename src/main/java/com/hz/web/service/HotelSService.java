package com.hz.web.service;

import com.hz.web.entity.HotelSMenu;
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
//        loginInfo.setAreacode(user.getAreacode());
//        loginInfo.setAdcode(user.getAdcode());
        loginInfo.setUserorg(user.getUserorg());
        loginInfo.setUserorgname(user.getUserorgname());
        //loginInfo.setToken(token);
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

    public List<HotelSMenu> getMenuByRole(int roleId){
        return hotelSMapper.getMenuByRole(roleId);
    }
}
