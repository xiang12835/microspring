package online.flyingfish.fx.common.core.util;

import com.google.common.base.Strings;
import online.flyingfish.fx.common.core.enums.SysCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 系统跟踪号、主键生成工具类
 *
 * @date 2020/3/9
 * @since 1.0.0
 */
@Slf4j
@Component
public class IdUtils {

    @Autowired(required = false)
    SnowflakeIdWorker idWorker;

    private AtomicLong sequence = new AtomicLong();
    public final static Long MAX_SEQ_NUM = 1000000L;
    public final static Long START_SEQ_NUM = 1L;

    /**
     * 1-合肥数据中心, 2-廊坊数据中心， 3-丰台数据中心，4-亦庄数据中心
     * 默认值 = 0
     */
    @Value("${ossip.data-center:0}")
    String serviceDataCenterCode;
    /**
     * 服务类别，默认值 = 00。
     * 01	网关服务
     * 02	业务服务
     * 03	行内接出服务
     * 04	三方接出服务
     * 05	调度服务
     * 06	管理端服务
     */
    @Value("${ossip.service-type:00}")
    String serviceTypeCode;
    /**
     * 服务实例编号，默认值 = 000
     */
    @Value("${ossip.instance-num:00}")
    String serviceInstanceNum;

    /**
     * 获取32位交易流水号(14位时间戳 + 18位雪花算法)
     *
     * @return 交易流水号
     */
    public String getTxSerialNo() {
        return getGlobalTraceNo();
    }

    /**
     * 获取32位交易流水号(14位会计时间戳 + 18位雪花算法)
     *
     * @return 交易流水号
     */
    public String getTxSerialNo(String accTime) {
        return getGlobalTraceNo(accTime);
    }

    /**
     * 获取指定长度流水号流水号(14位时间戳 + 18位雪花算法),
     * 建议不要获取低于18位的流水号，有重号风险
     *
     * @return 交易流水号
     */
    public String getId(int length) {
        // 获取18位雪花算法ID
        long snowFlakeId = idWorker.nextId();

        // 获取14位时间戳
        String timeStamp = DateUtils.now(DateUtils.YYYYMMDDHHMMSS);
        String id = StringUtils.right(timeStamp + snowFlakeId, length);
        return id;
    }

    /**
     * 获取32位系统跟踪(14位会计时间戳 + 7位源系统 + 5位发起交易实例序号 + 6位序列号)
     *
     * @return 表主键ID
     */
    public String getGlobalTraceNo(String AccTime) {
        // 获取14位时间戳
        String timeStamp = AccTime;

        // 获取7位系统号
        String sysCode = SysCodeEnum.OSSIP.getCode().substring(0, 7);

        // 获取5位发起交易实例序号（数据中心代码+服务类别+实例编号）
        String dataCenterCode = getPropertyValue("data_center_code", this.serviceDataCenterCode);
        String serviceType = getPropertyValue("service_type", this.serviceTypeCode);
        String serviceInstanceNum = getPropertyValue("service_instance_num", this.serviceInstanceNum);

        // 获取6位序列号
        sequence.compareAndSet(MAX_SEQ_NUM, START_SEQ_NUM);
        Long sequenceNum = sequence.getAndIncrement();

        StringBuilder globalTraceNo = new StringBuilder();
        globalTraceNo.append(timeStamp).append(sysCode).append(dataCenterCode).
                append(serviceType).append(serviceInstanceNum).append(StringUtils.leftPad(sequenceNum.toString(), 6, "0"));

        return globalTraceNo.toString();
    }

