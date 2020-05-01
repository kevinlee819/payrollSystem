package com.hust.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 宁鑫
 * @date 2019/6/28
 * @time 22:30
 **/
public class Number {
    private static final Pattern PATTERN_POS = Pattern.compile("[0-9]+");
    private static final Pattern PATTERN = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");

    /**
     * 判断是否为正数
     * @param str
     * @return
     */
    public static boolean isPosNum(String str) {
        Matcher matcher = PATTERN_POS.matcher(str);
        return matcher.matches();
    }

    /**
     * 判断str是否为一个数，包括小数、负数
     * @param str
     * @return
     */
    public static boolean isNum(String str) {
        Matcher matcher = PATTERN.matcher(str);
        return matcher.matches();
    }
}
