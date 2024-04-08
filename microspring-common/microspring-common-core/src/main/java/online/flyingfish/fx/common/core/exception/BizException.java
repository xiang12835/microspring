package online.flyingfish.fx.common.core.exception;

import online.flyingfish.fx.common.core.enums.BaseEnum;
import online.flyingfish.fx.common.core.enums.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.text.MessageFormat;

/**
 * 公共业务异常.
 *
 */

@Data
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class BizException extends RuntimeException {

    /**
     * 异常编码
     */
    protected String code;

    public BizException(BizException e) {
        super(e.getMessage());
        this.code = e.getCode();
    }

    public BizException(Throwable throwable) {
        super(throwable);
        this.code = ResultCodeEnum.FAILURE.getCode();
    }

    public BizException(String message) {
        super(message);
        this.code = ResultCodeEnum.FAILURE.getCode();
    }

    public BizException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(String message, Throwable throwable) {
        super(message, throwable);
        this.code = ResultCodeEnum.FAILURE.getCode();
    }

    /**
     * 构造方法,根据指定的异常对象进行异常信息构造
     *
     * @param baseEnum 指定的自定义异常码对象
     */
    public BizException(BaseEnum baseEnum) {
        super(baseEnum.getMessage());
        this.code = baseEnum.getCode();
    }

    /**
     * 构造方法,需要进行格式化的错误消息进行动态赋值处理并反馈
     *
     * @param baseEnum 指定的自定义异常码对象
     * @param arguments  字符串占位符对象动态值
     */
    public BizException(BaseEnum baseEnum, Object... arguments) {
        super(MessageFormat.format(baseEnum.getMessage(), arguments));
        this.code = baseEnum.getCode();
    }

    public BizException(Throwable cause,BaseEnum baseEnum, Object... arguments) {
        super(MessageFormat.format(baseEnum.getMessage(), arguments),cause);
        this.code = baseEnum.getCode();
    }

    public static BizException error(String message) {
        return new BizException(ResultCodeEnum.FAILURE.getCode(), message);
    }
}