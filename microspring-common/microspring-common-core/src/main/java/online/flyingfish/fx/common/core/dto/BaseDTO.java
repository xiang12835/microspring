package online.flyingfish.fx.common.core.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 自定义的DTO类的基类, 该类用于定义所有DTO类的共有和通用字段
 *
 * @version 1.0
 * @filename BaseDTO.java
 * @date 2020-10-25
 */
@Data
@ToString
@EqualsAndHashCode
public class BaseDTO implements Serializable, Cloneable {

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}