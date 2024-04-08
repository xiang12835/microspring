/**
 * All rights reserved.
 * Created on 2021-09-24
 */
package online.flyingfish.fx.common.core.validate;

import cn.hutool.core.util.NumberUtil;
import online.flyingfish.fx.common.core.annotation.DigitLimit;
import lombok.Data;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @Description 范围校验
 * @date 2021-10-13
 * @Version V1.0
 * @Notice
 */
@Data
public class DigitLimitValidator implements ConstraintValidator<DigitLimit, Object> {

    private int min = -1;
    private int max = -1;
    private int fixed = -1;

    @Override
    public void initialize(DigitLimit digitLimit) {
        this.min = digitLimit.min();
        this.max = digitLimit.max();
        this.fixed = digitLimit.fixed();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        //不做非空校验
        if (Objects.isNull(value)) {
            return true;
        }
        //该注解只使用于字符串类型和数字类型
        if (!(value instanceof Number) && !(value instanceof String)) {
            return false;
        }
        //如果是字符串，判断是否为数字
        BigDecimal number = null;
        if (value instanceof String) {
            if (!NumberUtil.isNumber((String) value)) {
                return false;
            }
            number = BigDecimal.valueOf(Double.parseDouble((String) value));
        } else {
            number = BigDecimal.valueOf(((Number) value).doubleValue());
        }
        //清除小数末尾的0
        String numberStr = number.stripTrailingZeros().toPlainString();
        //获取小数位
        int pointIndex = numberStr.lastIndexOf(".");
        int decimalSize = 0;
        //如果有小数位，则获取小数位数
        if (pointIndex > 0) {
            decimalSize = numberStr.substring(pointIndex + 1).length();
        }
        //判断fixed是否>=0
        if (fixed >= 0) {
            return decimalSize == fixed;
        }
        //如果不是固定值
        return decimalSize >= min && decimalSize <= max;
    }
}
