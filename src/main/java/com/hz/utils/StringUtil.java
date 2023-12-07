package com.hz.utils;

public class StringUtil {
    public static String lowerFirst(String input){
        if (input == null || input.isEmpty()) {
            return input; // 如果输入为空或空字符串，返回原始值
        }

        char firstChar = Character.toLowerCase(input.charAt(0)); // 获取第一个字符并转换为小写
        return firstChar + input.substring(1); // 将转换后的字符与原始字符串的其余部分拼接
    }
}
