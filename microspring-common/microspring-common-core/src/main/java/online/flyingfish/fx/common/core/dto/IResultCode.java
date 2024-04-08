package online.flyingfish.fx.common.core.dto;

import java.io.Serializable;

/**
 * 业务响应码接口
 *
 * @date 2020-03-05
 * @since 1.0.0
 */
public interface IResultCode extends Serializable {

    /**
     * 状态码
     *
     * @return int
     */
    String getCode();

    /**
     * 响应信息描述
     *
     * @return String
     */
    String getMessage();
}