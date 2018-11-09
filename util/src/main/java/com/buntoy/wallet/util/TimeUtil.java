package com.buntoy.wallet.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * time util
 */

public class TimeUtil {

    /**
     * 获取当前星期几
     *
     * @param "new Date()"
     * @return 星期几
     */
    public static String getCurrentWeekday(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) w = 0;
        return weekDays[w];
    }

    /**
     * 获取当前时间时间戳
     *
     * @param  "无"
     * @return "1537153919870"
     */
    public static String stamp(){
        return String.valueOf(new Date().getTime());
    }

    /**
     * 将时间戳转换为时间
     *
     * @param "1537153919870"
     * @return "2018-09-17 11:11:59"
     */
    public static String stampToDate(String s){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        String res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 将比较两个日期相差几天时间
     *
     * @param "2018-1-1 12:00:00"
     * @return "1"
     */
    public static int differentDaysByMillisecond(String old,String now){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = format.parse(old);
            Date date2 = format.parse(now);
            int days = (int) ((date2.getTime() - date.getTime()) / (1000*3600*24));
            return days;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
