package online.flyingfish.fx.common.core.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.text.MessageFormat;

/**
 * 统一HTTP返回类型
 *
 * @date 2020-03-05
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "HTTP响应信息")
public class R<T> extends BaseDTO {

    @ApiModelProperty(value = "业务响应码", required = true)
    private String code;
    @ApiModelProperty(value = "返回消息", required = true)
    private String msg;
    @ApiModelProperty(value = "承载数据")
    private T data;
    @ApiModelProperty(value = "分页信息")
    private PageInfo pageInfo;

    private R(IResultCode resultCode) {
        this(resultCode, null, resultCode.getMessage());
    }

    private R(IResultCode resultCode, String msg) {
        this(resultCode, null, msg);
    }

    private R(IResultCode resultCode, T data) {
        this(resultCode, data, resultCode.getMessage());
    }

    private R(IResultCode resultCode, T data, String msg) {
        this(resultCode.getCode(), data, msg);
    }

    private R(String code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    private R(String code, T data, PageInfo pageInfo, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.pageInfo = pageInfo;
    }

    /**
     * 返回R
     *
     * @param <T> T 泛型标记
     * @return R
     */
    public static <T> R<T> empty() {
        return new R<>(ShSupResultCodeEnum.SUCCESS);
    }

    /**
     * 返回R
     *
     * @param <T> T 泛型标记
     * @return R
     */
    public static <T> R<T> success() {
        return success(ShSupResultCodeEnum.SUCCESS.getCode(), null, ShSupResultCodeEnum.SUCCESS.getMessage());
    }

    /**
     * 返回R
     *
     * @param data 数据
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> R<T> success(T data) {
        return success(data, ShSupResultCodeEnum.SUCCESS.getMessage());
    }

    /**
     * 返回R
     *
     * @param data 数据
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> R<T> success(T data, String msg) {
        return success(ShSupResultCodeEnum.SUCCESS.getCode(), data, msg);
    }

    /**
     * 返回R
     *
     * @param code 业务响应码
     * @param data 数据
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> R<T> success(String code, T data, String msg) {
        return new R<>(code, data, data == null ? ShSupResultCodeEnum.SUCCESS.getMessage() : msg);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务代码
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> R<T> success(IResultCode resultCode) {
        return new R<>(resultCode);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务代码
     * @param msg        消息
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> R<T> success(IResultCode resultCode, String msg) {
        msg = MessageFormat.format(resultCode.getMessage(), msg);
        return new R<>(resultCode, msg);
    }

    /**
     * 返回R
     *
     * @param <T> T 泛型标记
     * @return R
     */
    public static <T> R<T> fail() {
        return new R<>(ShSupResultCodeEnum.FAILURE);
    }

    /**
     * 返回R
     *
     * @param msg 消息
     * @param <T> T 泛型标记
     * @return R
     */
    public static <T> R<T> fail(String msg) {
        return new R<>(ShSupResultCodeEnum.FAILURE, msg);
    }

    /**
     * 返回R
     *
     * @param code 业务响应码
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> R<T> fail(String code, String msg) {
        return new R<>(code, null, msg);
    }

    /**
     * 返回R
     *
     * @param code 业务响应码
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> R<T> fail(String code, String msg, T data) {
        return new R<>(code, data, msg);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务响应码
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> R<T> fail(IResultCode resultCode) {
        return new R<>(resultCode);
    }

    /**
     * 返回R
     *
     * @param resultCode 业务响应码
     * @param msg        消息
     * @param <T>        T 泛型标记
     * @return R
     */
    public static <T> R<T> fail(IResultCode resultCode, String msg) {
        msg = MessageFormat.format(resultCode.getMessage(), msg);
        return new R<>(resultCode, msg);
    }

    /**
     * 返回R
     *
     * @param code 业务响应码
     * @param data 数据
     * @param msg  消息
     * @param <T>  T 泛型标记
     * @return R
     */
    public static <T> R<T> fail(String code, T data, String msg) {
        return new R<>(code, data, msg);
    }

    /**
     * 分页查询时返回对象.
     *
     * @param data     数据
     * @param pageInfo 分页信息
     * @param <T>      T 泛型标记
     * @return
     */
    public static <T> R<T> page(T data, PageInfo pageInfo) {

        return new R<>(ShSupResultCodeEnum.SUCCESS.getCode(), data, pageInfo, ShSupResultCodeEnum.SUCCESS.getMessage());
    }

    /**
     * 分页查询时，带提示消息返回.
     *
     * @param data     数据
     * @param pageInfo 分页信息
     * @param msg      消息
     * @return
     */
    public static <T> R<T> page(T data, PageInfo pageInfo, String msg) {
        return new R<>(ShSupResultCodeEnum.SUCCESS.getCode(), data, pageInfo, msg);
    }

    /**
     * 分页查询时，带提示消息返回.
     *
     * @param resultCode 业务响应码
     * @param data       数据
     * @param pageInfo   分页信息
     * @param <T>        T 泛型标记
     * @return
     */
    public static <T> R<T> page(IResultCode resultCode, T data, PageInfo pageInfo) {
        R<T> response = new R<>(ShSupResultCodeEnum.SUCCESS, data);
        response.setPageInfo(pageInfo);

        return response;
    }

    /**
     * 分页查询时，带提示消息返回.
     *
     * @param code     业务响应码
     * @param data     数据
     * @param pageInfo 分页信息
     * @param msg      消息
     * @param <T>      T 泛型标记
     * @return
     */
    public static <T> R<T> page(String code, T data, PageInfo pageInfo, String msg) {
        return new R<>(code, data, pageInfo, msg);
    }
}