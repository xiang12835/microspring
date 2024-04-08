/**
 * All rights reserved.
 * Created on 2021-09-17
 */
package online.flyingfish.fx.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 对象属性名码值
 * @date 2021-09-17
 * @Version V1.0
 * @Notice
 */
@Getter
@AllArgsConstructor
public enum ObjectPropertyNameEnum {
    /**
     * 属性get方法
     */
    NAME_GET("get","get方法"),

    /**
     * 数量属性
     */
    REAL_FUEL_NUM("realFueNum","数量"),

    /**
     * 种类属性
     */
    REAL_FUEL_TYPE("realFuelType","种类"),

    /**
     * 地点属性
     */
    FUEL_LOCATION("fuelLocation","地点"),

    /**
     * 单价属性
     */
    FUEL_PRICE("fuelPrice","油单价"),

    /**
     * 负责人属性
     */
    FUEL_STAFF("fuelStaff","油企交易负责人"),

    /**
     * 企业号属性
     */
    ENTERPRISE_NO("enterpriseNo","企业号"),

    /**
     * 油密度属性
     */
    FUEL_DENSITY("fuelDensity","油密度"),

    /**
     * 应付款属性
     */
    FUEL_TOTAL_PRICE("fuelTotalPrice","应付款金额"),

    /**
     * 时间属性
     */
    FUEL_DATE("fuelDate","时间"),

    /**
     * 单位属性
     */
    FUEL_UNIT("fuelUnit","单位"),

    /**
     * 渠道属性
     */
    FUEL_CHL("fuelChl","渠道")
    ;
    /**
     * 代码
     */
    private String code;
    /**
     * 描述
     */
    private String message;

    /**
     * 根据code获取message
     * @date 2021/9/18
     * @param code
     * @return
     * @Notice 无
     */
    public static String getMessageByCode(String code) {
        for (ObjectPropertyNameEnum res : ObjectPropertyNameEnum.values()) {
            if(res.getCode().equals(code)){
                return res.getMessage();
            }
        }
        return null;
    }
}
