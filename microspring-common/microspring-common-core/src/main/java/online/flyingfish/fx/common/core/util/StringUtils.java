package online.flyingfish.fx.common.core.util;

import org.apache.commons.lang3.BooleanUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理工具类, 集成自apache的lang3包下的StringUtils
 * @version 1.0
 * @filename StringUtils.java
 * @date 2019-01-23
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    private static final char SEPARATOR = '_';
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[\\t\r\n]");
    private static final Pattern ABBR_PATTERN = Pattern.compile("<([a-zA-Z]+)[^<>]*>");

    /**
     * 判断指定的字符串是否为空
     * @param str 指定字符串
     * @return boolean
     */
    public static boolean isNull(String str) {
        return StringUtils.isBlank(str) || StringUtils.isEmpty(str)
                || "null".equals(str.toLowerCase())
                || "".equals(str.trim())
                || str.trim().length() == 0
                || "undefined".equals(str);
    }

    /**
     * 判断指定的字符串是否为空
     * @param str 指定字符串
     * @return boolean
     */
    public static String ifNull(String str) {
        if (isNull(str)) {
            return "";
        }
        return trim(str);
    }

    /**
     * 判断指定的字符串是否为空或者为字符串0
     * @param str 指定字符串
     * @return boolean
     */
    public static boolean isZero(String str) {
        return isNull(str) || "0".equals(str.trim());
    }

    /**
     * 将String类型数据去除首尾两端的空格之后, 转换成字符串
     * @param str        需要进行去除首尾两端的空格的字符串
     * @param defaultVal 默认值
     * @return String
     */
    public static String trim(String str, String defaultVal) {
        if (isNull(str)) {
            return defaultVal;
        }
        return trim(str);
    }

    /**
     * 字符串格式的统一左补零
     * @param str    需要格式化的数据
     * @param length 目标长度
     * @return 统一补零后的字符
     */
    public static String leftPadStr(String str, int length) {
        return padStr(str, length, "L");
    }

    /**
     * 字符串格式的统一右补零
     * @param str    需要格式化的数据
     * @param length 目标长度
     * @return 统一补零后的字符
     */
    public static String rightPadStr(String str, int length) {
        return padStr(str, length, "R");
    }

    /**
     * 字符串格式的统一补零
     * @param str       需要格式化的数据
     * @param length    目标长度
     * @param direction 方向,确定左补还是右补(L,R),默认为左
     * @return 统一补零后的字符
     */
    public static String padStr(String str, int length, String direction) {
        String defDirVal = "L";
        StringBuilder result = new StringBuilder();
        if (isNull(str)) {
            for (int i = 0; i < length; i++) {
                result.append("0");
            }
            return result.toString();
        }
        int numLength = str.length();
        if (numLength > length) {
            result = new StringBuilder(str.substring(0, length));
            return result.toString();
        }
        if (numLength < length) {
            int count = Math.abs(length - numLength);
            for (int i = 0; i < count; i++) {
                result.append("0");
            }
            direction = isNull(direction) ? defDirVal : direction;
            if (defDirVal.equals(direction)) {
                result.append(str);
            } else {
                result.insert(0, str);
            }
        }
        return result.toString();
    }

    /**
     * 将字符串中的括号及括号里面的内容去掉,括号包括() [] {} （） 这四种类型的括号
     * @param str 需要剔除括号及括号里面的内容的字符串
     * @return String
     */
    public static String replaceBracket(String str) {
        str = str.replaceAll("\\(.*?\\)|\\{.*?}|\\[.*?]|（.*?）", "");
        return trim(str);
    }

    /**
     * 将字符串中的括号里面的内容去掉,括号包括() [] {} （） 这四种类型的括号替换成目标字符串
     * @param str    需要剔除括号里面的内容的字符串
     * @param target 目标字符串
     * @param reg    正则表达式,用于替换括号里需要替换的匹配表达式
     * @return String
     */
    public static String replaceBracket(String str, String target, String reg) {
        if (isNull(reg)) {
            reg = "\\d+";
        }

        str = str.replaceAll(reg, target);
        return trim(str);
    }

    /**
     * 首字母转小写
     * @param str 字母字符串
     * @return String
     */
    public static String toLowerCaseFirstChar(String str) {
        char[] charArray = str.toCharArray();
        charArray[0] += 32;
        return String.valueOf(charArray);
    }

    /**
     * 首字母转大写
     * @param str 字母字符串
     * @return String
     */
    public static String toUpperCaseFristChar(String str) {
        char[] charArray = str.toCharArray();
        charArray[0] -= 32;
        return String.valueOf(charArray);
    }

    /**
     * 转换为Integer类型
     * @param val 需要转换成Integer类型的数字字符串
     * @return Integer
     */
    public static Integer toInteger(Object val) {
        return toLong(val).intValue();
    }

    /**
     * 转换为Long类型
     * @param val 需要转换成Long类型的数字字符串
     * @return Long
     */
    public static Long toLong(Object val) {
        return toDouble(val).longValue();
    }

    /**
     * 转换为Float类型
     * @param val 需要转换成Float类型的数字字符串
     * @return Float
     */
    public static Float toFloat(Object val) {
        return toDouble(val).floatValue();
    }

    /**
     * 转换为Double类型
     * @param val 需要转换成Double类型的数字字符串
     * @return Double
     */
    public static Double toDouble(Object val) {
        if (val == null) {
            return 0D;
        }
        try {
            return Double.valueOf(trim(val.toString()));
        } catch (Exception e) {
            return 0D;
        }
    }

    /**
     * 转换为Boolean类型(true, on, y, t, yes or 1 (case insensitive) will return true. Otherwise, false is returned)
     * @param val 需要转换成boolea类型的数据对象
     * @return Boolean
     */
    public static Boolean toBoolean(final Object val) {
        if (val == null) {
            return false;
        }
        return BooleanUtils.toBoolean(val.toString()) || "1".equals(val.toString());
    }

    /**
     * 转换为Boolean类型(true, on, y, t, yes or 1 (case insensitive) will return true. Otherwise, false is returned)
     * @param val        需要转换成boolea类型的数据对象
     * @param defaultVal 默认值
     * @return Boolean
     */
    public static Boolean toBoolean(final Object val, boolean defaultVal) {
        if (val == null) {
            return defaultVal;
        }
        return BooleanUtils.toBoolean(val.toString()) || "1".equals(val.toString());
    }

    /**
     * 按照指定的分隔符将字符串分割后存入字符串List
     * @param str   需要分割的字符串
     * @param split 分隔符
     * @return List
     */
    public static List<String> toList(String str, String split) {
        if (isEmpty(str)) {
            return null;
        }
        // 按照指定分隔符进行分割成字符串数组
        String[] sArr = str.split(split);
        return Arrays.asList(sArr);
    }

    /**
     * 将字符串转换成Map对象
     * @param str    需要转换的字符串
     * @param pSplit 外层分隔符
     * @param sSplit 内层分隔符
     * @return Map
     */
    public static Map<String, Object> toMap(String str, String pSplit, String sSplit) {
        if (isNull(str)) {
            return null;
        }

        String[] strArr = str.split(pSplit, -1);
        Map<String, Object> dataMap = new HashMap<>(strArr.length);

        for (String sonStr : strArr) {
            String[] sonArr = sonStr.split(sSplit, -1);
            if ("status".equals(sonArr[0])) {
                dataMap.put(sonArr[0], toList(sonArr[1], ","));
            } else {
                dataMap.put(sonArr[0], sonArr[1]);
            }
        }
        return dataMap;
    }

    /**
     * 转换为字节数组
     * @param str 需要进行转换测字符串
     * @return byte[]
     */
    public static byte[] toBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes(StandardCharsets.UTF_8.name());
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
     * @param s 需要得到长度的字符串
     * @return int 得到的字符串长度
     */
    public static int calcStrLen(String s) {
        int len = 0;
        if (isEmpty(s)) {
            return len;
        }

        String chinese = "[\u4e00-\u9fa5]";
        // 获取字段值的长度,如果含中文字符,则每个中文字符长度为2,否则为1
        for (int i = 0; i < s.length(); i++) {
            // 获取一个字符
            String temp = s.substring(i, i + 1);
            // 判断是否为中文字符
            if (temp.matches(chinese)) {
                // 如果为UTF-8编号,则中文字符长度为3,否则为2
                len += 3;
            } else {
                // 其他字符长度为1
                len += 1;
            }
        }
        return len;
    }

    /**
     * 替换字符串中的制表符、换行符为空格
     * @param str 需要替换的字符串
     * @return String
     */
    public static String replaceNull(String str) {
        String dest = "";
        if (str != null) {
            dest = str.replaceAll("null", "").replaceAll("NULL", "");
        }
        return dest;
    }

    /**
     * 替换字符串中的制表符、换行符为空格
     * @param str 需要替换的字符串
     * @return String
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Matcher m = NUMBER_PATTERN.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 替换字符串中的指定字符串为指定字符串
     * @param str     需要替换的字符串
     * @param srcRep  需要替换哪些字符串
     * @param destRep 需要替换成哪些字符串
     * @return String
     */
    public static String replaceSrcTpDest(String str, String srcRep, String destRep) {
        return str.replace(srcRep, destRep);
    }

    /**
     * 替换掉HTML标签方法
     * @param html 需要进行替换的带html标签的字符串
     * @return String
     */
    public static String replaceHtml(String html) {
        if (isBlank(html)) {
            return "";
        }
        String regEx = "<.+?>";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(html);
        return m.replaceAll("");
    }

    /**
     * 替换为手机识别的HTML,去掉样式及属性,保留回车.
     * @param html 需要进行替换的带html标签的字符串
     * @return String
     */
    public static String replaceMobileHtml(String html) {
        if (html == null) {
            return "";
        }
        return html.replaceAll("<([a-z]+?)\\s+?.*?>", "<$1>");
    }

    /**
     * 去掉指定字符串的开头的指定字符
     * @param str  需要进行截取的字符串
     * @param trim 需要去掉的字符串
     * @return String 处理后的字符串
     */
    public static String sideTrimStart(String str, String trim) {
        // null或者空字符串的时候不处理
        if (isNull(str) || isNull(trim)) {
            return str;
        }

        // 结束位置
        int epos;

        // 正规表达式
        String regpattern = "" + trim + "*+";
        Pattern pattern = Pattern.compile(regpattern, Pattern.CASE_INSENSITIVE);

        // 去掉开头的指定字符
        Matcher matcher = pattern.matcher(str);
        if (matcher.lookingAt()) {
            epos = matcher.end();
            str = str.substring(epos);
        }

        // 返回处理后的字符串
        return str;
    }

    /**
     * 去掉指定字符串末尾的指定字符
     * @param str  需要进行截取的字符串
     * @param trim 需要去掉的指定字符
     * @return String
     */
    public static String sideTrimEnd(String str, String trim) {
        // null或者空字符串的时候不处理
        if (isNull(str) || isNull(trim)) {
            return str;
        }

        // 结束位置
        int epos;

        // 正规表达式
        String regpattern = "" + trim + "*+";
        Pattern pattern = Pattern.compile(regpattern, Pattern.CASE_INSENSITIVE);

        // 去掉结尾的指定字符
        StringBuffer buffer = new StringBuffer(str).reverse();
        Matcher matcher = pattern.matcher(buffer);
        if (matcher.lookingAt()) {
            epos = matcher.end();
            str = new StringBuffer(buffer.substring(epos)).reverse().toString();
        }
        // 返回处理后的字符串
        return str;
    }

    /**
     * 去掉指定字符串的开头和结尾的指定字符
     * @param str  需要进行截取的字符串
     * @param trim 需要去掉的字符串
     * @return String 处理后的字符串
     */
    public static String sideTrim(String str, String trim) {
        // null或者空字符串的时候不处理
        if (isNull(str) || isNull(trim)) {
            return str;
        }

        // 结束位置
        int epos;

        // 正规表达式
        String regpattern = "" + trim + "*+";
        Pattern pattern = Pattern.compile(regpattern, Pattern.CASE_INSENSITIVE);

        // 去掉结尾的指定字符
        StringBuffer buffer = new StringBuffer(str).reverse();
        Matcher matcher = pattern.matcher(buffer);
        if (matcher.lookingAt()) {
            epos = matcher.end();
            str = new StringBuffer(buffer.substring(epos)).reverse().toString();
        }

        // 去掉开头的指定字符
        matcher = pattern.matcher(str);
        if (matcher.lookingAt()) {
            epos = matcher.end();
            str = str.substring(epos);
        }

        // 返回处理后的字符串
        return str;
    }

    /**
     * 驼峰命名法工具
     * @return toCamelCase(" hello_world ") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }

        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 驼峰命名法工具
     * @return toCamelCase(" hello_world ") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toCapitalizeCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = toCamelCase(s);
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    /**
     * 驼峰命名法工具
     * @return toCamelCase(" hello_world ") == "helloWorld"
     * toCapitalizeCamelCase("hello_world") == "HelloWorld"
     * toUnderScoreCase("helloWorld") = "hello_world"
     */
    public static String toUnderScoreCase(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean nextUpperCase = true;

            if (i < (s.length() - 1)) {
                nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
            }

            if ((i > 0) && Character.isUpperCase(c)) {
                if (!upperCase || !nextUpperCase) {
                    sb.append(SEPARATOR);
                }
                upperCase = true;
            } else {
                upperCase = false;
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * 转换为JS获取对象值,生成三目运算返回结果
     * @param objectString 对象串
     *                     例如：row.user.id
     *                     返回：!row?'':!row.user?'':!row.user.id?'':row.user.id
     */
    public static String jsGetVal(String objectString) {
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        String[] vals = split(objectString, ".");

        for (String val : vals) {
            sb.append(".").append(val);
            result.append("!").append(sb.substring(1)).append("?'':");
        }
        result.append(sb.substring(1));
        return result.toString();
    }

    /**
     * 重复某个字符串
     * @param str   被重复的字符
     * @param count 重复的数目
     * @return 重复字符字符串
     */
    public static String repeat(CharSequence str, int count) {
        if (null == str) {
            return null;
        }
        if (count <= 0) {
            return EMPTY;
        }
        if (count == 1 || str.length() == 0) {
            return str.toString();
        }

        // 检查
        final int len = str.length();
        final long longSize = (long) len * (long) count;
        final int size = (int) longSize;
        if (size != longSize) {
            throw new ArrayIndexOutOfBoundsException("需要的String太长: " + longSize);
        }

        final char[] array = new char[size];
        str.toString().getChars(0, len, array, 0);
        int n;
        // n <<= 1相当于n *2
        for (n = len; n < size - n; n <<= 1) {
            System.arraycopy(array, 0, array, n, n);
        }
        System.arraycopy(array, 0, array, n, size - n);
        return new String(array);
    }

    /**
     * 创建StringBuilder对象
     * @param sb   初始StringBuilder
     * @param strs 初始字符串列表
     * @return StringBuilder对象
     */
    public static StringBuilder appendBuilder(StringBuilder sb, CharSequence... strs) {
        for (CharSequence str : strs) {
            sb.append(str);
        }
        return sb;
    }

    /**
     * 根据指定的数字长度,生成对应长度的随机数字符串
     * @param length 字符串长度
     * @return
     */
    public static String getRandomByLen(int length) {
        String s = "";
        SecureRandom rnd = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int p = rnd.nextInt(9);
            s += p;
        }
        return s;
    }
}