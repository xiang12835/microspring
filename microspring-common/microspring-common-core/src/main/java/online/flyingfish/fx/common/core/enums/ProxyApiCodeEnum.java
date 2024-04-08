/**
 * All rights reserved.
 * Created on 2021-09-09
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description
 * @date 2021-09-09
 * @Version V1.0
 * @Notice
 */
@Getter
@AllArgsConstructor
public enum ProxyApiCodeEnum implements BaseEnum {
    /**
     * 数币相关接口
     */

    /**
     * 管理平台相关接口
     */
    M_SETTLEMENT_UPLOAD("100001", "应结算信息上传"),
    M_RETAIL_ORDER_UPLOAD("100002", "加油应付款信息上传"),
    M_WHOLESALE_ORDER_UPLOAD("100003", "领油送油应付款信息上传"),
    M_INDEX_ADJUSTMENT_RETURN("100004","卡指标调整结果上报"),
    M_REDIRECT_RESULT_NOTIFY("100005","结果转发上报"),

    /**
     * 短信平台接口
     */
    TMS_SEND_SHORT_MESSAGE("TMSSendShortMessage", "esb调用短信平台接口"),

    /**
     * 传统接口esb调用校验登陆密码
     */
    TCIP_LOGIN_CHECK("TCIP_612050","传统接口esb调用校验登陆密码"),
    TCIP_LOGOUT("TCIP_612070G","传统接口esb调用登出"),
    TCIP_CHANGE_PWD("TCIP_612010","传统接口esb调用密码修改"),
    TCIP_REGISTER("TCIP_T612010","传统接口esb调用柜员单笔注册"),
    TCIP_RESET_PWD("TCIP_612020","传统接口esb调用密码重置"),
    TCIP_UNLOCK("TCIP_612030","传统接口esb调用密码解锁定"),
    TCIP_FORCE_SIGNOUT("TCIP_612080","传统接口esb调用柜员强制签退"),

    /**
     * 油企后台相关接口
     */
    O_SMSP_VERIFY_MESSAGE("O_SMSP_VERIFY_MESSAGE", "校验短信验证码"),
    O_SMSP_SEND_MESSAGE("O_SMSP_SEND_MESSAGE", "发送短信验证码");

    private String code;
    private String message;
}
