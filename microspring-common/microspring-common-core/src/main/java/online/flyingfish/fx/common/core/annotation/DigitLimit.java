/**
 * All rights reserved.
 * Created on 2021-09-24
 */
package online.flyingfish.fx.common.core.annotation;

import online.flyingfish.fx.common.core.validate.DigitLimitValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 位数限制校验
 * @date 2021/10/13
 * @Notice 无
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DigitLimitValidator.class)
public @interface DigitLimit {

    String message() default "小数位数不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 最大位数
     */
    int max() default 2;

    /**
     * 最小位数
     */
    int min() default 0;

    /**
     * 指定位数，如果指定位数>0，则以指定位数为准
     */
    int fixed() default -1;

}
