package online.flyingfish.fx.common.core.util;

import cn.hutool.core.util.StrUtil;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 正则校验工具类
 * @date 2021/9/8
 * @Notice 无
 */
public class RegexUtil {
    /**
     * 手机号
     */
    public static final String PHONE = "(^$|^[1]([3-9])[0-9]{9}$)";
    /**
     * Email
     */
    public static final String EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    /**
     * 15位身份证号
     */
    public static final String ID_CARD_15 = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$";
    /**
     * 18位身份证号
     */
    public static final String ID_CARD_18 = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$";
    /**
     * 中文字符
     */
    public static final String CHINESE = "^[\u4E00-\u9FA5]+$";
    /**
     * IP地址
     */
    public static final String IP_ADDR = "[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))";
    /**
     * 中国邮政编码
     */
    public static final String POST_CODE = "[1-9]\\d{5}";
    /**
     * url地址
     */
    public static final String URL = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
    /**
     * 密码复杂度  数字 大写字母 小写字母 至少任意两种组成 长度不少8位 不高于16
     */
    public static final String LOGIN_PASSWORD = "^[a-zA-Z0-9~!@#%_&]{8,16}$";
    /**
     * edb文件日期
     */
    public static final String EDB_FILE_DATE = "_\\d{4}_\\d{8}_";
    /**
     * edb文件名称
     */
    public static final String EDB_DATA_NAME = "\\d{11}.*_\\d{4}_\\d{8}_";

    /**
     * 手机号校验
     * @param phoneNo
     * @return
     * @date 2020年01月13日
     * @注意事项 无
     */
    public static boolean checkPhoneNo(String phoneNo) {
        Matcher m = Pattern.compile(PHONE).matcher(phoneNo);
        if (m.matches()) {
            return true;
        }
        return false;
    }


    /**
     * 隐藏手机号中间四位
     * @param phoneNo
     * @return
     * @date Feb 29, 2020
     * @注意事项 无
     */
    public static String hidePhoneNo(String phoneNo) {
        if (StrUtil.isBlank(phoneNo)) {
            return phoneNo;
        }
        return phoneNo.replaceAll("(\\d{3})(.*)(\\d{4})", "$1****$3");
    }

    /**
     * 隐藏姓名
     * @param cusName
     * @return
     * @date Feb 29, 2020
     * @注意事项 无
     */
    public static String hideCusName(String cusName) {
        if (StrUtil.isBlank(cusName)) {
            return cusName;
        }
        if (cusName.length() <= 2) {
            return cusName.replaceAll("(.{1})(.*)(.{0})", "*$2");
        }
        if (cusName.length() == 3) {
            return cusName.replaceAll("(.{1})(.*)(.{1})", "$1*$3");
        }
        return cusName.replaceAll("(.{1})(.*)(.{1})", "$1*$3");
    }

    /**
     * 通用正则校验
     * @param chars
     * @param regexStr
     * @return
     * @date 2020年01月16日
     * @注意事项 无
     */
    public static boolean checkCommon(String chars, String regexStr) {
        Matcher m = Pattern.compile(regexStr).matcher(chars);
        if (m.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 切割edb文件日期
     * @param fileName
     * @return
     * @date 2020年04月30日
     * @注意事项 无
     */
    public static String edbDate(String fileName) {
        Matcher m = Pattern.compile(EDB_FILE_DATE).matcher(fileName);
        if (m.find()) {
            String reg = m.group(0).replace("_", "");
            return reg.substring(4);
        }
        return DateUtils.dateToStr(new Date(), DateUtils.YYYYMMDD);
    }


    /**
     * 切割edb dataName
     * @param fileName
     * @return
     * @date 2020年04月30日
     * @注意事项 无
     */
    public static String edbDataName(String fileName) {
        Matcher m = Pattern.compile(EDB_DATA_NAME).matcher(fileName);
        if (m.find()) {
            return m.group(0).substring(12).replaceAll("_\\d{4}_\\d{8}_", "");
        }
        return null;
    }
}
