package online.flyingfish.fx.common.core.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 分页信息
 *
 * @since 2020-03-06
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "分页参数对象")
public class ShsupPageInfo extends BaseDTO {

    /**
     * 总数
     */
    private long total;
    /**
     * 每页显示条数
     */
    private long pageSize;

    /**
     * 当前页
     */
    private long pageIndex;

    /**
     * 页数
     */
    private long pages;

    /**
     * F
     * 将原始IPage转换成目标PageInfo.
     *
     * @param page 分页信息
     * @return
     */
    public static PageInfo instanceFrom(IPage page) {
        PageInfo ret = new PageInfo();
        ret.setPageIndex(page.getCurrent());
        ret.setPageSize(page.getSize());
        ret.setTotal(page.getTotal());
        ret.setPages(page.getPages());

        return ret;
    }
}