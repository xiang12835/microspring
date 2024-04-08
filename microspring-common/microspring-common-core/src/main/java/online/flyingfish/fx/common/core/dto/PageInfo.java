package online.flyingfish.fx.common.core.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
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
@ApiModel(description = "分页参数对象")
public class PageInfo {

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
     * 返回空页
     * @date 2021/9/7
     * @Notice 无
     */
    public static PageInfo emptyPageInfo() {
        PageInfo ret = new PageInfo();
        ret.setPageIndex(1);
        ret.setPageSize(10);
        ret.setTotal(0);
        ret.setPages(0);

        return ret;
    }
}