/**
 * All rights reserved.
 * Created on 2021-09-09
 */
package online.flyingfish.fx.common.core.dto;

import online.flyingfish.fx.common.core.enums.ResultCodeEnum;
import online.flyingfish.fx.common.core.exception.ProxyException;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 代理返回
 * @date 2021-09-09
 * @Version V1.0
 * @Notice
 */
@Data
@NoArgsConstructor
public class ProxyResponse<T> {
    private ResultCodeEnum resultCode;
    private String detailErrMsg;
    private String response;

    private T data;

    /**
     * 默认失败处理
     *
     * @param e
     * @date 2021/9/14
     * @Notice 无
     */
    public static ProxyResponse fail(Exception e) {
        ProxyResponse proxyResponse = new ProxyResponse();
        if (e instanceof ProxyException) {
            proxyResponse.setResultCode(ResultCodeEnum.obtainValueByCode(((ProxyException) e).getCode()));
        } else {
            proxyResponse.setResultCode(ResultCodeEnum.FAILURE);
        }
        proxyResponse.setDetailErrMsg(e.getMessage());
        return proxyResponse;
    }

    /**
     * 默认失败处理
     *
     * @date 2021/9/14
     * @Notice 无
     */
    public static ProxyResponse fail() {
        ProxyResponse proxyResponse = new ProxyResponse();
        proxyResponse.setResultCode(ResultCodeEnum.FAILURE);
        return proxyResponse;
    }

    /**
     * 返回成功结果
     *
     * @Notice 无
     */
    public static <T> ProxyResponse<T> success() {
        ProxyResponse proxyResponse = new ProxyResponse();
        proxyResponse.setResultCode(ResultCodeEnum.SUCCESS);
        return proxyResponse;
    }

    /**
     * 获取失败信息
     *
     * @param response
     * @date 2021/9/14
     * @Notice 无
     */
    public static String getFailMsg(ProxyResponse response) {
        if (response == null) {
            return "代理服务调用失败";
        }

        ResultCodeEnum resultCodeEnum = response.getResultCode();
        return String.format("%s,%s:%s", resultCodeEnum.getCode(), resultCodeEnum.getMessage(),
                response.getDetailErrMsg());
    }
}
