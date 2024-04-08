package online.flyingfish.fx.common.core.util;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * Jasypt加解密工具
 * @date 2021/11/17
 * @Notice 无
 */
public class JasyptUtils {

    /**
     * 加密方法
     * @param salt      盐值
     * @param targetStr 待加密字符串
     * @return
     */
    public static String encrypt(String salt, String targetStr) {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword(salt);
        return encryptor.encrypt(targetStr);
    }

    /**
     * 解密方法
     * @param salt      盐值
     * @param targetStr 待加密字符串
     * @return
     */
    public static String decrypt(String salt, String targetStr) {
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword(salt);
        return encryptor.decrypt(targetStr);
    }
}
