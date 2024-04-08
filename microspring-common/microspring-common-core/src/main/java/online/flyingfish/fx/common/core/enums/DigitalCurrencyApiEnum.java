/**
 * All rights reserved.
 * Created on 2021-09-28
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description
 * @date 2021-09-28
 * @Version V1.0
 * @Notice
 */
@Getter
@AllArgsConstructor
public enum  DigitalCurrencyApiEnum {

    /**
     * 根据客户ID或钱包ID查询对公钱包信息
     */
    QUERY_WALLET_API("/xxx/api/wallet/81015001", "根据客户ID或钱包ID查询对公钱包信息", "81015001", "uwap.500.001.01", "01"),

    /**
     * 油料支付结算
     */
    TRANSFER_ACCOUNT_API("/xxx/api/transact/80147502301", "油料支付结算", "80147502301", "uwap.502.001.01", "01"),

    /**
     * 交易状态查询
     */
    QUERY_TRANSFER_API("/xxx/api/transact/80050411001", "交易状态查询", "80050411001", "dcep.412.001.01", "01"),

    /**
     * 渠道开通
     */
    OPEN_CHANNEL_API("/xxx/api/sign/86001015001", "渠道开通", "86001015001", "uwap.502.001.01", "01"),

    /**
     * 查询签约协议号
     */
     QUERY_SIGN_NO_API("/xxx/api/sign/86001017001", "查询签约协议号", "86001017001", "uwap.502.001.01", "01"),
    ;

    private String url;

    private String description;

    private String transCode;

    private String msgType;

    private String versionId;
}
