/**
 * All rights reserved.
 * Created on 2021-10-13
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description edb文件下载状态
 * @date 2021-10-13
 * @Version V1.0
 * @Notice
 */
@Getter
@AllArgsConstructor
public enum EdbDownloadStatusEnum {

    /**
     * EDB下载文件 1-成功
     */
    EDB_STATUS_SUCCESS("1"),

    /**
     * EDB下载文件 0-失败
     */
    EDB_STATUS_FAIL("0"),
    ;

    private String code;
}