    /**
     * 获取32位系统跟踪(14位时间戳 + 7位源系统 + 5位发起交易实例序号 + 6位序列号)
     *
     * @return 表主键ID
     */
    public String getGlobalTraceNo() {
        // 获取14位时间戳
        String timeStamp = DateUtils.now(DateUtils.YYYYMMDDHHMMSS);

        // 获取7位系统号
        String sysCode = SysCodeEnum.OSSIP.getCode().substring(0, 7);

        // 获取5位发起交易实例序号（数据中心代码+服务类别+实例编号）
        String dataCenterCode = getPropertyValue("data_center_code", this.serviceDataCenterCode);
        String serviceType = getPropertyValue("service_type", this.serviceTypeCode);
        String serviceInstanceNum = getPropertyValue("service_instance_num", this.serviceInstanceNum);

        // 获取6位序列号
        sequence.compareAndSet(MAX_SEQ_NUM, START_SEQ_NUM);
        long sequenceNum = sequence.getAndIncrement();

        return timeStamp + sysCode + dataCenterCode +
                serviceType + serviceInstanceNum + StringUtils.leftPad(Long.toString(sequenceNum), 6, "0");
    }

    /**
     * 获取34位系统跟踪(11位系统号 + 8位时间戳 + 15位雪花算法)
     *
     * @return 表主键ID
     */
    public String getSysTrackNo() {
        // 获取18位雪花算法ID
        long snowFlakeId = idWorker.nextId();

        // 获取11位系统号
        String sysCode = SysCodeEnum.OSSIP.getCode();

        // 获取8位日期
        String timeStamp = DateUtils.now(DateUtils.YYYYMMDD);
        String id = sysCode + timeStamp + StringUtils.right(String.valueOf(snowFlakeId), 15);

        return id;
    }

    /**
     * 获取指定长度流水号流水号(8位时间戳 + 18位雪花算法),
     * 建议不要获取低于12位的流水号，有重号风险
     *
     * @return 交易流水号
     */
    public String getSeqNo(int length) {
        // 获取18位雪花算法ID
        long snowFlakeId = idWorker.nextId();

        // 获取8位时间戳
        String timeStamp = DateUtils.now(DateUtils.YYYYMMDD);
        String id = StringUtils.right(timeStamp + snowFlakeId, length);
        return id;
    }

    /**
     * 获取32位表主键(14位时间戳 + 18位雪花算法)
     *
     * @return 表主键ID
     */
    public String getTableId() {
        // 获取18位雪花算法ID
        long snowFlakeId = idWorker.nextId();
        // 获取14位时间戳
        String timeStamp = DateUtils.now(DateUtils.YYYYMMDDHHMMSS);
        String res = timeStamp + snowFlakeId;
        if (res.length() > 32) {
            res = res.substring(0,32);
        }
        return res;
    }

    /**
     * 校验是否是合法的交易流水号
     *
     * @param txSriNo 交易流水号
     * @return
     */
    public static boolean isValidSriNo(String txSriNo) {
        if (Strings.isNullOrEmpty(txSriNo)) {
            return false;
        }

        return txSriNo.length() == 32;
    }

    /**
     * 配置参数的取值逻辑:
     *  1. 系统的环境变量，如果没有
     *  2. 虚拟机VM的启动参数，如果没有
     *  3. 配置文件，如果没有
     *  4. 默认值
     *
     * @param propertyCode 参数名称/编码
     * @param defaultValue 如果没有取到值，需要设置一个默认值
     * @return
     */
    private String getPropertyValue(String propertyCode, String defaultValue){
        String resultStr = System.getenv(propertyCode);

        if(resultStr == null){
            resultStr = System.getProperty(propertyCode);
            if(resultStr == null){
                resultStr = defaultValue;
                log.debug("在环境变量和虚拟机的启动参数中，都没有找到{}，现在从参数文件中取值！"
                        , propertyCode);
            }
        }
        return resultStr;
    }

    /**
     * 获取数据中心编号 1-合肥数据中心, 2-廊坊数据中心， 3-丰台数据中心，4-亦庄数据中心
     * @date 2021/10/28
     * @Notice 无
     */
    public String getServiceDataCenterCode() {
        return this.serviceDataCenterCode;
    }
}
