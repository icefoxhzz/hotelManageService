package com.hz.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Slf4j
public class MyStringUtil {
    public static String lowerFirst(String input){
        if (input == null || input.isEmpty()) {
            return input; // 如果输入为空或空字符串，返回原始值
        }

        char firstChar = Character.toLowerCase(input.charAt(0)); // 获取第一个字符并转换为小写
        return firstChar + input.substring(1); // 将转换后的字符与原始字符串的其余部分拼接
    }

    public static String encodeMd5(String s) {
        String md5 = null;
        try {

            md5 = DigestUtils.md5DigestAsHex(s.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            log.error("加密失败", e);
        }
        return md5;
    }
}
