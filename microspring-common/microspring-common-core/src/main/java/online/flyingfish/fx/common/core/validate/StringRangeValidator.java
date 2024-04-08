/**
 * All rights reserved.
 * Created on 2021-09-24
 */
package online.flyingfish.fx.common.core.validate;

import online.flyingfish.fx.common.core.annotation.StringRange;
import online.flyingfish.fx.common.core.enums.BaseEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description 范围校验
 * @date 2021-09-24
 * @Version V1.0
 * @Notice
 */
public class StringRangeValidator implements ConstraintValidator<StringRange, String> {
    private Set<String> enumCodeSet;

    @Override
    public void initialize(StringRange stringRange) {
        BaseEnum[] baseEnums = stringRange.enumClass().getEnumConstants();
        enumCodeSet = Arrays.asList(baseEnums).stream().map(e -> e.getCode()).collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.length() == 0) {
            return true;
        }
        return enumCodeSet.contains(s);
    }
}
