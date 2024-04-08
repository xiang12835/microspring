/**
 * All rights reserved.
 * Created on 2021-09-13
 */
package online.flyingfish.fx.common.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 公共请求头
 * @date 2021-09-13
 * @Version V1.0
 * @Notice
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonRequestHead {
    /**
     * 交易流水号
     */
    private String flowno;
    /**
     * 交易码
     */
    private String transCode;
    /**
     * 交易日期
     */
    private String senderDate;
    /**
     * 交易时间
     */
    private String senderTime;
    /**
     * 发起方系统代码
     */
    private String sysCode;
}
