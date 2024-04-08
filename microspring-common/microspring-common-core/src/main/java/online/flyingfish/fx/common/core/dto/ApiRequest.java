/**
 * All rights reserved.
 * Created on 2021-09-01
 */
package online.flyingfish.fx.common.core.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Description 接口请求报文
 * @date 2021-09-01
 * @Version V1.0
 * @Notice
 */
@Data
public class ApiRequest<T> {
    private CommonRequestHead head;
    @NotNull
    @Valid
    private T data;
}
