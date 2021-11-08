package com.sample.lwj.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 日期转换工具
 * @date 2021/8/3 13:41
 */
public class DateUtils {
    /**
     * 时间格式(yyyy)
     */
    public final static String YYYY = "yyyy";
    /**
     * 时间格式(yyyyMM)
     */
    public final static String YYYYMM = "yyyyMM";
    /**
     * 时间格式(yyyyMMdd)
     */
    public final static String YYYYMMDD = "yyyyMMdd";
    /**
     * 时间格式(yyyy-MM-dd)
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     *
     * @param date 日期
     * @return 返回yyyy-MM-dd格式日期
     */
    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     *
     * @param date    日期
     * @param pattern 格式，如：DateUtils.DATE_TIME_PATTERN
     * @return 返回yyyy-MM-dd格式日期
     */
    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 字符串转换成日期
     *
     * @param strDate 日期字符串
     * @param pattern 日期的格式，如：DateUtils.DATE_TIME_PATTERN
     */
    public static Date stringToDate(String strDate, String pattern) {
        if (strDate == null || "".equals(strDate.trim())) {
            return null;
        }

        DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
        return fmt.parseLocalDateTime(strDate).toDate();
    }

    /**
     * 根据周数，获取开始日期、结束日期
     *
     * @param week 周期  0本周，-1上周，-2上上周，1下周，2下下周
     * @return 返回date[0]开始日期、date[1]结束日期
     */
    public static Date[] getWeekStartAndEnd(int week) {
        DateTime dateTime = new DateTime();
        LocalDate date = new LocalDate(dateTime.plusWeeks(week));

        date = date.dayOfWeek().withMinimumValue();
        Date beginDate = date.toDate();
        Date endDate = date.plusDays(6).toDate();
        return new Date[]{beginDate, endDate};
    }

    /**
     * 根据年份、周数，获取开始时间
     *
     * @param year 年份
     * @param week 一年周期
     * @return 返回date开始时间（2021-01-01 00:00:00）
     */
    public static Date getWeekStartTime(int year, int week) {
        return DateTime.now().withYear(year).dayOfWeek().withMinimumValue().withWeekOfWeekyear(week).withTimeAtStartOfDay().toDate();
    }

    /**
     * 根据年份、周数，获取结束时间
     *
     * @param year 年份
     * @param week 一年周期
     * @return 返回date结束时间（2021-01-01 23:59:59）
     */
    public static Date getWeekEndTime(int year, int week) {
        //一天最大毫秒86399999 = DateTimeConstants.MILLIS_PER_DAY - 1
        return DateTime.now().withYear(year).dayOfWeek().withMaximumValue().withWeekOfWeekyear(week).millisOfDay().withMaximumValue().toDate();
    }


    /**
     * 根据年份、月份，获取开始时间
     *
     * @param year  年份
     * @param month 月份
     * @return 返回date开始时间（2021-01-01 00:00:00）
     */
    public static Date getMonthStartTime(int year, int month) {
        return DateTime.now().withYear(year).withMonthOfYear(month).dayOfMonth().withMinimumValue().withTimeAtStartOfDay().toDate();
    }

    /**
     * 根据年份、月份，获取结束时间
     *
     * @param year  年份
     * @param month 月份
     * @return 返回date结束时间（2021-01-31 23:59:59）
     */
    public static Date getMonthEndTime(int year, int month) {
        //一天最大毫秒86399999 = DateTimeConstants.MILLIS_PER_DAY - 1
        return DateTime.now().withYear(year).withMonthOfYear(month).dayOfMonth().withMaximumValue().millisOfDay().withMaximumValue().toDate();
    }


