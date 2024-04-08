/**
 * All rights reserved.
 * Created on 2021-09-01
 */
package online.flyingfish.fx.common.core.dto;

import com.google.common.collect.Lists;
import online.flyingfish.fx.common.core.enums.BaseEnum;
import online.flyingfish.fx.common.core.enums.ResultCodeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.MessageFormat;

/**
 * @Description 结果返回
 * @date 2021-09-01
 * @Version V1.0
 * @Notice
 */
@Data
@NoArgsConstructor
public class SingleResult<T> extends BaseResult {
    /**
     * /**
     * 构造函数
     * @param data
     * @date 2021/9/1
     */
    public SingleResult(T data) {
        this.object = data;
    }

    /**
     * /**
     * 构造函数
     * @param baseEnum
     * @date 2021/9/1
     */
    public SingleResult(BaseEnum baseEnum, String msg) {
        super(baseEnum.getCode(), msg, null, null);
    }

    /**
     * /**
     * 构造函数
     * @param baseEnum
     * @date 2021/9/1
     */
    public SingleResult(BaseEnum baseEnum) {
        super(baseEnum.getCode(), baseEnum.getMessage(), null, null);
    }

    /**
     * /**
     * 构造函数
     * @param data
     * @param baseEnum
     * @date 2021/9/1
     */
    public SingleResult(T data, BaseEnum baseEnum) {
        super(baseEnum.getCode(), baseEnum.getMessage(), null, null);
        this.object = data;
    }

    public SingleResult(T data, PageInfo pageInfo, BaseEnum baseEnum) {
        super(baseEnum.getCode(), baseEnum.getMessage(), null, null);
        this.object = data;
        this.pageInfo = pageInfo;
    }

    /**
     * 构造函数
     * @param data
     * @param baseEnum
     * @param flowno
     * @param transCode
     * @date 2021/9/1
     */
    public SingleResult(T data, BaseEnum baseEnum, String flowno, String transCode) {
        super(baseEnum.getCode(), baseEnum.getMessage(), flowno, transCode);
        this.object = data;
    }

    /**
     * 构造函数
     * @param data
     * @param code
     * @param message
     * @param flowno
     * @param transCode
     * @Notice 无
     */
    public SingleResult(T data, String code, String message, String flowno, String transCode) {
        super(code, message, flowno, transCode);
        this.object = data;
    }

    /**
     * 返回成功结果
     * @Notice 无
     */
    public static <T> SingleResult<T> success() {
        return new SingleResult(null, ResultCodeEnum.SUCCESS);
    }

    /**
     * 返回成功结果
     * @param data
     * @Notice 无
     */
    public static <T> SingleResult<T> success(T data) {
        return new SingleResult(data, ResultCodeEnum.SUCCESS);
    }

    /**
     * 返回成功结果
     * @param data
     * @Notice 无
     */
    public static <T> SingleResult<T> success(T data, String message) {
        return new SingleResult(data, ResultCodeEnum.SUCCESS.getCode(), message, null, null);
    }


    /**
     * 返回成功结果
     * @param data
     * @param flowno
     * @param transCode
     * @Notice 无
     */
    public static <T> SingleResult<T> success(T data, String flowno, String transCode) {
        return new SingleResult(data, ResultCodeEnum.SUCCESS, flowno, transCode);
    }

    /**
     * 返回失败信息
     * @param baseEnum
     * @Notice 无
     */
    public static SingleResult fail(String baseEnum, String message) {
        return new SingleResult(null, baseEnum, message, null, null);
    }

    /**
     * 返回失败信息
     * @param baseEnum
     * @Notice 无
     */
    public static SingleResult fail(BaseEnum baseEnum, String message) {
        message = MessageFormat.format(baseEnum.getMessage(), message);
        return new SingleResult<>(baseEnum, message);
    }

    /**
     * 返回失败信息
     * @param baseEnum
     * @Notice 无
     */
    public static <T> SingleResult<T> fail(T data, String baseEnum, String message) {
        return new SingleResult(data, baseEnum, message, null, null);
    }

    /**
     * 返回失败信息
     * @param baseEnum
     * @Notice 无
     */
    public static <T> SingleResult<T> fail(T data, BaseEnum baseEnum) {
        return new SingleResult(data, baseEnum.getCode(), baseEnum.getMessage(), null, null);
    }

    /**
     * 返回SingleResult
     * @param <T> T 泛型标记
     * @return SingleResult
     */
    public static <T> SingleResult<T> fail() {
        return new SingleResult<>(ResultCodeEnum.FAILURE);
    }

    /**
     * 返回SingleResult
     * @param <T> T 泛型标记
     * @return SingleResult
     */
    public static <T> SingleResult<T> fail(String msg) {
        return new SingleResult<>(ResultCodeEnum.FAILURE, msg);
    }

    /**
     * 返回失败信息
     * @param baseEnum
     * @Notice 无
     */
    public static SingleResult fail(BaseEnum baseEnum) {
        return new SingleResult(null, baseEnum.getCode(), baseEnum.getMessage(), null, null);
    }

    /**
     * 返回失败信息
     * @param baseEnum
     * @param msg
     * @param flowno
     * @param transCode
     * @Notice 无
     */
    public static SingleResult fail(BaseEnum baseEnum, String msg, String flowno, String transCode) {
        msg = MessageFormat.format(baseEnum.getMessage(), msg);
        return new SingleResult(null, baseEnum.getCode(), baseEnum.getMessage(), flowno, transCode);
    }

    /**
     * 分页查询时返回对象
     * @param data     数据
     * @param pageInfo 分页信息
     * @return
     */
    public static <T> SingleResult<T> page(T data, PageInfo pageInfo) {
        return new SingleResult(data, pageInfo, ResultCodeEnum.SUCCESS);
    }

    public static <T> SingleResult<T> emptyPage() {
        return new SingleResult((T) Lists.newArrayList(), PageInfo.emptyPageInfo() , ResultCodeEnum.SUCCESS);
    }

    public static <T> SingleResult<T> empty() {
        return new SingleResult(null, null , ResultCodeEnum.SUCCESS);
    }

    /**
     * 返回结果
     */
    private T object;

    @ApiModelProperty(value = "分页信息")
    private PageInfo pageInfo;
}
