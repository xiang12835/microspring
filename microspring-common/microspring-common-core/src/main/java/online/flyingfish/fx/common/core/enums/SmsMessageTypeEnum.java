/**
 * All rights reserved.
 * Created on 2021-10-09
 */
package online.flyingfish.fx.common.core.enums;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;

/**
 * @Description TODO
 * @date 2021-10-09
 * @Version V1.0
 * @Notice
 */
@Getter
public enum SmsMessageTypeEnum implements BaseEnum {
    APP_LOGIN("APP_LOGIN"),
    APP_LOGIN_PWD("APP_LOGIN_PWD"),
    APP_PAY_PWD("APP_PAY_PWD"),
    ;
    private String code;

    SmsMessageTypeEnum(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
