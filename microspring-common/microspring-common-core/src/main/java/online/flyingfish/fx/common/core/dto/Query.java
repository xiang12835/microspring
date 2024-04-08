package online.flyingfish.fx.common.core.dto;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 分页查询条件
 *
 * @date 2020-03-05
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "分页查询条件")
public class Query<T> extends BaseDTO {

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private Integer current;

    /**
     * 每页的数量
     */
    @ApiModelProperty(value = "每页的数量")
    private Integer size;

    /**
     * 查询条件数据
     */
    @ApiModelProperty(value = "查询条件数据")
    private T data;

    /**
     * 获取排序信息，排序的字段和正反序
     *
     * @return 排序信息
     */
    List<OrderItem> orders;
}