package online.flyingfish.fx.common.core.exception;

import online.flyingfish.fx.common.core.enums.BaseEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 接出服务自定义异常
 *
 * @date 2020/9/29
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class ProxyException extends BizException {

    public ProxyException(ProxyException e) {
        super(e);
    }

    public ProxyException(Throwable throwable) {
        super(throwable);
    }

    public ProxyException(String message) {
        super(message);
    }

    public ProxyException(String code, String message) {
        super(code, message);
    }

    public ProxyException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * 构造方法,根据指定的异常对象进行异常信息构造
     *
     * @param baseEnum 指定的自定义异常码对象
     */
    public ProxyException(BaseEnum baseEnum) {
        super(baseEnum);
    }

    /**
     * 构造方法,需要进行格式化的错误消息进行动态赋值处理并反馈
     *
     * @param baseEnum 指定的自定义异常码对象
     * @param arguments  字符串占位符对象动态值
     */
    public ProxyException(BaseEnum baseEnum, Object... arguments) {
        super(baseEnum, arguments);
    }
}
