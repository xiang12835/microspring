package online.flyingfish.fx.common.core.util;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 时间工具类
 * @date 2021/09/18
 * @since 1.0.0
 */
@Slf4j
public class DateUtils {

    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String HHMMSS = "HHmmss";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String yyyyMMdd = "yyyy-MM-dd";
    public static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";

    private DateUtils() {
    }

    /**
     * @return 当前时间字符串
     */
    public static String now() {
        return now(YYYYMMDDHHMMSSSSS);
    }

    /**
     * @param pattern 时间格式
     * @return 指定格式的时间字符串
     */
    public static String now(String pattern) {
        LocalDateTime now = LocalDateTime.now();

        return now.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取指定格式的时间戳字符串
     * @param fs
     * @return
     */
    public static String getNowTimeWithFormatter(String fs) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(fs);
        return LocalDateTime.now().format(formatter);
    }

    /**
     * 获取指定格式的时间戳字符串
     * @param fs
     * @return
     */
    public static String getNowDateWithFormatter(String fs) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(fs);
        return LocalDateTime.now().toLocalDate().format(formatter);
    }

    /**
     * 判断日期是否为正确日期格式
     * @param date 日期
     * @return 判断结果
     */
    public static boolean isValidDateFormat(String date, String pattern) {
        try {
            DateTime dateTime = DateUtil.parse(date, pattern);
            return date.equals(dateTime.toString(pattern));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param dateTime 时间
     * @return yyyyMMddHHmmssSSS格式的时间
     */
    public static String format17(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern(YYYYMMDDHHMMSSSSS));
    }

    /**
     * 字符串转date
     * @param str
     * @param pattern
     * @return
     */
    public static Date strToDate(String str, String pattern) {
        LocalDate localDate = LocalDate.parse(str, DateTimeFormatter.ofPattern(pattern));
        return localDateToDate(localDate);
    }

    /**
     * 字符串转datetime
     * @param str
     * @param pattern
     * @date 2021/10/21
     * @Notice 无
     */
    public static Date strToDateTime(String str, String pattern) {
        LocalDateTime localDateTime = LocalDateTime.parse(str, DateTimeFormatter.ofPattern(pattern));
        return localDateTimeToDate(localDateTime);
    }

    /**
     * 字符串转localDate
     * @param date
     * @param pattern
     * @return
     */
    public static LocalDate strToLocalDate(String date, String pattern) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 字符串转localDateTime
     * @param date
     * @param pattern
     * @return
     */
    public static LocalDateTime strToLocalDateTime(String date, String pattern) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * localDate转字符串格式
     * @param localDate
     * @param pattern
     * @return
     */
    public static String localDateToStr(LocalDate localDate, String pattern) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern(pattern);
        return localDate.format(f);
    }

    /**
     * localDate转date
     * @param localDate
     * @return
     */
    public static Date localDateToDate(LocalDate localDate) {
        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * date转LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        //获取毫秒数
        Instant instant = Instant.ofEpochMilli(date.getTime());
        //根据毫秒数与系统默认时区获取localDateTime
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * date转LocalDate
     * @param date
     * @return
     */
    public static LocalDate dateToLocalDate(Date date) {
        //获取毫秒数
        Instant instant = Instant.ofEpochMilli(date.getTime());
        //根据毫秒数与系统默认时区获取localDateTime
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * date转字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToStr(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        DateTimeFormatter f = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(f);
    }

    /**
     * localDateTime转date
     * @param localDateTime
     * @return
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * localDateTime转字符串格式
     * @param localDateTime
     * @param pattern
     * @return
     */
    public static String localDateTimeToStr(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(f);
    }

    /**
     * 日期时间加减
     * @param date
     * @param time
     * @param timeUnit
     * @return
     */
    public static Date dateOffset(Date date, Long time, TimeUnit timeUnit) {
        if (date == null || time == null || timeUnit == null) {
            return null;
        }
        LocalDateTime newTime = dateToLocalDateTime(date);
        switch (timeUnit) {
            case SECONDS:
                newTime = newTime.plusSeconds(time);
                break;
            case MINUTES:
                newTime = newTime.plusMinutes(time);
                break;
            case HOURS:
                newTime = newTime.plusHours(time);
                break;
            case DAYS:
                newTime = newTime.plusDays(time);
                break;
            default:
                return null;
        }
        return localDateTimeToDate(newTime);
    }

    /**
     * 获取当前日期的指定格式的时间字符串
     * @param format 日期格式
     * @return
     */
    public static String getCurrDateFolderByDateStyle(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

}
