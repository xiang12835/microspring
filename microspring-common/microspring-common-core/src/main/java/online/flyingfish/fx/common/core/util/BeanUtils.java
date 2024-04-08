package online.flyingfish.fx.common.core.util;

import cn.hutool.core.bean.BeanUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Bean工具类
 * @date 2020-03-06
 * @since 1.0.0
 */
@Slf4j
public class BeanUtils {
    /**
     * 判断对象是否为Null
     * @param obj 需要进行判断的对象
     * @return boolean
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * 判断对象不为Null
     * @param obj 需要进行判断的对象
     */
    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }


    /**
     * 将源对象属性复制给目标对象
     * @param source 源对象
     * @param target 目标对象
     * @param <K>    K泛型
     * @param <T>    T泛型
     * @return copy后的目标类型
     */
    public static <K, T> T copy(K source, T target) {
        try {
            BeanUtil.copyProperties(source, target);
        } catch (Exception e) {
            throw new IllegalStateException("Can not copy source");
        }
        return target;
    }

    /**
     * 将原对象属性复制给目标类型
     * @param source      类型
     * @param targetClass 目标类型
     * @param <K>         K泛型
     * @param <T>         T泛型
     * @return copy后的目标类型
     */
    public static <K, T> T copy(K source, Class<T> targetClass) {
        T targetInstance;
        try {
            targetInstance = targetClass.getDeclaredConstructor().newInstance();
            BeanUtil.copyProperties(source, targetInstance);
        } catch (Exception e) {
            throw new IllegalStateException("Can not instance class " + targetClass.getName());
        }
        return targetInstance;
    }

    /**
     * 将原对象属性复制给目标类型
     * @param source
     * @param targetClass
     * @Notice 无
     */
    public static <K, T> T copyProperties(K source, Class<T> targetClass) {
        T targetInstance = null;
        try {
            targetInstance = targetClass.newInstance();
            BeanUtil.copyProperties(source, targetInstance);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

        return targetInstance;
    }
}