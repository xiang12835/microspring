/**
 * All rights reserved.
 * Created on 2021-09-24
 */
package online.flyingfish.fx.common.core.annotation;

import online.flyingfish.fx.common.core.enums.BaseEnum;
import online.flyingfish.fx.common.core.validate.StringRangeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 参数范围校验
 * @date 2021-09-24
 * @Version V1.0
 * @Notice
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringRangeValidator.class)
public @interface StringRange {
    String message() default "参数不在指定请求范围";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 枚举范围
     * @date 2021/9/24
     * @Notice 无
     */
    Class<? extends BaseEnum> enumClass() default BaseEnum.class;

}
