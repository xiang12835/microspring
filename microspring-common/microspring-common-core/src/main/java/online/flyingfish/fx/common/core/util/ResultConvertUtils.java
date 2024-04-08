/**
 * All rights reserved.
 * Created on 2021-09-17
 */
package online.flyingfish.fx.common.core.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 单元测试返回结果转换工具
 *
 * @date 2021-09-17
 * @Version V1.0
 * @Notice
 */
public class ResultConvertUtils {

    private ResultConvertUtils() {
    }

    /**
     * 解析返回参数
     *
     * @date 2021/9/17
     * @param object
     * @param tClass
     * @Notice 无
     */
    public static <T> T convertData(Object object, Class<T> tClass) {
        return JSONObject.toJavaObject((JSONObject) JSONObject.toJSON(object), tClass);
    }
    /**
     * 解析返回参数
     * @date 2021/9/26
     * @param object
     * @param tClass
     * @return java.util.List<T>
     * @Notice 无
     */
    public static <T> List<T> convertList(Object object, Class<T> tClass) {
        return JSONObject.parseArray(JSONObject.toJSONString(object), tClass);}

    /**
     * 解析返回参数object，object是List<T>类型
     * @date 2021/9/24
     * @param object
     * @param responseClass
     * @Notice 无
     */
    public static <T> List<T> convertResponse(Object object, Class<T> responseClass) {
        List<T> list = new ArrayList<>();
        for (Object obj : (List<?>) object) {
            list.add(JSONObject.parseObject(JSON.toJSONString(obj), responseClass));
        }
        return list;
    }
}
