package online.flyingfish.fx.common.core.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * Spring上下文对象容器提供类
 * 此类中,用于手工实例化springBean对象;普通java程序可以从此处获取bean
 *
 * @version 1.0
 * @date 2020-10-25
 */
@Component
@Slf4j
public class SpringContextProvider implements ApplicationContextAware {

    /**
     * Spring的当前上下文对象
     */
    public static ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口, 重写设置Spring上下文对象
     *
     * @param applicationContext Spring上下文对象
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextProvider.applicationContext = applicationContext;
    }

    /**
     * 根据实例名称,返回指定类型的实例
     *
     * @param beanName 实例名称
     * @return 指定类型的实例
     */
    public static <T> T getBean(String beanName) {
        assertApplicationContext();
        return (T) applicationContext.getBean(beanName);
    }

    /**
     * 根据实例类型,返回指定类型的实例
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     *
     * @param beanClass 实例的类型
     * @return 指定类型的实例
     */
    public static <T> T getBean(Class<T> beanClass) {
        assertApplicationContext();
        return applicationContext.getBean(beanClass);
    }

    /**
     * 根据实例类型,返回指定类型的实例
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     *
     * @param beanClass 实例的类型
     * @return 指定类型的实例
     */
    public static <T> T getBean(String beanName, Class<T> beanClass) {
        assertApplicationContext();
        return applicationContext.getBean(beanName, beanClass);
    }

    /**
     * 根据实例名称,返回改实例的类型
     *
     * @param beanName 实例名称
     * @return 指定实例的类型
     */
    public static Class<? extends Object> getType(String beanName) {
        assertApplicationContext();
        return applicationContext.getType(beanName);
    }

    /**
     * 判断当前上下文中是否存在指定名称的实例
     *
     * @param beanName 实例名称
     * @return 指定类型的实例
     */
    public static boolean containsBean(String beanName) {
        assertApplicationContext();
        return applicationContext.containsBean(beanName);
    }

    /**
     * 判断当前上下文中指定名称的实例是否是单例Bean
     *
     * @param beanName 实例名称
     * @return 是否为单例
     */
    public static boolean isSingleton(String beanName) {
        assertApplicationContext();
        return applicationContext.isSingleton(beanName);
    }

    /**
     * 对当前spring的上下文对象进行校验
     */
    private static void assertApplicationContext() {
        if (applicationContext == null) {
            throw new RuntimeException("applicaitonContext属性为null,请检查是否注入了SpringContextHolder!");
        }
    }

    /**
     * 发布事件
     */
    public static void publishEvent(ApplicationEvent event) {
        if (applicationContext == null) {
            return;
        }
        try {
            applicationContext.publishEvent(event);
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
}