/**
 * All rights reserved.
 * Created on 2021-09-09
 */
package online.flyingfish.fx.common.core.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * @Description 代理请求
 * @date 2021-09-09
 * @Version V1.0
 * @Notice
 */
@Data
@NoArgsConstructor
public class ProxyRequest<T> {
    /**
     * 系统码(被调用方)
     */
    @NotBlank
    private String sysCode;
    /**
     * 接口编码
     */
    private String apiCode;
    /**
     * 公共请求头
     */
    private Map<String, String> commonMaps;
    /**
     * 请求体
     */
    @NotNull
    private T data;

    /**
     * 接口码
     */
    private String pCode;

    /**
     * 交易流水
     */
    private String txSriNo;
}
