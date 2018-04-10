/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.common.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @since 2018年3月7日 下午5:25:28
 * @author hjl
 *
 */
public class CalendarUtils {
    // 获取这个礼拜在今天之前有几天
    public static int getDayOfWeekBefore(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day == 0) {
            day = 7;
        }
        return day;
    }

    // 获取今天是礼拜几
    public static String getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return "周" + (calendar.get(Calendar.DAY_OF_WEEK) - 1);
    }

    // 获取这周过啦几天
    public static String[] getDaysOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        String[] weeks = new String[day];
        for (int i = 1; i <= day; i++) {
            weeks[i - 1] = "周" + i;
        }
        return weeks;
    }

    /***
     * 获取一周的起始日期到今天的日期
     * 
     * @return
     */
    public static Date[] getDateBeginEndDate(Date date) {
        Date[] dates = new Date[2];
        dates[1] = date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day == 0) {
            day = 7;
        }
        calendar.set(Calendar.DAY_OF_MONTH, Calendar.DAY_OF_WEEK - day);
        dates[0] = calendar.getTime();
        return dates;
    }

    /**
     * @param date
     * @return
     */
    public static int getDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        return days;
    }

    public static void main(String[] args) {
        System.out.println(getDayOfMonth(new Date()));
    }

}
