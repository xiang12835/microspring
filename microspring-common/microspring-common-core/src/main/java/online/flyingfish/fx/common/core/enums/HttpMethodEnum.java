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
public enum HttpMethodEnum implements BaseEnum {
    POST("POST", "post"),
    GET("GET", "get");

    private String code;
    private String message;

    public static HttpMethodEnum to(String httpMethodCode) {
        if (GET.getCode().equals(httpMethodCode)) {
            return GET;
        }
        return POST;
    }
}