    /**
     * 根据年份、季度，获取开始时间
     *
     * @param year    年份
     * @param quarter 季度
     * @return 返回date开始时间（2021-01-01 00:00:00）
     */
    public static Date getQuarterStartTime(int year, int quarter) {
        int month = DateTimeConstants.JANUARY;
        switch (quarter) {
            case 1:
                month = DateTimeConstants.JANUARY;
                break;
            case 2:
                month = DateTimeConstants.APRIL;
                break;
            case 3:
                month = DateTimeConstants.JULY;
                break;
            case 4:
                month = DateTimeConstants.OCTOBER;
                break;
        }
        return DateTime.now().withYear(year).withMonthOfYear(month).dayOfMonth().withMinimumValue().withTimeAtStartOfDay().toDate();
    }

    /**
     * 根据年份、季度，获取结束时间
     *
     * @param year    年份
     * @param quarter 季度
     * @return 返回date结束时间（2021-12-31 23:59:59）
     */
    public static Date getQuarterEndTime(int year, int quarter) {
        int month = DateTimeConstants.MARCH;
        switch (quarter) {
            case 1:
                month = DateTimeConstants.MARCH;
                break;
            case 2:
                month = DateTimeConstants.JUNE;
                break;
            case 3:
                month = DateTimeConstants.SEPTEMBER;
                break;
            case 4:
                month = DateTimeConstants.DECEMBER;
                break;
        }
        //一天最大毫秒86399999 = DateTimeConstants.MILLIS_PER_DAY - 1
        return DateTime.now().withYear(year).withMonthOfYear(month).dayOfMonth().withMaximumValue().millisOfDay().withMaximumValue().toDate();
    }


    /**
     * 根据年份获取开始时间
     *
     * @param year 年份
     * @return 返回date开始时间（2021-01-01 00:00:00）
     */
    public static Date getYearStartTime(int year) {
        return DateTime.now().withYear(year).dayOfYear().withMinimumValue().withTimeAtStartOfDay().toDate();
    }

    /**
     * 根据年份获取结束时间
     *
     * @param year 年份
     * @return 返回date结束时间（2021-12-31 23:59:59）
     */
    public static Date getYearEndTime(int year) {
        //一天最大毫秒86399999 = DateTimeConstants.MILLIS_PER_DAY - 1
        return DateTime.now().withYear(year).dayOfYear().withMaximumValue().millisOfDay().withMaximumValue().toDate();
    }

    /**
     * 对日期的【秒】进行加/减
     *
     * @param date    日期
     * @param seconds 秒数，负数为减
     * @return 加/减几秒后的日期
     */
    public static Date addDateSeconds(Date date, int seconds) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusSeconds(seconds).toDate();
    }

    /**
     * 对日期的【分钟】进行加/减
     *
     * @param date    日期
     * @param minutes 分钟数，负数为减
     * @return 加/减几分钟后的日期
     */
    public static Date addDateMinutes(Date date, int minutes) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMinutes(minutes).toDate();
    }

    /**
     * 对日期的【小时】进行加/减
     *
     * @param date  日期
     * @param hours 小时数，负数为减
     * @return 加/减几小时后的日期
     */
    public static Date addDateHours(Date date, int hours) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusHours(hours).toDate();
    }

    /**
     * 对日期的【天】进行加/减
     *
     * @param date 日期
     * @param days 天数，负数为减
     * @return 加/减几天后的日期
     */
    public static Date addDateDays(Date date, int days) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusDays(days).toDate();
    }

    /**
     * 对日期的【周】进行加/减
     *
     * @param date  日期
     * @param weeks 周数，负数为减
     * @return 加/减几周后的日期
     */
    public static Date addDateWeeks(Date date, int weeks) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusWeeks(weeks).toDate();
    }

    /**
     * 对日期的【月】进行加/减
     *
     * @param date   日期
     * @param months 月数，负数为减
     * @return 加/减几月后的日期
     */
    public static Date addDateMonths(Date date, int months) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMonths(months).toDate();
    }

    /**
     * 对日期的【年】进行加/减
     *
     * @param date  日期
     * @param years 年数，负数为减
     * @return 加/减几年后的日期
     */
    public static Date addDateYears(Date date, int years) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusYears(years).toDate();
    }
}
