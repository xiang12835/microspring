/**
 * All rights reserved.
 * Created on 2021-10-21
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 请求参数类型
 * @date 2021-10-21
 * @Version V1.0
 * @Notice
 */
@Getter
@AllArgsConstructor
public enum ReqParamTypeEnum implements BaseEnum{
    FILE("FILE","接口参数为文件类型"),
    JSON("JSON","接口参数为json类型"),
    ;

    private String code;
    private String message;

}
