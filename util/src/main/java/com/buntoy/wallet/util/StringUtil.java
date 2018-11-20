package com.buntoy.wallet.util;


import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String util
 */
public class StringUtil {


    /**
     * 判断字符串只包含有数字英文字母
     *
     * @param str
     * @return
     */
    public static boolean isLetterOrDigit(String str) {
        String regex = "^[A-Za-z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }


    /**
     * 判断是不是一个合法的电子邮件地址
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        Pattern emailer = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        if (email == null || email.trim().length() == 0)
            return false;
        return emailer.matcher(email).matches();
    }

    /**
     * 校验手机号
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(17[0-9])|(14[0-9]))\\d{8}$";
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 字符串转整数
     *
     * @param str
     * @param defValue
     * @return
     */
    public static int toInt(String str, int defValue) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
        }
        return defValue;
    }

    /**
     * 对象转整数
     *
     * @param obj
     * @return 转换异常返回 0
     */
    public static int toInt(Object obj) {
        if (obj == null)
            return 0;
        return toInt(obj.toString(), 0);
    }

    /**
     * 对象转整数
     *
     * @param obj
     * @return 转换异常返回 0
     */
    public static long toLong(String obj) {
        try {
            return Long.parseLong(obj);
        } catch (Exception e) {
        }
        return 0;
    }

    /**
     * 字符串转布尔值
     *
     * @param b
     * @return 转换异常返回 false
     */
    public static boolean toBool(String b) {
        try {
            return Boolean.parseBoolean(b);
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 截取小数点以前字符串
     *
     * @param -> 2.0
     * @return -> 2
     */
    public static String getStr(String str) {
        int ind = (str).indexOf(".");
        if (ind != -1) {
            str = str.substring(0, ind);
        }
        return str;
    }

    /**
     * 字符串中间部分 * 号显示
     *
     * @param -> 12345
     * @return -> 12**5
     */
    public static String getDisplaystr(String str) {
        String result = new String(str);
        char[] cs = result.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (i >= 3 && i <= str.length() - 5) {// 把3和9区间的字符隐藏
                cs[i] = '*';
            }
        }
        return new String(cs);
    }

    /**
     * 判断字符串是否为URL
     *
     * @param urls 用户头像key
     * @return true:是URL、false:不是URL
     */
    public static boolean isHttpUrl(String urls) {
        boolean isurl = false;
        String regex = "(((https|http)?://)?([a-z0-9]+[.])|(www.))"
                + "\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)";//设置正则表达式
        Pattern pat = Pattern.compile(regex.trim());//比对
        Matcher mat = pat.matcher(urls.trim());
        isurl = mat.matches();//判断是否匹配
        if (isurl) {
            isurl = true;
        }
        return isurl;
    }

    /**
     * 判断字符串是否数字
     *
     * @param
     * @return true:是 false:不是
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 判断字符串是否网站
     *
     * @param
     * @return true:是URL、false:不是URL
     */
    public static boolean isWebUrl(String url) {
        return Patterns.WEB_URL.matcher(url.trim()).matches();
    }

    /**
     * 去掉小数后面多余的.与0
     *
     * @param "0.00100"
     * @return "0.001"
     */
    public static String subZeroAndDot(String s) {
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

    /**
     * 格式字符串  0xer....eise
     *
     * @param str
     * @return
     */
    public static String subAddressFour(String str) {
        StringBuilder builder = new StringBuilder();
        builder.append(str.substring(0, 4)).append("....").append(str.substring(str.length() - 4));
        return builder.toString();
    }

    /**
     * 格式字符串  0xer222222....eise222222
     *
     * @param str
     * @return
     */
    public static String subAddressTen(String str) {
        StringBuilder builder = new StringBuilder();
        builder.append(str.substring(0, 10)).append("....").append(str.substring(str.length() - 10));
        return builder.toString();
    }


    /**
     * 电话号码验证
     *
     * @param str
     * @return 验证通过返回true
     */
    public static boolean isPhone(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Matcher m = null;
        Pattern p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$"); // 验证带区号的
        Pattern p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // 验证没有区号的
        if (str.length() > 9) {
            m = p1.matcher(str);
            return m.matches();
        } else {
            m = p2.matcher(str);
            return m.matches();
        }
    }


}
