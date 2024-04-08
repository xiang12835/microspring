package online.flyingfish.fx.common.core.exception;

import online.flyingfish.fx.common.core.enums.BaseEnum;
import online.flyingfish.fx.common.core.enums.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.text.MessageFormat;

/**
 * 基础异常类
 *
 * @date 2021/5/12
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public abstract class BaseException extends RuntimeException {

    /**
     * 异常编码
     */
    protected String code;

    public BaseException(BaseException e) {
        super(e.getMessage());
        this.code = e.getCode();
    }

    public BaseException(Throwable throwable) {
        super(throwable);
        this.code = ResultCodeEnum.FAILURE.getCode();
    }

    public BaseException(String message) {
        super(message);
        this.code = ResultCodeEnum.FAILURE.getCode();
    }

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(String message, Throwable throwable) {
        super(message, throwable);
        this.code = ResultCodeEnum.FAILURE.getCode();
    }

    /**
     * 构造方法,根据指定的异常对象进行异常信息构造
     *
     * @param baseEnum 指定的自定义异常码对象
     */
    public BaseException(BaseEnum baseEnum) {
        super(baseEnum.getMessage());
        this.code = baseEnum.getCode();
    }

    /**
     * 构造方法,需要进行格式化的错误消息进行动态赋值处理并反馈
     *
     * @param baseEnum 指定的自定义异常码对象
     * @param arguments  字符串占位符对象动态值
     */
    public BaseException(BaseEnum baseEnum, Object... arguments) {
        super(MessageFormat.format(baseEnum.getMessage(), arguments));
        this.code = baseEnum.getCode();
    }
}