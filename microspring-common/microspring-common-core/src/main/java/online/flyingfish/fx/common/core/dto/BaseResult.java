/**
 * All rights reserved.
 * Created on 2021-09-01
 */
package online.flyingfish.fx.common.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 接口返回报文
 * @date 2021-09-01
 * @Version V1.0
 * @Notice
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult {
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 流水号
     */
    private String flowno;
    /**
     * 交易号
     */
    private String tranCode;


    /**
     * 获取失败信息
     * @param baseResult
     * @date 2021/9/14
     * @Notice 无
     */
    public static String getFailMsg(BaseResult baseResult) {
        if (baseResult == null) {
            return "返回结果为空";
        }

        return String.format("%s:%s", baseResult.getCode(), baseResult.getMessage());
    }
}
