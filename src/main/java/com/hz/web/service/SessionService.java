package com.hz.web.service;

import com.alibaba.fastjson.JSONObject;
import com.swsk.lib.base.common.Const;
import com.swsk.lib.base.entity.SessionInfo;
import com.swsk.lib.base.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
public class SessionService {
    @Autowired
    private RedisTemplate redisTemplate;

    public HttpServletRequest request;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public SessionInfo getSession() {
        String token = request.getParameter("gtoken");
        if (Common.isNullOrEmpty(token)) {
            token = request.getHeader("gtoken");
        }
        if (Common.isNullOrEmpty(token)) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("gtoken")) {
                        token = cookie.getValue();
                    }
                }
            }
        }
        if (!Common.isNullOrEmpty(token)) {
            Object obj = redisTemplate.opsForHash().get(Const.REDIS_SESSION_KEY, token);
            if (obj instanceof SessionInfo) {
                return (SessionInfo) obj;
            } else if (obj instanceof JSONObject) {
                return JSONObject.parseObject(((JSONObject) obj).toJSONString(), SessionInfo.class);
            }
        }
        return null;
    }

    public SessionInfo checkSession() throws Exception {
        SessionInfo session = getSession();
        if (session == null) throw new Exception("无效会话，请重新登录");
        return session;
    }

    public int getUserId() {
        SessionInfo session = getSession();
        // 默认为访客
        int userid = 0;
        if (session != null) {
            if (session.isAdmin()) {
                //超级管理员
                userid = -1;
            } else {
                //正常用户
                userid = session.getUserid();
            }
        }

        return userid;
    }
}
